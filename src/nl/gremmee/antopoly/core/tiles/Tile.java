package nl.gremmee.antopoly.core.tiles;

public class Tile implements ITile {

    private String name;
    private int ID;
    private TileType tileType;

    public Tile(int aID, String aName, TileType aTileType) {
        this.setID(aID);
        this.setName(aName);
        this.setTileType(aTileType);
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        this.name = aName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int aID) {
        ID = aID;
    }

    public TileType getTileType() {
        return tileType;
    }

    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }

}
