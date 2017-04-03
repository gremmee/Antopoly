package nl.gremmee.antopoly.core.tiles.impl;

import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.core.tiles.abs.Tile;
import nl.gremmee.antopoly.players.IPlayer;

public class StartTile extends Tile {

    public StartTile(int aID) {
        super(aID, "Start", TileType.TT_Start);
    }

    @Override
    public void execute(IPlayer aCurrent) {

    }

}
