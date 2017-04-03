package nl.gremmee.antopoly.players.impl;

import java.util.Objects;

import nl.gremmee.antopoly.Initialize;
import nl.gremmee.antopoly.Money;
import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.cards.CardType;
import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.core.cards.impl.GetOutOfJailCard;
import nl.gremmee.antopoly.core.lists.CardList;
import nl.gremmee.antopoly.core.lists.DiceList;
import nl.gremmee.antopoly.core.lists.MunicipalityList;
import nl.gremmee.antopoly.core.lists.RollList;
import nl.gremmee.antopoly.core.lists.TileList;
import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.core.tiles.impl.StreetTile;
import nl.gremmee.antopoly.players.IPlayer;

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
    private int doubles;
    private boolean inJail;
    private int jailBreak;
    private RollList rollList;

    public Player(int aID, String aName) {
        this.setId(aID);
        this.setActive(false);
        this.setWinner(false);
        this.setBusted(false);
        this.setMoney(Money.PRICE_INITIAL_MONEY);
        this.setName(aName);
        this.setCardList(new CardList());
        this.setTileList(new TileList());
        this.setAgain(false);
        this.setInJail(false);
        this.rollList = null;
        this.doubles = 0;
        this.jailBreak = 0;
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

    public void setRollList(RollList aRollList) {
        this.rollList = aRollList;
    }

    @Override
    public void play() {
        System.out.println("Money: " + getMoney());
        // TODO: use AI

        // Getting out of jail
        if (this.isInJail()) {
            // TODO move to cardlist
            if (hasGetOutOfJailCard()) {
                useGetOutOfJailCard();

            } else {
                DiceList diceList = Initialize.getInstance().getDiceList();
                this.rollList = diceList.roll();
                if (this.rollList.isDouble()) {
                    this.setInJail(false);
                } else {
                    if (this.jailBreak >= 2) {
                        this.jailBreak = 0;
                        this.setInJail(false);
                        this.setMoney(this.getMoney() - Money.PRICE_GET_OUT_OF_JAIL);
                        System.out.println("Pay to get out of jail " + Money.PRICE_GET_OUT_OF_JAIL);
                    } else {
                        this.jailBreak++;
                    }
                }
            }
        }
        if (!this.isInJail()) {
            if (this.rollList == null) {
                DiceList diceList = Initialize.getInstance().getDiceList();
                this.rollList = diceList.roll();
                this.setAgain(this.rollList.isDouble());
                if (this.doubles >= 3) {
                    System.out.println("JAIL TIME");
                }
            }
            int diceResult = this.rollList.getResult();
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
            System.out.println("Goto : " + newTile.getName());
            setCurrentTile(newTile);

            newTile.execute(this);

            // Try to buy houses
            for (ITile tile : this.getTileList()) {
                if (tile instanceof StreetTile) {
                    StreetTile street = (StreetTile) tile;
                    if (street.hasMunicipality(this, street)) {
                        MunicipalityList municipalityList = street.getMunicipality(this.getTileList(), street);
                        for (StreetTile municipalityTile : municipalityList) {
                            int housePrice = municipalityTile.getMunicipality().getHousePrice();
                            if (this.getMoney() > housePrice) {
                                buyHouse(municipalityTile);
                            }
                        }
                    }
                }
            }

        }

        System.out.println("Money: " + getMoney());
        this.rollList = null;

    }

    private void buyHouse(StreetTile aStreet) {
        if (aStreet.getBuildings() < 5) {
            aStreet.buyHouse();
            this.setMoney(this.getMoney() - (aStreet.getMunicipality().getHousePrice() * Settings.MONEY_FACTOR));
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

    @Override
    public int getHouses() {
        int houses = 0;
        for (ITile tile : this.getTileList()) {
            if (tile instanceof StreetTile) {
                StreetTile street = (StreetTile) tile;
                if (street.getBuildings() < 5) {
                    houses += street.getBuildings();
                }
            }
        }
        return houses;
    }

    @Override
    public int getHotels() {
        int hotels = 0;
        for (ITile tile : this.getTileList()) {
            if (tile instanceof StreetTile) {
                StreetTile street = (StreetTile) tile;
                if (street.getBuildings() >= 5) {
                    hotels++;
                }
            }
        }
        return hotels;
    }

}
