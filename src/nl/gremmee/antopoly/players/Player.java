package nl.gremmee.antopoly.players;

import nl.gremmee.antopoly.Initialize;
import nl.gremmee.antopoly.core.DiceList;
import nl.gremmee.antopoly.core.RollList;
import nl.gremmee.antopoly.core.cards.CardAction;
import nl.gremmee.antopoly.core.cards.CardList;
import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.core.tiles.Property;
import nl.gremmee.antopoly.core.tiles.Station;
import nl.gremmee.antopoly.core.tiles.Street;
import nl.gremmee.antopoly.core.tiles.TileList;
import nl.gremmee.antopoly.core.tiles.Utility;

public class Player implements IPlayer {
    private CardList cardList;
    private TileList tileList;
    private String name;
    private int id;
    private boolean active;
    private boolean winner;
    private ITile currentTile;
    private int money;
    private boolean busted;

    public Player(int aID, String aName) {
        this.setId(aID);
        this.setActive(false);
        this.setWinner(false);
        this.setBusted(false);
        this.setMoney(150);
        this.setName(aName);
        this.setCardList(new CardList());
        this.setTileList(new TileList());
        this.setCurrentTile(Initialize.getInstance().getTileList().getTileByName("Start"));
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean aActive) {
        this.active = aActive;
    }

    public CardList getCardList() {
        return cardList;
    }

    public boolean hasGetOutOfJailCard() {
        for (ICard card : this.cardList) {
            if (CardAction.CA_GetOutOfJail.equals(card.getCardType())) {
                return true;
            }
        }
        return false;
    }

    private void removeCard(ICard aCard) {
        this.cardList.remove(aCard);
    }

    public void useGetOutOfJailCard() {
        assert hasGetOutOfJailCard() : "Cannot use what you do not have!";
        if (hasGetOutOfJailCard()) {
            for (ICard card : this.cardList) {
                if (CardAction.CA_GetOutOfJail.equals(card.getCardType())) {
                    removeCard(card);
                    break;
                }
            }
        }
    }

    private void setCardList(CardList cardList) {
        this.cardList = cardList;
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        this.name = aName;
    }

    public int getId() {
        return id;
    }

    public void setId(int aID) {
        this.id = aID;
    }

    public TileList getTileList() {
        return tileList;
    }

    public void setTileList(TileList aTileList) {
        this.tileList = aTileList;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean aWinner) {
        this.winner = aWinner;
    }

    @Override
    public void play() {
        System.out.println("Money: " + getMoney());
        // TODO: use AI
        int doubles = 0;
        DiceList diceList = Initialize.getInstance().getDiceList();
        RollList rollList = diceList.roll();
        if (rollList.isDouble()) {
            doubles++;
        }
        int diceResult = rollList.getResult();
        System.out.println("Rolled " + diceResult);

        int id = this.currentTile.getID();
        int calculatedResult = id + diceResult;
        System.out.println(id);
        System.out.println(calculatedResult);
        if (calculatedResult >= 40) {
            // pass Start
            System.out.println("Pass start");
            this.setMoney(this.getMoney() + 200);
        }
        int newID = calculatedResult % 40;

        System.out.println(id + ", " + newID);
        System.out.println(Initialize.getInstance().getTileList());
        ITile newTile = Initialize.getInstance().getTileList().getTileByID(newID);
        System.out.println("Goto : " + newTile.getName());
        setCurrentTile(newTile);

        if (newTile instanceof Property) {
            System.out.println("Property");
            Property property = (Property) newTile;
            Player owner = property.getOwner();
            if (owner == null) {
                buyProperty(property);

            } else if (owner.equals(this)) {
                // My tile, do nothing

            } else {
                if (property instanceof Street) {
                    System.out.println("Street");
                    Street street = (Street) property;
                    payRent(owner, street);
                } else if (property instanceof Utility){
                    System.out.println("Utility");
                    Utility utility = (Utility) property;
                    payRent(owner, utility, diceResult);
                } else if (property instanceof Station){
                    System.out.println("Station");
                    Station station = (Station) property;
                    payRent(owner, station);
                }

            }
        }
        System.out.println("Money: " + getMoney());

    }

    private void payRent(Player aOwner, Station station) {
        System.out.println("PayRent to " + aOwner.getName());
        int costs = 0;
        int numStations = numberOwnedStations(aOwner);
        switch (numStations) {
            case 1:
                costs = Station.PRICE_ONE;
                break;
            case 2:
                costs = Station.PRICE_TWO;
                break;
            case 3:
                costs = Station.PRICE_THREE;
                break;
            case 4:
                costs = Station.PRICE_FOUR;
                break;
        }
        aOwner.setMoney(aOwner.getMoney() + costs);
        this.setMoney(getMoney() - costs);
    }
    
    public int numberOwnedStations(Player aOwner)
    {
        int owned = 0;
        for (ITile tile : aOwner.getTileList()) {
            if (tile instanceof Station)
            {
                owned++;
            }
        }
        return owned;
    }

    private void payRent(Player aOwner, Utility aUtility, int aDiceResult) {
        System.out.println("PayRent to " + aOwner.getName());
        int factor = hasBothUtilities(aOwner) ? Utility.FACTOR_OWN_DOUBLE : Utility.FACTOR_OWN_SINGLE;
        int costs = aDiceResult * factor;
        aOwner.setMoney(aOwner.getMoney() + costs);
        this.setMoney(getMoney() - costs);
    }

    public boolean hasBothUtilities(Player aOwner)
    {
        int utilities = 0;
        for (ITile tile : aOwner.getTileList()) {
            if (tile instanceof Utility)
            {
                utilities++;
            }
        }
        return (utilities >= 2);
    }
    
    private void payRent(Player aOwner, Street aStreet) {
        System.out.println("PayRent to " + aOwner.getName());
        int rentValue = aStreet.getRent();
        aOwner.setMoney(aOwner.getMoney() + rentValue);
        this.setMoney(getMoney() - rentValue);

    }

    private void buyProperty(Property aProperty) {
        System.out.println("Buy Property " + aProperty.getName());
        int value = aProperty.getValue();
        if (this.getMoney() > value) {
            this.tileList.add(aProperty);
            int tileValue = aProperty.getValue();
            aProperty.setOwner(this);
            System.out.println("tileValue " + tileValue);
            setMoney(getMoney() - tileValue);
        } else {
            System.out.println("Not enough money!");
        }
    }

    public ITile getCurrentTile() {
        return currentTile;
    }

    public void setCurrentTile(ITile aCurrentTile) {
        assert aCurrentTile != null : "aCurrentTile cannot be null!";
        this.currentTile = aCurrentTile;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int aMoney) {
        this.money = aMoney;
    }

    public boolean isBusted() {
        return busted;
    }

    public void setBusted(boolean aBusted) {
        this.busted = aBusted;
    }

    @Override
    public String toString() {
        return this.getName() + ", " + this.getMoney() + ", " + (this.isBusted() ? "B" : "A");
    }

}
