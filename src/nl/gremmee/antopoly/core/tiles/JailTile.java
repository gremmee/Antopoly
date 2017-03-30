package nl.gremmee.antopoly.core.tiles;

import nl.gremmee.antopoly.players.IPlayer;

public class JailTile extends Tile {

    public JailTile(int aID) {
        super(aID, "Jail", TileType.TT_Jail);
    }

    @Override
    public void execute(IPlayer aCurrent) {
        if (!aCurrent.isInJail()) {
            System.out.println("Just visiting");

        } else {
            System.out.println("Locked up!");
        }

    }

}
