package nl.gremmee.antopoly.players;

import nl.gremmee.antopoly.core.tiles.TileList;

public interface IPlayer {

    public void setActive(boolean aActive);

    public TileList getTileList();

    public String getName();

    public boolean isWinner();

    public boolean isBusted();

    public int getMoney();

    public void setWinner(boolean aWinner);

    public void setBusted(boolean aBusted);

    public void setMoney(int aMoney);

    public void play();
}
