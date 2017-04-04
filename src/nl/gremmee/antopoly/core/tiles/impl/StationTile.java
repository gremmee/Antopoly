package nl.gremmee.antopoly.core.tiles.impl;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.core.tiles.abs.PropertyTile;
import nl.gremmee.antopoly.players.IPlayer;

public class StationTile extends PropertyTile {

    public static final int RENT_ONE = 25;
    public static final int RENT_TWO = 50;
    public static final int RENT_THREE = 100;
    public static final int RENT_FOUR = 200;

    public StationTile(int aID, String aName) {
        super(aID, aName, TileType.TT_Station, 200);
    }

    @Override
    public void execute(IPlayer aCurrent) {
        System.out.println("Station");
        IPlayer owner = this.getOwner();
        if (owner == null) {
            buyProperty(aCurrent);
        } else {
            payRent(aCurrent, owner);
        }
        super.execute(aCurrent);
    }

    private void payRent(IPlayer aCurrent, IPlayer aOwner) {
        System.out.println("PayRent to " + aOwner.getName());
        int costs = 0;
        int numStations = numberOwnedStations(aOwner);
        switch (numStations) {
            case 1:
                costs = StationTile.RENT_ONE;
                break;
            case 2:
                costs = StationTile.RENT_TWO;
                break;
            case 3:
                costs = StationTile.RENT_THREE;
                break;
            case 4:
                costs = StationTile.RENT_FOUR;
                break;
        }
        costs *= Settings.MONEY_FACTOR;
        aCurrent.payMoney(costs);
        aOwner.receiveMoney(costs);
    }

    public int numberOwnedStations(IPlayer aOwner) {
        int owned = 0;
        for (ITile tile : aOwner.getTileList()) {
            if (tile instanceof StationTile) {
                owned++;
            }
        }
        return owned;
    }

}
