package nl.gremmee.antopoly.players;

import nl.gremmee.antopoly.core.lists.CardList;
import nl.gremmee.antopoly.core.lists.RollList;
import nl.gremmee.antopoly.core.lists.TileList;
import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.core.tiles.abs.PropertyTile;
import nl.gremmee.antopoly.players.ai.IArtificialIntelligence;
import nl.gremmee.antopoly.players.impl.Owe;

public interface IPlayer {

    public void setActive(final boolean aActive);

    public TileList getTileList();

    public void addTile(final PropertyTile aTile);

    public CardList getCardList();

    public String getName();

    public boolean isWinner();

    public boolean isBusted();

    public boolean isAgain();

    public void setCurrentTile(ITile aCurrentTile);

    public int getMoney();

    public void setWinner(final boolean aWinner);

    public void setBusted(final boolean aBusted);

    public void resetMoney();

    public void play();

    public boolean isInJail();

    public void setInJail(final boolean aInJail);

    public ITile getCurrentTile();

    public RollList roll();

    public RollList getRollList();

    public void payMoney(final int aMoney);

    public void receiveMoney(final int aMoney);

    public IArtificialIntelligence getArtificialIntelligence();

    public void setAgain(final boolean aAgain);

    public Owe getOwe();
}
