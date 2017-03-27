package nl.gremmee.antopoly.core.cards;

public class PayCard extends ValueCard {

    public PayCard(CardType aCardType, String aName, String aText, int aValue) {
        this(aCardType, CardAction.CA_Pay, aName, aText, aValue);
    }

    public PayCard(CardType aCardType, CardAction aCardAction, String aName, String aText, int aValue) {
        super(aCardType, aCardAction, aName, aText, aValue);
    }

}
