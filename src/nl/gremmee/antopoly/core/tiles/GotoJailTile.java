package nl.gremmee.antopoly.core.tiles;

import nl.gremmee.antopoly.Initialize;
import nl.gremmee.antopoly.players.IPlayer;

public class GotoJailTile extends Tile {

    public GotoJailTile(int aID) {
        super(aID, "Goto Jail", TileType.TT_GotoJail);
    }

    @Override
    public void execute(IPlayer aCurrent) {
        aCurrent.setCurrentTile(Initialize.getInstance().getTileList().getTileByName("Jail"));
        aCurrent.setInJail(true);
    }

}
