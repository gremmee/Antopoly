package nl.gremmee.antopoly.core.lists;

import nl.gremmee.antopoly.core.cards.CardType;
import nl.gremmee.antopoly.core.cards.ICard;

public class ChanceCardList extends CardList {

    private static final long serialVersionUID = 2765362381763588138L;

    @Override
    public boolean addRandom(final ICard aCard) {
        aCard.setCardType(CardType.CT_Chance);
        System.out.println("Creating Card " + aCard.getName() + "...[OK]");
        return super.addRandom(aCard);
    }
}
