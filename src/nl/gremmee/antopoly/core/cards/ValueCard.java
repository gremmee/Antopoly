package nl.gremmee.antopoly.core.cards;

public class ValueCard extends Card {
    private int value;

    public ValueCard(CardType aCardType, CardAction aCardAction, String aName, String aText, int aValue) {
        super(aCardType, aCardAction, aName, aText);
        this.setValue(aValue);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int aValue) {
        this.value = aValue;
    }

}
