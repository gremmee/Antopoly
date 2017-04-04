package nl.gremmee.antopoly.core.tiles.impl;

import nl.gremmee.antopoly.Initialize;
import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.core.tiles.abs.Tile;
import nl.gremmee.antopoly.players.IPlayer;

public class GotoJailTile extends Tile {

    public GotoJailTile(int aID) {
        super(aID, "Goto Jail", TileType.TT_GotoJail);
    }

    @Override
    public void execute(IPlayer aCurrent) {
        aCurrent.setCurrentTile(Initialize.getInstance().getTileList().getTileByName("Jail"));
        aCurrent.setInJail(true);
        super.execute(aCurrent);
    }

}