package nl.gremmee.antopoly.initialize;

import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.core.cards.impl.GetOutOfJailCard;
import nl.gremmee.antopoly.core.cards.impl.GotoCard;
import nl.gremmee.antopoly.core.cards.impl.GotoJailCard;
import nl.gremmee.antopoly.core.cards.impl.PayCard;
import nl.gremmee.antopoly.core.cards.impl.PayPropertyCard;
import nl.gremmee.antopoly.core.cards.impl.ReceiveCard;
import nl.gremmee.antopoly.core.lists.ChanceCardList;
import nl.gremmee.antopoly.core.lists.TileList;

public class InitializeChanceCards {
    private static InitializeChanceCards instance;
    private ChanceCardList chanceCardList;

    private InitializeChanceCards() {
    }

    public static InitializeChanceCards getInstance() {
        if (instance == null) {
            instance = new InitializeChanceCards();
        }
        return instance;
    }

    public ChanceCardList initializeChanceCards(TileList aTileList) {
        if (chanceCardList == null) {
            System.out.println("Initializing Chance Cards");
            chanceCardList = new ChanceCardList();
            ICard card = new PayCard("Speeding", "Boete voor te snel rijden � 15", 15);
            chanceCardList.addRandom(card);
            System.out.print("Creating Card " + card.getName() + "...");
            System.out.println("[OK]");

            card = new PayCard("Schoolfee", "Betaal schoolgeld � 150", 150);
            chanceCardList.addRandom(card);
            System.out.print("Creating Card " + card.getName() + "...");
            System.out.println("[OK]");

            card = new GotoCard("Goto Barteljorisstraat",
                    "Ga verder naar Barteljorisstraat. Indien u langs \"Start\" komt, ontvangt u � 200",
                    aTileList.getTileByName("Barteljorisstraat"));
            chanceCardList.addRandom(card);
            System.out.print("Creating Card " + card.getName() + "...");
            System.out.println("[OK]");

            card = new GotoCard("Goto West",
                    "Reis naar station \"West\". Indien u langs \"Start\" komt, ontvangt u � 200",
                    aTileList.getTileByName("Station West"));
            chanceCardList.addRandom(card);
            System.out.print("Creating Card " + card.getName() + "...");
            System.out.println("[OK]");

            card = new GotoCard("Goto Start", "Ga verder naar \"Start\"", aTileList.getTileByName("Start"));
            chanceCardList.addRandom(card);
            System.out.print("Creating Card " + card.getName() + "...");
            System.out.println("[OK]");

            card = new GotoCard("Goto Back 3", "Ga drie plaatsen terug", aTileList.get(1));
            chanceCardList.addRandom(card);
            System.out.print("Creating Card " + card.getName() + "...");
            System.out.println("[OK]");

            card = new GotoJailCard();
            chanceCardList.addRandom(card);
            System.out.print("Creating Card " + card.getName() + "...");
            System.out.println("[OK]");

            card = new GotoCard("Goto Heerestraat",
                    "Ga verder naar Heerestraat. Indien u langs \"Start\" komt, ontvangt u � 200",
                    aTileList.getTileByName("Heerestraat"));
            chanceCardList.addRandom(card);
            System.out.print("Creating Card " + card.getName() + "...");
            System.out.println("[OK]");

            card = new PayCard("Bank pays", "De bank betaalt u � 50 dividend", 50);
            chanceCardList.addRandom(card);
            System.out.print("Creating Card " + card.getName() + "...");
            System.out.println("[OK]");

            card = new GetOutOfJailCard("Verlaat de gevangenis", "Verlaat de gevangenis zonder te betalen");
            chanceCardList.addRandom(card);
            System.out.print("Creating Card " + card.getName() + "...");
            System.out.println("[OK]");

            card = new PayPropertyCard("Fix houses",
                    "Repareer uw huizen. Betaal voor elk huis � 25, betaal voor elk hotel � 100", 25, 100);
            chanceCardList.addRandom(card);
            System.out.print("Creating Card " + card.getName() + "...");
            System.out.println("[OK]");

            card = new PayPropertyCard("Streettax",
                    "U wordt aangeslagen voor straatgeld. � 40 per huis, � 115 per hotel", 40, 115);
            chanceCardList.addRandom(card);
            System.out.print("Creating Card " + card.getName() + "...");
            System.out.println("[OK]");

            card = new ReceiveCard("Buildinginsurance", "Uw bouwverzekering vervalt, u ontvangt � 150", 150);
            chanceCardList.addRandom(card);
            System.out.print("Creating Card " + card.getName() + "...");
            System.out.println("[OK]");

            card = new PayCard("Drunk", "Aangehouden wegens dronkenschap � 20 boete", 20);
            chanceCardList.addRandom(card);
            System.out.print("Creating Card " + card.getName() + "...");
            System.out.println("[OK]");

            card = new GotoCard("Goto Kalverstraat", "Ga verder naar Kalverstraat.",
                    aTileList.getTileByName("Kalverstraat"));
            chanceCardList.addRandom(card);
            System.out.print("Creating Card " + card.getName() + "...");
            System.out.println("[OK]");

            card = new ReceiveCard("Crossword puzzle", "U hebt een kruiswoordpuzzel gewonnen en ontvangt � 100", 100);
            chanceCardList.addRandom(card);
            System.out.print("Creating Card " + card.getName() + "...");
            System.out.println("[OK]");
            System.out.println(chanceCardList);
        }
        return chanceCardList;
    }

}