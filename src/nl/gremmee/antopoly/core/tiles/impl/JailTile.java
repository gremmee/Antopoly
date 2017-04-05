package nl.gremmee.antopoly.core.tiles.impl;

import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.abs.Tile;
import nl.gremmee.antopoly.players.IPlayer;

public class JailTile extends Tile {

    public JailTile(Tiles aTiles) {
        super(aTiles, TileType.TT_Jail);
    }

    @Override
    public void execute(IPlayer aPlayer) {
        if (!aPlayer.isInJail()) {
            System.out.println("Just visiting");

        } else {
            System.out.println("Locked up!");
        }
        super.execute(aPlayer);
    }

}
