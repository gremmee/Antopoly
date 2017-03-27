package nl.gremmee.antopoly.core.cards;

public class ChoiceCard extends PayCard {

    public ChoiceCard(CardType aCardType, String aName, String aText, int aValue) {
        super(aCardType, CardAction.CA_Choice, aName, aText, aValue);
    }

}
