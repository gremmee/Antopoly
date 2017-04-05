package nl.gremmee.antopoly.core.tiles.impl;

import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.abs.Tile;
import nl.gremmee.antopoly.players.IPlayer;

public class StartTile extends Tile {

    public StartTile(Tiles aTiles) {
        super(aTiles, TileType.TT_Start);
    }

    @Override
    public void execute(IPlayer aPlayer) {
        super.execute(aPlayer);
    }

}
