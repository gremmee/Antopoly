package nl.gremmee.antopoly.core.tiles;

import nl.gremmee.antopoly.players.Player;

public class StationTile extends PropertyTile {

    public static final int PRICE_ONE = 25;
    public static final int PRICE_TWO = 50;
    public static final int PRICE_THREE = 100;
    public static final int PRICE_FOUR = 200;

    public StationTile(int aID, String aName) {
        super(aID, aName, TileType.TT_Station, 200);
    }

    @Override
    public void execute(Player aCurrent) {
        System.out.println("Station");
        Player owner = this.getOwner();
        if (owner == null) {
            buyProperty(aCurrent);
        } else {
            payRent(aCurrent, owner);
        }

    }

    private void payRent(Player aCurrent, Player aOwner) {
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
        aCurrent.setMoney(aCurrent.getMoney() - costs);
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

}
