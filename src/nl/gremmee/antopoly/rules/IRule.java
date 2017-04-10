package nl.gremmee.antopoly.rules;

import nl.gremmee.antopoly.players.IPlayer;

public interface IRule {

    public String getName();

    public void execute(final IPlayer aPlayer);
}
