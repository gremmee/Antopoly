package nl.gremmee.antopoly.core.tiles;

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

}
