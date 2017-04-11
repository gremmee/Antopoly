package nl.gremmee.antopoly.core.cards.abs;

import nl.gremmee.antopoly.core.cards.CardType;
import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.core.cards.impl.GetOutOfJailCard;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.IPlayer;

public abstract class Card implements ICard {

    private String name;
    private String text;
    private CardType cardType;

    public Card(final String aName, final String aText) {
        this.setName(aName);
        this.setText(aText);
    }

    public boolean isGetOutOfJailCard() {
        return this instanceof GetOutOfJailCard;
    }

    public String getName() {
        return name;
    }

    public void setName(final String aName) {
        this.name = aName;
    }

    public String getText() {
        return text;
    }

    public void setText(final String aText) {
        this.text = aText;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType aCardType) {
        this.cardType = aCardType;
    }

    @Override
    public String toString() {
        return ("|" + this.getName() + ", " + this.getCardType() + "|");
    }

    protected abstract boolean getKeepCard();

    @Override
    public boolean execute(final IPlayer aPlayer) {
        Initialize.getInstance().executeRules(aPlayer);
        return getKeepCard();
    }

}
