package nl.gremmee.antopoly;

import java.util.Random;

import nl.gremmee.antopoly.core.cards.ChanceCardList;
import nl.gremmee.antopoly.core.cards.ICard;

public class TestCards {

    public static void main(String[] args) {
        Initialize.getInstance().initializeTileList();
        ChanceCardList cardList = Initialize.getInstance().initializeChanceCards();

        System.out.println(cardList);
        ICard leave = null;
        Random rnd = new Random();
        int r = rnd.nextInt(cardList.size()) + cardList.size();
        for (int i = 0; i < cardList.size() * 2; i++) {

            if (r == i) {
                cardList.putBack(leave);
                System.out.println("LEAVE card put back");
            }
            ICard card = cardList.pickTopCard();
            System.out.println(card + " picked");

            System.out.println(cardList);

            if (card.getName().contains("Verlaat de gevangenis")) {
                leave = card;
                System.out.println("LEAVE card picked and stored");
            } else {
                cardList.putBack(card);
            }

            System.out.println(cardList);
        }
    }

}
