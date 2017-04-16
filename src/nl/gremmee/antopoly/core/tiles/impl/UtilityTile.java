package nl.gremmee.antopoly.core.tiles.impl;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.abs.PropertyTile;
import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.players.impl.Owe;

public class UtilityTile extends PropertyTile {

    public static final int FACTOR_OWN_SINGLE = 4;
    public static final int FACTOR_OWN_DOUBLE = 10;

    public UtilityTile(Tiles aTiles) {
        super(aTiles, TileType.TT_Utility, 150);
    }

    @Override
    public void execute(final IPlayer aPlayer) {
        System.out.println("Landing on Utility");
        super.execute(aPlayer);
    }

    @Override
    protected void payRent(final IPlayer aPlayer, final IPlayer aOwner) {
        if (!this.isMortgage()) {
            System.out.println("PayRent to " + aOwner.getName());
            int factor = hasBothUtilities(aOwner) ? UtilityTile.FACTOR_OWN_DOUBLE : UtilityTile.FACTOR_OWN_SINGLE;
            int diceResult = aPlayer.getRollList().getResult();
            int costs = diceResult * factor * Settings.MONEY_FACTOR;
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

    public boolean hasBothUtilities(final IPlayer aOwner) {
        return (aOwner.getTileList().getUtilityTiles().size() >= 2);
    }
}
