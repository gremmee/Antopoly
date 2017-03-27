package nl.gremmee.antopoly.core.cards;

public class RecieveCard extends ValueCard {

    public RecieveCard(CardType aCardType, String aName, String aText, int aValue) {
        super(aCardType, CardAction.CA_Recieve, aName, aText, aValue);
    }

}
