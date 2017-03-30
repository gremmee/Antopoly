package nl.gremmee.antopoly.core.tiles;

import nl.gremmee.antopoly.players.Player;

public class JailTile extends Tile {

    public JailTile(int aID) {
        super(aID, "Jail", TileType.TT_Jail);
    }

    @Override
    public void execute(Player aCurrent) {
        System.out.println("Just visiting");

    }

}
