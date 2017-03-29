package nl.gremmee.antopoly.core.cards;

public class ChanceCardList extends CardList {

    private static final long serialVersionUID = 2765362381763588138L;

    @Override
    public boolean addRandom(ICard aCard) {
        ICard card = aCard;
        card.setCardType(CardType.CT_Chance);
        return super.addRandom(aCard);
    }
}