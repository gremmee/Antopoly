package nl.gremmee.antopoly.core.tiles.impl;

import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.abs.Tile;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.IPlayer;

public class GotoJailTile extends Tile {

    public GotoJailTile(final Tiles aTiles) {
        super(aTiles, TileType.TT_GotoJail);
    }

    @Override
    public void execute(final IPlayer aPlayer) {
        aPlayer.setCurrentTile(Initialize.getInstance().getTileList().getTileByName(Tiles.JAIL));
        aPlayer.setInJail(true);
        super.execute(aPlayer);
    }

}
