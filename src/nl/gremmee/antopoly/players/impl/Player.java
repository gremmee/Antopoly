package nl.gremmee.antopoly.players.impl;

import java.util.Objects;

import nl.gremmee.antopoly.Money;
import nl.gremmee.antopoly.core.cards.CardType;
import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.core.cards.impl.GetOutOfJailCard;
import nl.gremmee.antopoly.core.lists.CardList;
import nl.gremmee.antopoly.core.lists.DiceList;
import nl.gremmee.antopoly.core.lists.RollList;
import nl.gremmee.antopoly.core.lists.TileList;
import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.impl.FreeParkingTile;
import nl.gremmee.antopoly.core.tiles.impl.StreetTile;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.players.ai.IArtificialIntelligence;
import nl.gremmee.antopoly.statistics.ICollector;
import nl.gremmee.antopoly.statistics.InitializeStatistics;

public class Player implements IPlayer, Cloneable {
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
    private boolean inJail;
    private int jailBreakTries;
    private RollList rollList;
    private DiceList diceList;
    private IArtificialIntelligence artificialIntelligence;

    public Player(int aID, String aName) {
        this(aID, aName, Initialize.getInstance().getArtificialIntelligenceList().getAIByName("AIAggressive"));
    }

    public Player(int aID, String aName, IArtificialIntelligence aArtificialIntelligence) {
        this.setId(aID);
        this.diceList = Initialize.getInstance().getDiceList();
        this.rollList = new RollList();
        this.setActive(false);
        this.setWinner(false);
        this.setBusted(false);
        this.setArtificialIntelligence(aArtificialIntelligence);
        this.setMoney(Money.PRICE_INITIAL_MONEY);
        this.setName(aName);
        this.setCardList(new CardList());
        this.setTileList(new TileList());
        this.setAgain(false);
        this.setInJail(false);
        // this.doubles = 0;
        this.jailBreakTries = 0;
    }

    @Override
    public boolean equals(Object aOther) {
        // self check
        if (this == aOther)
            return true;
        // null check
        if (aOther == null)
            return false;
        // type check and cast
        if (getClass() != aOther.getClass())
            return false;
        Player player = (Player) aOther;
        // field comparison
        // TODO: Extends fields
        return Objects.equals(name, player.name) && Objects.equals(inJail, player.inJail)
                && Objects.equals(active, player.active);
    }

