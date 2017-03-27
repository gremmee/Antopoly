package nl.gremmee.antopoly.players;

import nl.gremmee.antopoly.core.tiles.TileList;

public interface IPlayer {

    public void setActive(boolean aActive);

    public TileList getTileList();

    public String getName();

    public boolean isWinner();

    public void setWinner(boolean b);

    public void play();
}
