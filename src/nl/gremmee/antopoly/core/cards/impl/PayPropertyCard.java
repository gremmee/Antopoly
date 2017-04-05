package nl.gremmee.antopoly.core.cards.impl;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.cards.abs.Card;
import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.core.tiles.impl.FreeParkingTile;
import nl.gremmee.antopoly.core.tiles.impl.StreetTile;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.IPlayer;

public class PayPropertyCard extends Card {

    private int perHouse;
    private int perHotel;

    public PayPropertyCard(String aName, String aText, int aPerHouse, int aPerHotel) {
        super(aName, aText);
        this.setPerHouse(aPerHouse);
        this.setPerHotel(aPerHotel);
    }

    public int getPerHouse() {
        return perHouse;
    }

    public void setPerHouse(int aPerHouse) {
        this.perHouse = aPerHouse;
    }

    public int getPerHotel() {
        return perHotel;
    }

    public void setPerHotel(int aPerHotel) {
        this.perHotel = aPerHotel;
    }

    @Override
    public boolean excute(IPlayer aPlayer) {
        int houses = getHouses(aPlayer);
        int hotels = getHotels(aPlayer);

        int houseCosts = this.getPerHouse() * houses;
        int hotelCosts = this.getPerHotel() * hotels;

        int totalCosts = (houseCosts + hotelCosts) * Settings.MONEY_FACTOR;
        System.out.println("Pay per property " + totalCosts);
        aPlayer.payMoney(totalCosts);
        if (Initialize.getInstance().getSettings().isFreeParkingPot()) {
            FreeParkingTile tile = (FreeParkingTile) Initialize.getInstance().getTileList()
                    .getTileByName("Vrij parkeren");
            tile.addToPot(totalCosts);
        }

        return super.excute(aPlayer);
    }

    @Override
    protected boolean getKeepCard() {
        return false;
    }

    public int getHouses(IPlayer aPlayer) {
        int houses = 0;
        for (ITile tile : aPlayer.getTileList()) {
            if (tile instanceof StreetTile) {
                StreetTile street = (StreetTile) tile;
                if (street.getBuildings() < 5) {
                    houses += street.getBuildings();
                }
            }
        }
        return houses;
    }

    public int getHotels(IPlayer aPlayer) {
        int hotels = 0;
        for (ITile tile : aPlayer.getTileList()) {
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
