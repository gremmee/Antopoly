package nl.gremmee.antopoly.initialize;

import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.core.cards.impl.GetOutOfJailCard;
import nl.gremmee.antopoly.core.cards.impl.GotoJailCard;
import nl.gremmee.antopoly.core.cards.impl.GotoStepsCard;
import nl.gremmee.antopoly.core.cards.impl.GotoTileCard;
import nl.gremmee.antopoly.core.cards.impl.PayCard;
import nl.gremmee.antopoly.core.cards.impl.PayPropertyCard;
import nl.gremmee.antopoly.core.cards.impl.ReceiveCard;
import nl.gremmee.antopoly.core.lists.ChanceCardList;
import nl.gremmee.antopoly.core.lists.TileList;
import nl.gremmee.antopoly.core.tiles.Tiles;

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

            ICard card = new PayCard("Speeding", "Boete voor te snel rijden ƒ 15", 15);
            chanceCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new PayCard("Schoolfee", "Betaal schoolgeld ƒ 150", 150);
            chanceCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new GotoTileCard("Goto Barteljorisstraat",
                    "Ga verder naar Barteljorisstraat. Indien u langs \"Start\" komt, ontvangt u ƒ 200",
                    aTileList.getTileByName(Tiles.ST_CHARLES_PLACE));
            chanceCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new GotoTileCard("Goto West",
                    "Reis naar station \"West\". Indien u langs \"Start\" komt, ontvangt u ƒ 200",
                    aTileList.getTileByName(Tiles.PENNSYLVANIA_RAILROAD));
            chanceCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new GotoTileCard("Goto Start", "Ga verder naar \"Start\"", aTileList.getTileByName(Tiles.START));
            chanceCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new GotoStepsCard("Goto Back 3", "Ga drie plaatsen terug", 3, false);
            chanceCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new GotoJailCard();
            chanceCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new GotoTileCard("Goto Heerestraat",
                    "Ga verder naar Heerestraat. Indien u langs \"Start\" komt, ontvangt u ƒ 200",
                    aTileList.getTileByName(Tiles.KENTUCKY_AVENUE));
            chanceCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new PayCard("Bank pays", "De bank betaalt u ƒ 50 dividend", 50);
            chanceCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new GetOutOfJailCard("Verlaat de gevangenis", "Verlaat de gevangenis zonder te betalen");
            chanceCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new PayPropertyCard("Fix houses",
                    "Repareer uw huizen. Betaal voor elk huis ƒ 25, betaal voor elk hotel ƒ 100", 25, 100);
            chanceCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new PayPropertyCard("Streettax",
                    "U wordt aangeslagen voor straatgeld. ƒ 40 per huis, ƒ 115 per hotel", 40, 115);
            chanceCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new ReceiveCard("Buildinginsurance", "Uw bouwverzekering vervalt, u ontvangt ƒ 150", 150);
            chanceCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new PayCard("Drunk", "Aangehouden wegens dronkenschap ƒ 20 boete", 20);
            chanceCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new GotoTileCard("Goto Kalverstraat", "Ga verder naar Kalverstraat.",
                    aTileList.getTileByName(Tiles.BOARDWALK));
            chanceCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new ReceiveCard("Crossword puzzle", "U hebt een kruiswoordpuzzel gewonnen en ontvangt ƒ 100", 100);
            chanceCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            System.out.println(chanceCardList);
        }
        return chanceCardList;
    }

}
