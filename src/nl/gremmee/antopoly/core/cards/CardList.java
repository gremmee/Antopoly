package nl.gremmee.antopoly.core.cards;

import java.util.ArrayList;
import java.util.Random;

public class CardList extends ArrayList<ICard> {

    private static final long serialVersionUID = -1529154175329821765L;

    public boolean addRandom(ICard aCard) {
        int size = this.size();
        System.out.println(size);
        if (size == 0) {
            return super.add(aCard);
        }
        Random random = new Random();
        int r = random.nextInt(size);
        System.out.println(r);
        super.add(r, aCard);
        return true;
    }

    public ICard pickTopCard() {
        return super.remove(0);
    }

    public void putBack(ICard aCard) {
        super.add(this.size(), aCard);
    }

}