
package nl.gremmee.antopoly.core.tiles.abs;

import java.util.Objects;

import nl.gremmee.antopoly.Initialize;
import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.players.IPlayer;

public abstract class Tile implements ITile, Comparable<Tile> {

    private String name;
    private int ID;
    private TileType tileType;

    public Tile(int aID, String aName, TileType aTileType) {
        this.setID(aID);
        this.setName(aName);
        this.setTileType(aTileType);
    }

    @Override
    public int compareTo(Tile aThat) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        // this optimization is usually worthwhile, and can
        // always be added
        if (this == aThat)
            return EQUAL;

        // primitive numbers follow this form
        if (this.getID() < aThat.getID())
            return BEFORE;
        if (this.getID() > aThat.getID())
            return AFTER;

        // all comparisons have yielded equality
        // verify that compareTo is consistent with equals (optional)
        assert this.equals(aThat) : "compareTo inconsistent with equals.";

        return EQUAL;
    }

    @Override
    public void execute(IPlayer aPlayer) {
        Initialize.getInstance().initializeRules();
    }

    @Override
    public boolean equals(Object aOther) {
        // self check
        if (this == aOther)
            return true;
        // null check
        if (aOther == null)
            return false;
        // type check and cast
        if (getClass() != aOther.getClass())
            return false;
        Tile tile = (Tile) aOther;
        // field comparison
        return Objects.equals(name, tile.name) && Objects.equals(tileType, tile.tileType);
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

    @Override
    public String toString() {
        return this.getName();
    }

}
