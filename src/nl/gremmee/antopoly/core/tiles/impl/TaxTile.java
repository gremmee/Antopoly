package nl.gremmee.antopoly.core.tiles.impl;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.abs.Tile;
import nl.gremmee.antopoly.players.IPlayer;

public class TaxTile extends Tile {

    private int tax;

    public TaxTile(final Tiles aTiles, final int aValue) {
        super(aTiles, TileType.TT_Taxes);
        this.setTax(aValue);
    }

    public int getTax() {
        return this.tax;
    }

    private void setTax(final int aValue) {
        this.tax = aValue;
    }

    @Override
    public void execute(final IPlayer aPlayer) {
        int costs = this.getTax() * Settings.MONEY_FACTOR;
        System.out.println("Tax " + costs);
        aPlayer.payMoney(costs);
        super.execute(aPlayer);
    }

}
