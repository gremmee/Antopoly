package nl.gremmee.antopoly.core.cards.abs;

import nl.gremmee.antopoly.Initialize;
import nl.gremmee.antopoly.core.cards.CardType;
import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.core.cards.impl.GetOutOfJailCard;
import nl.gremmee.antopoly.players.IPlayer;

public abstract class Card implements ICard {

    private String name;
    private String text;
    private CardType cardType;

    public Card(String aName, String aText) {
        this.setName(aName);
        this.setText(aText);
    }

    public boolean isGetOutOfJailCard() {
        return this instanceof GetOutOfJailCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        this.name = aName;
    }

    public String getText() {
        return text;
    }

    public void setText(String aText) {
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
    public boolean excute(IPlayer aPlayer) {
        Initialize.getInstance().executeRules(aPlayer);
        return getKeepCard();
    }

}
