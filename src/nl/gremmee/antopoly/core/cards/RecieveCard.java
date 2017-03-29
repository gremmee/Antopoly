package nl.gremmee.antopoly.core.cards;

public class RecieveCard extends ValueCard {

    public RecieveCard(String aName, String aText, int aValue) {
        super(CardAction.CA_Recieve, aName, aText, aValue);
    }

}
