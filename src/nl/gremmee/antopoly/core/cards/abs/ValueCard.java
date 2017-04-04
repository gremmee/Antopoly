package nl.gremmee.antopoly.core.cards.abs;

public abstract class ValueCard extends Card {
    private int value;

    public ValueCard(String aName, String aText, int aValue) {
        super(aName, aText);
        this.setValue(aValue);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int aValue) {
        this.value = aValue;
    }

}