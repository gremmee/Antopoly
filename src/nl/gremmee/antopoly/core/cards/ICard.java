package nl.gremmee.antopoly.core.cards;

import nl.gremmee.antopoly.players.IPlayer;

public interface ICard {

    public String getName();

    public CardType getCardType();

    public void setCardType(CardType aCardType);

    public boolean excute(IPlayer aPlayer);

    public boolean isGetOutOfJailCard();

}
