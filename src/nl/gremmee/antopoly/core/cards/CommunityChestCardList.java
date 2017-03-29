package nl.gremmee.antopoly.core.cards;

public class CommunityChestCardList extends CardList {

    private static final long serialVersionUID = -6508141844408674559L;

    @Override
    public boolean addRandom(ICard aCard) {
        ICard card = aCard;
        card.setCardType(CardType.CT_CommunityChest);
        return super.addRandom(card);
    }

}
