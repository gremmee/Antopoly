package nl.gremmee.antopoly.core.tiles.impl;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.abs.Tile;
import nl.gremmee.antopoly.players.IPlayer;

public class TaxPercentageTile extends Tile {

    private int percentage;

    public TaxPercentageTile(final Tiles aTiles, final int aPercentage) {
        super(aTiles, TileType.TT_TaxesPercentage);
        this.setPercentage(aPercentage);
    }

    public int getPercentage() {
        return this.percentage;
    }

    private void setPercentage(final int aValue) {
        this.percentage = aValue;
    }

    @Override
    public void execute(final IPlayer aPlayer) {
        int costs = ((aPlayer.getMoney() * this.getPercentage()) / 100) * Settings.MONEY_FACTOR;
        System.out.println("Tax percentage " + costs);
        aPlayer.payMoney(costs);
        super.execute(aPlayer);
    }
}
