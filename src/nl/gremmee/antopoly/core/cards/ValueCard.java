package nl.gremmee.antopoly.core.cards;

public abstract class ValueCard extends Card {
    private int value;

    public ValueCard(CardAction aCardAction, String aName, String aText, int aValue) {
        super(aCardAction, aName, aText);
        this.setValue(aValue);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int aValue) {
        this.value = aValue;
    }

}
