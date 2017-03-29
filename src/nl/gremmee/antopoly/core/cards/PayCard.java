package nl.gremmee.antopoly.core.cards;

public class PayCard extends ValueCard {

    public PayCard(String aName, String aText, int aValue) {
        this(CardAction.CA_Pay, aName, aText, aValue);
    }

    public PayCard(CardAction aCardAction, String aName, String aText, int aValue) {
        super(aCardAction, aName, aText, aValue);
    }

}
