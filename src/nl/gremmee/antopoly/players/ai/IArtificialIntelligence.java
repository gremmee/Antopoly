package nl.gremmee.antopoly.players.ai;

import nl.gremmee.antopoly.core.cards.impl.ChoiceCard;
import nl.gremmee.antopoly.core.tiles.abs.PropertyTile;
import nl.gremmee.antopoly.players.IPlayer;

public interface IArtificialIntelligence {

    public String getName();

    public void executeRepayMortage();

    public void executeGetMortage();

    public void executeBuyTile(PropertyTile aTile, IPlayer aPlayer);

    public boolean executeChoiceCard(ChoiceCard aChoiceCard, IPlayer aPlayer);

    public boolean executeGetOutOfJail();

    public void executeBuyHouses(IPlayer aPlayer);
}
