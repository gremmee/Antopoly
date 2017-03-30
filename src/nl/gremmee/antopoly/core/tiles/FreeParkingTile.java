package nl.gremmee.antopoly.core.tiles;

import nl.gremmee.antopoly.players.IPlayer;

public class FreeParkingTile extends Tile {

    public FreeParkingTile(int aID) {
        super(aID, "Vrij parkeren", TileType.TT_FreeParking);
    }

    @Override
    public void execute(IPlayer aCurrent) {

    }

}
