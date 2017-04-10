package nl.gremmee.antopoly.statistics;

import nl.gremmee.antopoly.players.IPlayer;

public interface ICollector {

    public String getName();

    public void collect(final IPlayer aPlayer);
}
