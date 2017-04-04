package nl.gremmee.antopoly.core.tiles.impl;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.core.tiles.abs.Tile;
import nl.gremmee.antopoly.players.IPlayer;

public class TaxPercentageTile extends Tile {

    private int percentage;

    public TaxPercentageTile(int aID, String aName, int aPercentage) {
        super(aID, aName, TileType.TT_TaxesPercentage);
        this.setPercentage(aPercentage);
    }

    public int getPercentage() {
        return percentage;
    }

    private void setPercentage(int aValue) {
        this.percentage = aValue;
    }

    @Override
    public void execute(IPlayer aPlayer) {
        int costs = ((aPlayer.getMoney() * this.getPercentage()) / 100) * Settings.MONEY_FACTOR;
        System.out.println("Tax percentage " + costs);
        aPlayer.payMoney(costs);
        super.execute(aPlayer);
    }
}
