package nl.gremmee.antopoly.core.tiles;

import nl.gremmee.antopoly.players.Player;

public interface ITile {

    public String getName();

    public int getID();

    public void setOwner(Player aOwner);

}
