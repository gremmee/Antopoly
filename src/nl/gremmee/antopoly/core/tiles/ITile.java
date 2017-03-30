package nl.gremmee.antopoly.core.tiles;

import nl.gremmee.antopoly.players.IPlayer;

public interface ITile {

    public String getName();

    public int getID();

    public void execute(IPlayer aCurrent);

}
