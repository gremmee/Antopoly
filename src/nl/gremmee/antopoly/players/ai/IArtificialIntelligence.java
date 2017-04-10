package nl.gremmee.antopoly.players.ai;

import nl.gremmee.antopoly.core.cards.impl.ChoiceCard;
import nl.gremmee.antopoly.core.tiles.abs.PropertyTile;
import nl.gremmee.antopoly.players.IPlayer;

public interface IArtificialIntelligence {

    public String getName();

    public void executeRepayMortgage();

    public void executeGetMortgage(final IPlayer aPlayer);

    public void executeBuyTile(final PropertyTile aTile, final IPlayer aPlayer);

    public boolean executeChoiceCard(final ChoiceCard aChoiceCard, final IPlayer aPlayer);

    public boolean executeGetOutOfJail();

    public void executeBuyHouses(final IPlayer aPlayer);
}
