
package nl.gremmee.antopoly.core.tiles;

import nl.gremmee.antopoly.players.Player;

public class Tile implements ITile {

    private String name;
    private int ID;
    private TileType tileType;
    private Player owner;

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

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player aOwner) {
        this.owner = aOwner;
    }

}
