package nl.gremmee.antopoly.core.lists;

import nl.gremmee.antopoly.core.cards.CardType;
import nl.gremmee.antopoly.core.cards.ICard;

public class CommunityChestCardList extends CardList {

    private static final long serialVersionUID = -6508141844408674559L;

    @Override
    public boolean addRandom(final ICard aCard) {
        aCard.setCardType(CardType.CT_CommunityChest);
        System.out.println("Creating Card " + aCard.getName() + "...[OK]");
        return super.addRandom(aCard);
    }

}
