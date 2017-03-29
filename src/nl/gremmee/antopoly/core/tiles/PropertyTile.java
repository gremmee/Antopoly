package nl.gremmee.antopoly.core.tiles;

public class PropertyTile extends Tile {

    private int value;

    public PropertyTile(int aID, String aName, TileType aTileType, int aValue) {
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
