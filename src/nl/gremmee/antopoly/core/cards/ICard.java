package nl.gremmee.antopoly.core.cards;

import nl.gremmee.antopoly.players.IPlayer;

public interface ICard {

    public String getName();

    public CardType getCardType();

    public void setCardType(final CardType aCardType);

    public boolean execute(final IPlayer aPlayer);

    public boolean isGetOutOfJailCard();

}
