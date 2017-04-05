package nl.gremmee.antopoly.core.tiles.impl;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.abs.PropertyTile;
import nl.gremmee.antopoly.players.IPlayer;

public class UtilityTile extends PropertyTile {

    public static final int FACTOR_OWN_SINGLE = 4;
    public static final int FACTOR_OWN_DOUBLE = 10;

    public UtilityTile(Tiles aTiles) {
        super(aTiles, TileType.TT_Utility, 150);
    }

    @Override
    public void execute(IPlayer aPlayer) {
        System.out.println("Utility");
        IPlayer owner = this.getOwner();
        if (owner == null) {
            buyProperty(aPlayer);
        } else {
            payRent(aPlayer, owner);
        }
        super.execute(aPlayer);
    }

    private void payRent(IPlayer aPlayer, IPlayer aOwner) {
        System.out.println("PayRent to " + aOwner.getName());
        int factor = hasBothUtilities(aOwner) ? UtilityTile.FACTOR_OWN_DOUBLE : UtilityTile.FACTOR_OWN_SINGLE;
        int diceResult = aPlayer.getRollList().getResult();
        int costs = diceResult * factor * Settings.MONEY_FACTOR;
        aPlayer.payMoney(costs);
        aOwner.receiveMoney(costs);
    }

    public boolean hasBothUtilities(IPlayer aOwner) {
        int utilities = 0;
        for (ITile tile : aOwner.getTileList()) {
            if (tile instanceof UtilityTile) {
                utilities++;
            }
        }
        return (utilities >= 2);
    }
}
