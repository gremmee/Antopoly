package nl.gremmee.antopoly.core.tiles;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.players.IPlayer;

public class TaxTile extends Tile {

    private int value;

    public TaxTile(int aID, int aValue) {
        super(aID, "Taxes", TileType.TT_Taxes);
        this.setValue(aValue);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int aValue) {
        this.value = aValue;
    }

    @Override
    public void execute(IPlayer aCurrent) {
        int costs = this.getValue() * Settings.MONEY_FACTOR;
        System.out.println("Tax " + costs);
        aCurrent.setMoney(aCurrent.getMoney() - costs);

    }

}
