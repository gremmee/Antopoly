package nl.gremmee.antopoly.initialize;

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

    public ChanceCardList initializeChanceCards(final TileList aTileList) {
        if (this.chanceCardList == null) {
            System.out.println("Initializing Chance Cards");
            this.chanceCardList = new ChanceCardList();

            this.chanceCardList.addRandom(new PayCard("Speeding", "Boete voor te snel rijden � 15", 15));
            this.chanceCardList.addRandom(new PayCard("Schoolfee", "Betaal schoolgeld � 150", 150));
            this.chanceCardList.addRandom(new GotoTileCard("Goto Barteljorisstraat",
                    "Ga verder naar Barteljorisstraat. Indien u langs \"Start\" komt, ontvangt u � 200",
                    aTileList.getTileByName(Tiles.ST_CHARLES_PLACE)));
            this.chanceCardList.addRandom(new GotoTileCard("Goto West",
                    "Reis naar station \"West\". Indien u langs \"Start\" komt, ontvangt u � 200",
                    aTileList.getTileByName(Tiles.PENNSYLVANIA_RAILROAD)));
            this.chanceCardList.addRandom(
                    new GotoTileCard("Goto Start", "Ga verder naar \"Start\"", aTileList.getTileByName(Tiles.START)));
            this.chanceCardList.addRandom(new GotoStepsCard("Goto Back 3", "Ga drie plaatsen terug", 3, false));
            this.chanceCardList.addRandom(new GotoJailCard());
            this.chanceCardList.addRandom(new GotoTileCard("Goto Heerestraat",
                    "Ga verder naar Heerestraat. Indien u langs \"Start\" komt, ontvangt u � 200",
                    aTileList.getTileByName(Tiles.KENTUCKY_AVENUE)));
            this.chanceCardList.addRandom(new PayCard("Bank pays", "De bank betaalt u � 50 dividend", 50));
            this.chanceCardList.addRandom(
                    new GetOutOfJailCard("Verlaat de gevangenis", "Verlaat de gevangenis zonder te betalen"));
            this.chanceCardList.addRandom(new PayPropertyCard("Fix houses",
                    "Repareer uw huizen. Betaal voor elk huis � 25, betaal voor elk hotel � 100", 25, 100));
            this.chanceCardList.addRandom(new PayPropertyCard("Streettax",
                    "U wordt aangeslagen voor straatgeld. � 40 per huis, � 115 per hotel", 40, 115));
            this.chanceCardList.addRandom(
                    new ReceiveCard("Buildinginsurance", "Uw bouwverzekering vervalt, u ontvangt � 150", 150));
            this.chanceCardList.addRandom(new PayCard("Drunk", "Aangehouden wegens dronkenschap � 20 boete", 20));
            this.chanceCardList.addRandom(new GotoTileCard("Goto Kalverstraat", "Ga verder naar Kalverstraat.",
                    aTileList.getTileByName(Tiles.BOARDWALK)));
            this.chanceCardList.addRandom(
                    new ReceiveCard("Crossword puzzle", "U hebt een kruiswoordpuzzel gewonnen en ontvangt � 100", 100));

            System.out.println(this.chanceCardList);
        }
        return this.chanceCardList;
    }

}
