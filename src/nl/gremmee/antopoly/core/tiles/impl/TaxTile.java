package nl.gremmee.antopoly.core.tiles.impl;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.abs.Tile;
import nl.gremmee.antopoly.players.IPlayer;

public class TaxTile extends Tile {

    private int value;

    public TaxTile(final Tiles aTiles, final int aValue) {
        super(aTiles, TileType.TT_Taxes);
        this.setValue(aValue);
    }

    public int getValue() {
        return value;
    }

    private void setValue(final int aValue) {
        this.value = aValue;
    }

    @Override
    public void execute(final IPlayer aPlayer) {
        int costs = this.getValue() * Settings.MONEY_FACTOR;
        System.out.println("Tax " + costs);
        aPlayer.payMoney(costs);
        super.execute(aPlayer);
    }

}
