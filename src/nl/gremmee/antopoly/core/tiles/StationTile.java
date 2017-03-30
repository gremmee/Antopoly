package nl.gremmee.antopoly.core.tiles;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.players.IPlayer;

public class StationTile extends PropertyTile {

    private static final int RENT_ONE = 25;
    private static final int RENT_TWO = 50;
    private static final int RENT_THREE = 100;
    private static final int RENT_FOUR = 200;

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
        aOwner.setMoney(aOwner.getMoney() + costs);
        aCurrent.setMoney(aCurrent.getMoney() - costs);
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
