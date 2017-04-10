package nl.gremmee.antopoly.core.cards.abs;

public abstract class ValueCard extends Card {
    private int value;

    public ValueCard(final String aName, final String aText, final int aValue) {
        super(aName, aText);
        this.setValue(aValue);
    }

    public int getValue() {
        return value;
    }

    public void setValue(final int aValue) {
        this.value = aValue;
    }

}
