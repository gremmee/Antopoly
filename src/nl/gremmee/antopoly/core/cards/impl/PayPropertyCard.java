package nl.gremmee.antopoly.core.cards.impl;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.cards.abs.Card;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.impl.FreeParkingTile;
import nl.gremmee.antopoly.core.tiles.impl.StreetTile;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.players.impl.Owe;

public class PayPropertyCard extends Card {

    private int perHouse;
    private int perHotel;

    public PayPropertyCard(final String aName, final String aText, final int aPerHouse, final int aPerHotel) {
        super(aName, aText);
        this.setPerHouse(aPerHouse);
        this.setPerHotel(aPerHotel);
    }

    public int getPerHouse() {
        return this.perHouse;
    }

    public void setPerHouse(final int aPerHouse) {
        this.perHouse = aPerHouse;
    }

    public int getPerHotel() {
        return this.perHotel;
    }

    public void setPerHotel(final int aPerHotel) {
        this.perHotel = aPerHotel;
    }

    @Override
    public boolean execute(final IPlayer aPlayer) {
        int houses = getHouses(aPlayer);
        int hotels = getHotels(aPlayer);

        int houseCosts = this.getPerHouse() * houses;
        int hotelCosts = this.getPerHotel() * hotels;

        int totalCosts = (houseCosts + hotelCosts) * Settings.MONEY_FACTOR;
        System.out.println("Pay per property " + totalCosts);
        if (totalCosts > aPlayer.getMoney()) {
            Owe owe = aPlayer.getOwe();
            owe.setOwesTo(null);
            owe.setOwesMoney(totalCosts);
        } else {

            aPlayer.payMoney(totalCosts);
        }
        Initialize initialize = Initialize.getInstance();
        if (initialize.getSettings().isFreeParkingPot()) {
            FreeParkingTile tile = (FreeParkingTile) initialize.getTileList()
                    .getTileByName(Tiles.FREE_PARKING);
            tile.addToPot(totalCosts);
        }

        return super.execute(aPlayer);
    }

    @Override
    protected boolean getKeepCard() {
        return false;
    }

    private int getHouses(final IPlayer aPlayer) {
        int houses = 0;
        for (StreetTile street : aPlayer.getTileList().getStreetTiles()) {
            if (street.getBuildings() < 5) {
                houses += street.getBuildings();
            }
        }
        return houses;
    }

    private int getHotels(final IPlayer aPlayer) {
        int hotels = 0;
        for (StreetTile street : aPlayer.getTileList().getStreetTiles()) {
            if (street.getBuildings() >= 5) {
                hotels++;
            }
        }
        return hotels;
    }

}
