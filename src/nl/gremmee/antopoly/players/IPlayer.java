package nl.gremmee.antopoly.players;

import nl.gremmee.antopoly.core.lists.CardList;
import nl.gremmee.antopoly.core.lists.RollList;
import nl.gremmee.antopoly.core.lists.TileList;
import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.players.ai.IArtificialIntelligence;

public interface IPlayer {

    public void setActive(boolean aActive);

    public TileList getTileList();

    public CardList getCardList();

    public String getName();

    public boolean isWinner();

    public boolean isBusted();

    public boolean isAgain();

    public void setCurrentTile(ITile aCurrentTile);

    public int getMoney();

    public void setWinner(boolean aWinner);

    public void setBusted(boolean aBusted);

    public void resetMoney();

    public void play();

    public boolean isInJail();

    public void setInJail(boolean aInJail);

    public ITile getCurrentTile();

    public RollList roll();

    public RollList getRollList();

    public void payMoney(int aMoney);

    public void receiveMoney(int aMoney);

    public IArtificialIntelligence getArtificialIntelligence();

    public void setAgain(boolean aAgain);
}
