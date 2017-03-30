package nl.gremmee.antopoly.core.tiles;

import nl.gremmee.antopoly.players.IPlayer;

public class StartTile extends Tile {

    public StartTile(int aID) {
        super(aID, "Start", TileType.TT_Start);
    }

    @Override
    public void execute(IPlayer aCurrent) {

    }

}