    @Override
    public Player clone() throws CloneNotSupportedException {
        return (Player) super.clone();
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
            if (card instanceof GetOutOfJailCard) {
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
                if (card instanceof GetOutOfJailCard) {
                    removeCard(card);
                    CardType cardType = card.getCardType();
                    CardList cardList = CardType.CT_Chance.equals(cardType)
                            ? Initialize.getInstance().getChanceCardList()
                            : Initialize.getInstance().getCommunityChestCardList();
                    cardList.putBack(card);
                    this.setInJail(false);
                    this.jailBreakTries = 0;
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

    public void setRollList(RollList aRollList) {
        this.rollList = aRollList;
    }

    @Override
    public void play() {
        System.out.println("Money: " + getMoney());

        // Getting out of jail
        if (this.isInJail()) {
            // TODO move to cardlist
            if (hasGetOutOfJailCard()) {
                useGetOutOfJailCard();

            } else {

                this.rollList = diceList.roll();
                if (this.rollList.isDouble()) {
                    this.setInJail(false);
                } else {
                    if (artificialIntelligence.executeGetOutOfJail()) {
                        getOutOfJail();
                    } else {
                        if (this.jailBreakTries >= 2) {
                            getOutOfJail();
                        } else {
                            this.jailBreakTries++;
                        }
                    }
                }
            }
        }
        Initialize.getInstance().executeRules(this);
        if (!this.isInJail()) {
            int diceResult = this.rollList.getResult();
            if (diceResult == 0) {
                this.rollList = diceList.roll();
                diceResult = this.rollList.getResult();
            }
            System.out.println("Rolled " + diceResult);

            int id = this.currentTile.getID();
            int calculatedResult = id + diceResult;

            if (calculatedResult >= Initialize.getInstance().getTileList().size()) {
                // pass Start
                System.out.println("Pass start");
                this.setMoney(this.getMoney() + Money.PRICE_PASS_START);
            }
            int newID = calculatedResult % Initialize.getInstance().getTileList().size();

            System.out.println(id + " => " + newID);
            System.out.println(Initialize.getInstance().getTileList());
            ITile newTile = Initialize.getInstance().getTileList().getTileByID(newID);
            System.out.println("Goto : " + newTile);
            setCurrentTile(newTile);

            newTile.execute(this);

            artificialIntelligence.executeBuyHouses(this);

        }
        System.out.println("Money: " + getMoney());
        this.rollList = null;
        Initialize.getInstance().executeRules(this);

    }

    private void getOutOfJail() {
        System.out.println("Pay to get out of jail " + Money.PRICE_GET_OUT_OF_JAIL);
        this.jailBreakTries = 0;
        this.setInJail(false);
        this.payMoney(Money.PRICE_GET_OUT_OF_JAIL);
        if (Initialize.getInstance().getSettings().isFreeParkingPot()) {
            FreeParkingTile tile = (FreeParkingTile) Initialize.getInstance().getTileList()
                    .getTileByName(Tiles.FREE_PARKING);
            tile.addToPot(Money.PRICE_GET_OUT_OF_JAIL);
        }
    }

    public void receiveMoney(int aMoney) {
        this.money += aMoney;
    }

    public void payMoney(int aMoney) {
        this.money -= aMoney;
    }

    public ITile getCurrentTile() {
        return currentTile;
    }

    public void setCurrentTile(ITile aCurrentTile) {
        assert aCurrentTile != null : "aCurrentTile cannot be null!";
        this.currentTile = aCurrentTile;
        ICollector collector = InitializeStatistics.getInstance().getCollectorList().getTileCollector();
        collector.collect(this);
    }

    public int getMoney() {
        return money;
    }

    private void setMoney(int aMoney) {
        this.money = aMoney;
    }

    public void resetMoney() {
        this.money = 0;
    }

    public RollList getRollList() {
        return this.rollList;
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
        int value = this.getValue();
        String busted = (this.isBusted() ? "BUSTED" : "active");
        String jail = (this.isInJail() ? "JAIL" : "free");
        return ("|" + name + ", " + money + ", " + value + ", " + busted + ", " + jail + "|");
    }

    public int getValue() {
        int totalValue = this.getMoney();
        totalValue += this.getHousesValue();
        totalValue += this.getHotelsValue();
        return totalValue;
    }

    public boolean isAgain() {
        return again;
    }

    public void setAgain(boolean aAgain) {
        int doubles = (aAgain == true) ? this.rollList.increaseDoubles() : this.rollList.resetDoubles();
        this.again = aAgain;
    }

    public RollList roll() {
        this.rollList = diceList.roll();
        return this.rollList;
    }

    public boolean isInJail() {
        return inJail;
    }

    public void setInJail(boolean aInJail) {
        this.inJail = aInJail;
    }

    private void setJailBreak(int jailBreak) {
        this.jailBreakTries = jailBreak;
    }

    public IArtificialIntelligence getArtificialIntelligence() {
        return artificialIntelligence;
    }

    private void setArtificialIntelligence(IArtificialIntelligence aArtificialIntelligence) {
        this.artificialIntelligence = aArtificialIntelligence;
    }

    public int getHousesValue() {
        int value = 0;
        for (ITile tile : this.getTileList()) {
            if (tile instanceof StreetTile) {
                StreetTile street = (StreetTile) tile;
                if (street.getBuildings() > 0 && street.getBuildings() < 5) {
                    value += (street.getBuildings() * street.getMunicipality().getHousePrice());
                }
            }
        }
        return value;
    }

    public int getHotelsValue() {
        int value = 0;
        for (ITile tile : this.getTileList()) {
            if (tile instanceof StreetTile) {
                StreetTile street = (StreetTile) tile;
                if (street.getBuildings() >= 5) {
                    value += street.getMunicipality().getHousePrice();
                }
            }
        }
        return value;
    }

}
