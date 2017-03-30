package nl.gremmee.antopoly.core.cards;

import nl.gremmee.antopoly.players.IPlayer;

public abstract class Card implements ICard {

    private String name;
    private String text;
    private CardType cardType;
    private CardAction cardAction;

    public Card(CardAction aCardAction, String aName, String aText) {
        this.setName(aName);
        this.setText(aText);
        this.setCardAction(aCardAction);
    }

    public boolean isGetOutOfJailCard() {
        return CardAction.CA_GetOutOfJail.equals(this.getCardAction());
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

    public CardAction getCardAction() {
        return cardAction;
    }

    public void setCardAction(CardAction aCardAction) {
        this.cardAction = aCardAction;
    }

    @Override
    public String toString() {
        return ("|" + this.getName() + ", " + this.getCardType() + "|");
    }

    protected abstract boolean getKeepCard();

    @Override
    public boolean excute(IPlayer aPlayer) {
        return getKeepCard();
    }

}
