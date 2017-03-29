package nl.gremmee.antopoly.core.cards;

public class ChoiceCard extends PayCard {

    public ChoiceCard(String aName, String aText, int aValue) {
        super(CardAction.CA_Choice, aName, aText, aValue);
    }

}
