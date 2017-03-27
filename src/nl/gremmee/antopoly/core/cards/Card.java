package nl.gremmee.antopoly.core.cards;

public class Card implements ICard {

    private String name;
    private String text;
    private CardType cardType;
    private CardAction cardAction;

    public Card(CardType aCardType, CardAction aCardAction, String aName, String aText) {
        this.setName(aName);
        this.setText(aText);
        this.setCardType(aCardType);
        this.setCardAction(aCardAction);
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

}
