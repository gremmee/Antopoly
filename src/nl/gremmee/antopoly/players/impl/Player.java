package nl.gremmee.antopoly.players.impl;

import java.math.BigDecimal;
import java.util.Objects;

import nl.gremmee.antopoly.Money;
import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.cards.CardType;
import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.core.cards.impl.GetOutOfJailCard;
import nl.gremmee.antopoly.core.lists.CardList;
import nl.gremmee.antopoly.core.lists.DiceList;
import nl.gremmee.antopoly.core.lists.RollList;
import nl.gremmee.antopoly.core.lists.TileList;
import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.abs.PropertyTile;
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
    private Owe owe;

    public Player(final int aID, final String aName) {
        this(aID, aName, Initialize.getInstance().getArtificialIntelligenceList().getAIByName("AIAggressive"));
    }

    public Player(final int aID, final String aName, final IArtificialIntelligence aArtificialIntelligence) {
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
        this.jailBreakTries = 0;
        this.setOwe(new Owe(null, 0));
    }

    @Override
    public boolean hasMortgages() {
        for (PropertyTile propertiesTile : getTileList().getPropertyTiles()) {
            if (propertiesTile.isMortgage()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(final Object aOther) {
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
        return Objects.equals(this.name, player.name) && Objects.equals(this.inJail, player.inJail)
                && Objects.equals(this.active, player.active);
    }

    @Override
    public Player clone() throws CloneNotSupportedException {
        return (Player) super.clone();
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(final boolean aActive) {
        this.active = aActive;
    }

    public CardList getCardList() {
        return this.cardList;
    }

    public boolean hasGetOutOfJailCard() {
        return this.cardList.getOutOfJailCards().size() > 0;
    }

    private void removeCard(final ICard aCard) {
        this.cardList.remove(aCard);
    }

    public void useGetOutOfJailCard() {
        assert hasGetOutOfJailCard() : "Cannot use what you do not have!";
        if (hasGetOutOfJailCard()) {
            for (GetOutOfJailCard getOutOfJailCard : this.cardList.getOutOfJailCards()) {
                removeCard(getOutOfJailCard);
                CardType cardType = getOutOfJailCard.getCardType();
                Initialize initialize = Initialize.getInstance();
                CardList cardList = CardType.CT_Chance.equals(cardType) ? initialize.getChanceCardList()
                        : initialize.getCommunityChestCardList();
                cardList.putBack(getOutOfJailCard);
                this.setInJail(false);
                this.jailBreakTries = 0;
                break;
            }
        }
    }

    private void setCardList(final CardList cardList) {
        this.cardList = cardList;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String aName) {
        this.name = aName;
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int aID) {
        this.id = aID;
    }

    public void addTile(final PropertyTile aTile) {
        this.tileList.add(aTile);
        aTile.setOwner(this);

    }

    public TileList getTileList() {
        return this.tileList;
    }

    public void setTileList(final TileList aTileList) {
        this.tileList = aTileList;
    }

    public boolean isWinner() {
        return this.winner;
    }

    public void setWinner(final boolean aWinner) {
        this.winner = aWinner;
    }

    public void setRollList(final RollList aRollList) {
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

                this.rollList = this.diceList.roll();
                if (this.rollList.isDouble()) {
                    this.setInJail(false);
                } else {
                    if (this.artificialIntelligence.executeGetOutOfJail()) {
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
        Initialize initialize = Initialize.getInstance();
        initialize.executeRules(this);
        if (!this.isInJail()) {
            int diceResult = this.rollList.getResult();
            if (diceResult == 0) {
                this.rollList = diceList.roll();
                diceResult = this.rollList.getResult();
            }
            System.out.println("Rolled " + diceResult);

            int currentTileID = this.currentTile.getID();
            int calculatedResult = currentTileID + diceResult;

            TileList tileList = initialize.getTileList();
            if (calculatedResult >= tileList.size()) {
                // pass Start
                System.out.println("Pass start");
                this.receiveMoney(Money.PRICE_PASS_START);
            }
            int newID = calculatedResult % tileList.size();

            System.out.println(currentTileID + " => " + newID);
            System.out.println(tileList);
            ITile newTile = tileList.getTileByID(newID);
            System.out.println("Goto : " + newTile);
            setCurrentTile(newTile);

            newTile.execute(this);

            artificialIntelligence.executeBuyHouses(this);

        }
        System.out.println("Money: " + getMoney());
        initialize.executeRules(this);
        this.rollList = null;

    }

    private void getOutOfJail() {
        System.out.println("Pay to get out of jail " + Money.PRICE_GET_OUT_OF_JAIL);
        this.jailBreakTries = 0;
        this.setInJail(false);
        this.payMoney(Money.PRICE_GET_OUT_OF_JAIL);
        Initialize initialize = Initialize.getInstance();
        if (initialize.getSettings().isFreeParkingPot()) {
            FreeParkingTile tile = (FreeParkingTile) initialize.getTileList().getTileByName(Tiles.FREE_PARKING);
            tile.addToPot(Money.PRICE_GET_OUT_OF_JAIL);
        }
    }

    public void receiveMoney(final int aMoney) {
        this.money += aMoney;
    }

    public void payMoney(final int aMoney) {
        this.money -= aMoney;
    }

    public ITile getCurrentTile() {
        return this.currentTile;
    }

    public void setCurrentTile(final ITile aCurrentTile) {
        assert aCurrentTile != null : "aCurrentTile cannot be null!";
        this.currentTile = aCurrentTile;
        ICollector collector = InitializeStatistics.getInstance().getCollectorList().getTileCollector();
        collector.collect(this);
    }

    public int getMoney() {
        return this.money;
    }

    private void setMoney(final int aMoney) {
        this.money = aMoney;
    }

    public void resetMoney() {
        this.money = 0;
    }

    public RollList getRollList() {
        return this.rollList;
    }

    public boolean isBusted() {
        return this.busted;
    }

    public void setBusted(final boolean aBusted) {
        setAgain(false);
        this.busted = aBusted;
    }

    @Override
    public String toString() {
        String name = this.name;
        int money = this.money;
        int value = this.getValue();
        String busted = (this.isBusted() ? "BUSTED" : "active");
        String jail = (this.isInJail() ? "JAIL" : "free");
        return ("|" + name + ", " + money + ", " + value + ", " + busted + ", " + jail + "|");
    }

    public int getValue() {
        int totalValue = this.getMoney();
        totalValue += this.getPropertiesValue();
        totalValue += this.getHousesValue();
        totalValue += this.getHotelsValue();
        totalValue += this.getOutOfJailCardsValue();
        return totalValue;
    }

    public boolean isAgain() {
        return this.again;
    }

    public void setAgain(final boolean aAgain) {
        int doubles = (aAgain == true) ? this.rollList.increaseDoubles() : this.rollList.resetDoubles();
        this.again = aAgain;
    }

    public RollList roll() {
        this.rollList = diceList.roll();
        return this.rollList;
    }

    public boolean isInJail() {
        return this.inJail;
    }

    public void setInJail(final boolean aInJail) {
        this.inJail = aInJail;
    }

    public IArtificialIntelligence getArtificialIntelligence() {
        return this.artificialIntelligence;
    }

    private void setArtificialIntelligence(final IArtificialIntelligence aArtificialIntelligence) {
        this.artificialIntelligence = aArtificialIntelligence;
    }

    public int getHousesValue() {
        int value = 0;
        for (StreetTile street : this.getTileList().getStreetTiles()) {
            int buildings = street.getBuildings();
            if (buildings > 0 && buildings < 5) {
                value += (buildings * (street.getMunicipality().getHousePrice() / 2));
            }
        }
        return value;
    }

    public int getHotelsValue() {
        int value = 0;
        for (StreetTile street : this.getTileList().getStreetTiles()) {
            if (street.getBuildings() >= 5) {
                value += (street.getMunicipality().getHousePrice() / 2) * 5;
            }
        }
        return value;
    }

    private int getOutOfJailCardsValue() {
        return this.getCardList().getOutOfJailCards().size() * Money.PRICE_GET_OUT_OF_JAIL_CARD;
    }

    private int getPropertiesValue() {
        int value = 0;
        for (PropertyTile property : this.getTileList().getPropertyTiles()) {
            value += Settings.MORTAGE_FACTOR.multiply(BigDecimal.valueOf(property.getValue())).intValue();
        }
        return value;
    }

    public Owe getOwe() {
        return this.owe;
    }

    public void setOwe(final Owe aOwe) {
        this.owe = aOwe;
    }

}
