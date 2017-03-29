package nl.gremmee.antopoly.players;

import nl.gremmee.antopoly.Initialize;
import nl.gremmee.antopoly.core.DiceList;
import nl.gremmee.antopoly.core.RollList;
import nl.gremmee.antopoly.core.cards.CardAction;
import nl.gremmee.antopoly.core.cards.CardList;
import nl.gremmee.antopoly.core.cards.CardType;
import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.core.tiles.ChanceTile;
import nl.gremmee.antopoly.core.tiles.CommunityChestTile;
import nl.gremmee.antopoly.core.tiles.GotoJailTile;
import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.core.tiles.PropertyTile;
import nl.gremmee.antopoly.core.tiles.StationTile;
import nl.gremmee.antopoly.core.tiles.StreetTile;
import nl.gremmee.antopoly.core.tiles.TaxTile;
import nl.gremmee.antopoly.core.tiles.TileList;
import nl.gremmee.antopoly.core.tiles.UtilityTile;

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
    private boolean again;
    private int doubles;
    private boolean inJail;
    private int jailBreak;

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
        this.setAgain(false);
        this.setInJail(false);
        this.doubles = 0;
        this.jailBreak = 0;
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
            if (CardAction.CA_GetOutOfJail.equals(card.getCardAction())) {
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
                if (CardAction.CA_GetOutOfJail.equals(card.getCardAction())) {
                    removeCard(card);
                    CardType cardType = card.getCardType();
                    CardList cardList = CardType.CT_Chance.equals(cardType)
                            ? Initialize.getInstance().getChanceCardList()
                            : Initialize.getInstance().getCommunityChestCardList();
                    cardList.putBack(card);
                    this.setInJail(false);
                    this.jailBreak = 0;
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
        RollList rollList = null;
        // Getting out of jail
        if (this.isInJail()) {
            // TODO move to cardlist
            if (hasGetOutOfJailCard()) {
                useGetOutOfJailCard();

            } else {
                DiceList diceList = Initialize.getInstance().getDiceList();
                rollList = diceList.roll();
                if (rollList.isDouble()) {
                    this.setInJail(false);
                } else {
                    if (this.jailBreak >= 2) {
                        this.jailBreak = 0;
                        this.setInJail(false);
                        this.setMoney(this.getMoney() - 50);
                        System.out.println("Pay 50 to get out of jail");
                    } else {
                        this.jailBreak++;
                    }
                }
            }
        }
        if (!this.isInJail()) {
            if (rollList == null) {
                DiceList diceList = Initialize.getInstance().getDiceList();
                rollList = diceList.roll();
                this.setAgain(rollList.isDouble());
                if (this.doubles >= 3) {
                    System.out.println("JAIL TIME");
                }
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

            if (newTile instanceof PropertyTile) {
                System.out.println("Property");
                PropertyTile propertyTile = (PropertyTile) newTile;
                Player owner = propertyTile.getOwner();
                if (owner == null) {
                    buyProperty(propertyTile);

                } else if (owner.equals(this)) {
                    // My tile, do nothing

                } else {
                    if (propertyTile instanceof StreetTile) {
                        System.out.println("Street");
                        StreetTile streetTile = (StreetTile) propertyTile;
                        payRent(owner, streetTile);
                    } else if (propertyTile instanceof UtilityTile) {
                        System.out.println("Utility");
                        UtilityTile utilityTile = (UtilityTile) propertyTile;
                        payRent(owner, utilityTile, diceResult);
                    } else if (propertyTile instanceof StationTile) {
                        System.out.println("Station");
                        StationTile stationTile = (StationTile) propertyTile;
                        payRent(owner, stationTile);
                    }

                }
            } else if (newTile instanceof TaxTile) {
                System.out.println("Tax");
                TaxTile taxes = (TaxTile) newTile;
                int costs = taxes.getValue();
                this.setMoney(getMoney() - costs);

            } else if (newTile instanceof ChanceTile) {
                System.out.println(Initialize.getInstance().getChanceCardList());
                ICard card = Initialize.getInstance().getChanceCardList().pickTopCard();
                System.out.println("Chance " + card.getName());
                card.excute(this);
                if (card.isGetOutOfJailCard()) {
                    this.getCardList().add(card);
                    System.out.println("Store Get Out Of Jail Chance");
                } else {
                    Initialize.getInstance().getChanceCardList().putBack(card);
                }

            } else if (newTile instanceof CommunityChestTile) {
                System.out.println(Initialize.getInstance().getCommunityChestCardList());
                ICard card = Initialize.getInstance().getCommunityChestCardList().pickTopCard();
                System.out.println("Community " + card.getName());
                card.excute(this);
                if (card.isGetOutOfJailCard()) {
                    this.getCardList().add(card);
                    System.out.println("Store Get Out Of Jail Community Chest");
                } else {
                    Initialize.getInstance().getCommunityChestCardList().putBack(card);
                }
            } else if (newTile instanceof GotoJailTile) {
                this.setCurrentTile(Initialize.getInstance().getTileList().getTileByName("Jail"));
                this.setInJail(true);

            }
        }
        System.out.println("Money: " + getMoney());

    }

    private void payRent(Player aOwner, StationTile stationTile) {
        System.out.println("PayRent to " + aOwner.getName());
        int costs = 0;
        int numStations = numberOwnedStations(aOwner);
        switch (numStations) {
            case 1:
                costs = StationTile.PRICE_ONE;
                break;
            case 2:
                costs = StationTile.PRICE_TWO;
                break;
            case 3:
                costs = StationTile.PRICE_THREE;
                break;
            case 4:
                costs = StationTile.PRICE_FOUR;
                break;
        }
        aOwner.setMoney(aOwner.getMoney() + costs);
        this.setMoney(getMoney() - costs);
    }

    public int numberOwnedStations(Player aOwner) {
        int owned = 0;
        for (ITile tile : aOwner.getTileList()) {
            if (tile instanceof StationTile) {
                owned++;
            }
        }
        return owned;
    }

    private void payRent(Player aOwner, UtilityTile aUtility, int aDiceResult) {
        System.out.println("PayRent to " + aOwner.getName());
        int factor = hasBothUtilities(aOwner) ? UtilityTile.FACTOR_OWN_DOUBLE : UtilityTile.FACTOR_OWN_SINGLE;
        int costs = aDiceResult * factor;
        aOwner.setMoney(aOwner.getMoney() + costs);
        this.setMoney(getMoney() - costs);
    }

    public boolean hasBothUtilities(Player aOwner) {
        int utilities = 0;
        for (ITile tile : aOwner.getTileList()) {
            if (tile instanceof UtilityTile) {
                utilities++;
            }
        }
        return (utilities >= 2);
    }

    private void payRent(Player aOwner, StreetTile aStreet) {
        System.out.println("PayRent to " + aOwner.getName());
        int factor = hasMunicipality(aOwner, aStreet) ? 2 : 1;
        int rentValue = aStreet.getRent() * factor;
        aOwner.setMoney(aOwner.getMoney() + rentValue);
        this.setMoney(getMoney() - rentValue);

    }

    public boolean hasMunicipality(Player aOwner, StreetTile aStreet) {
        int complete = aStreet.getMunicipality().getSize();
        for (ITile tile : aOwner.getTileList()) {
            if (tile instanceof StreetTile) {
                StreetTile streetTile = (StreetTile) tile;
                if (streetTile.getMunicipality().equals(aStreet.getMunicipality())) {
                    complete--;
                }
            }
        }
        return (complete == 0);
    }

    private void buyProperty(PropertyTile aProperty) {
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
        setAgain(false);
        this.busted = aBusted;
    }

    @Override
    public String toString() {
        String name = this.getName();
        int money = this.getMoney();
        String busted = (this.isBusted() ? "BUSTED" : "active");
        String jail = (this.isInJail() ? "JAIL" : "free");
        return ("|" + name + ", " + money + ", " + busted + ", " + jail + "|");
    }

    public boolean isAgain() {
        return again;
    }

    public void setAgain(boolean aAgain) {
        this.doubles = aAgain ? ++this.doubles : 0;
        this.again = aAgain;
    }

    public boolean isInJail() {
        return inJail;
    }

    public void setInJail(boolean aInJail) {
        this.inJail = aInJail;
    }

    public int getJailBreak() {
        return jailBreak;
    }

    public void setJailBreak(int jailBreak) {
        this.jailBreak = jailBreak;
    }

}
