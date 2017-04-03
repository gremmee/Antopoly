package nl.gremmee.antopoly.core.tiles.impl;

import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.core.tiles.abs.Tile;
import nl.gremmee.antopoly.players.IPlayer;

public class FreeParkingTile extends Tile {

    public FreeParkingTile(int aID) {
        super(aID, "Vrij parkeren", TileType.TT_FreeParking);
    }

    @Override
    public void execute(IPlayer aCurrent) {

    }

}
