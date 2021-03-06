package nl.gremmee.antopoly.core.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.core.cards.impl.GetOutOfJailCard;

public class CardList extends ArrayList<ICard> {

    private static final long serialVersionUID = -1529154175329821765L;

    public boolean addRandom(final ICard aCard) {
        int size = this.size();
        if (size == 0) {
            return super.add(aCard);
        }
        Random random = new Random();
        int r = random.nextInt(size);
        super.add(r, aCard);
        return true;
    }

    public ICard pickTopCard() {
        return super.remove(0);
    }

    public void putBack(final ICard aCard) {
        super.add(this.size(), aCard);
    }

    public List<GetOutOfJailCard> getOutOfJailCards() {
        List<GetOutOfJailCard> getOutOfJailCards = new ArrayList<GetOutOfJailCard>();
        for (ICard card : this) {
            if (card instanceof GetOutOfJailCard) {
                GetOutOfJailCard getOutOfJailCard = (GetOutOfJailCard) card;
                getOutOfJailCards.add(getOutOfJailCard);
            }
        }
        return getOutOfJailCards;
    }

}