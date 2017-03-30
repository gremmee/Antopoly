package nl.gremmee.antopoly.core.tiles;

import nl.gremmee.antopoly.Initialize;
import nl.gremmee.antopoly.players.Player;

public class GotoJailTile extends Tile {

    public GotoJailTile(int aID) {
        super(aID, "Goto Jail", TileType.TT_GotoJail);
    }

    @Override
    public void execute(Player aCurrent) {
        aCurrent.setCurrentTile(Initialize.getInstance().getTileList().getTileByName("Jail"));
        aCurrent.setInJail(true);
    }

}
