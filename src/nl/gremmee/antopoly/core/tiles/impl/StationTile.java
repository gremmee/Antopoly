package nl.gremmee.antopoly.core.tiles.impl;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.abs.PropertyTile;
import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.players.impl.Owe;

public class StationTile extends PropertyTile {

    public static final int RENT_ONE = 25;
    public static final int RENT_TWO = 50;
    public static final int RENT_THREE = 100;
    public static final int RENT_FOUR = 200;

    public StationTile(final Tiles aTiles) {
        super(aTiles, TileType.TT_Station, 200);
    }

    @Override
    public void execute(final IPlayer aPlayer) {
        System.out.println("Landing on Station");
        super.execute(aPlayer);
    }

    @Override
    protected void payRent(final IPlayer aPlayer, final IPlayer aOwner) {
        if (!this.isMortgage()) {
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
            Owe owe = aPlayer.getOwe();
            if (costs > aPlayer.getMoney()) {
                owe.setOwesTo(aOwner);
                owe.setOwesMoney(costs);
            } else {
                aPlayer.payMoney(costs);
                aOwner.receiveMoney(costs);
                owe.resetOwe();
            }
        } else {
            System.out.println(this + " is mortaged");
        }
    }

    public int numberOwnedStations(final IPlayer aOwner) {
        return aOwner.getTileList().getStationTiles().size();
    }

}
