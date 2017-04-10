package nl.gremmee.antopoly.core.lists;

import java.util.ArrayList;

import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.core.tiles.Tiles;

public class TileList extends ArrayList<ITile> {

    private static final long serialVersionUID = -8238183105633419715L;

    public ITile getTileByName(final Tiles aTiles) {
        for (ITile tile : this) {
            if (tile.getName().equals(aTiles.getName()))
                return tile;
        }
        return null;
    }

    public ITile getTileByID(final int aId) {
        for (ITile tile : this) {
            if (tile.getID() == aId)
                return tile;
        }
        return null;
    }
}