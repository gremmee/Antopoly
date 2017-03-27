package nl.gremmee.antopoly.core.tiles;

public class Property extends Tile {

    private int value;

    public Property(int aID, String aName, TileType aTileType, int aValue) {
        super(aID, aName, aTileType);
        this.setValue(aValue);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int aValue) {
        this.value = aValue;
    }

}
