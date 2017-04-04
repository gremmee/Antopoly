package nl.gremmee.antopoly.core.lists;

import java.util.ArrayList;

import nl.gremmee.antopoly.core.tiles.ITile;

public class TileList extends ArrayList<ITile> {

    private static final long serialVersionUID = -8238183105633419715L;

    public ITile getTileByName(String aName) {
        for (ITile tile : this) {
            if (tile.getName().equals(aName))
                return tile;
        }
        return null;
    }

    public ITile getTileByID(int aID) {
        for (ITile tile : this) {
            if (tile.getID() == aID)
                return tile;
        }
        return null;
    }
}