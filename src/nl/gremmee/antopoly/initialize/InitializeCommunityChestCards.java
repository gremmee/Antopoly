package nl.gremmee.antopoly.initialize;

import nl.gremmee.antopoly.core.cards.impl.ChoiceCard;
import nl.gremmee.antopoly.core.cards.impl.GetOutOfJailCard;
import nl.gremmee.antopoly.core.cards.impl.GotoJailCard;
import nl.gremmee.antopoly.core.cards.impl.GotoTileCard;
import nl.gremmee.antopoly.core.cards.impl.PayCard;
import nl.gremmee.antopoly.core.cards.impl.ReceiveCard;
import nl.gremmee.antopoly.core.lists.CommunityChestCardList;
import nl.gremmee.antopoly.core.lists.TileList;
import nl.gremmee.antopoly.core.tiles.Tiles;

public class InitializeCommunityChestCards {
    private static InitializeCommunityChestCards instance;
    private CommunityChestCardList communityChestCardList;

    private InitializeCommunityChestCards() {
    }

    public static InitializeCommunityChestCards getInstance() {
        if (instance == null) {
            instance = new InitializeCommunityChestCards();
        }
        return instance;
    }

    public CommunityChestCardList initializeCommunityChestCards(final TileList aTileList) {
        if (this.communityChestCardList == null) {
            System.out.println("Initializing Community Chest Cards");
            this.communityChestCardList = new CommunityChestCardList();

            this.communityChestCardList.addRandom(new ReceiveCard("Inherit", "U erft � 100", 100));
            this.communityChestCardList
                    .addRandom(new ReceiveCard("Intrest", "U ontvangt rente van 7% preferente aandelen � 25", 25));
            this.communityChestCardList.addRandom(new ReceiveCard("Mistake Bank",
                    "Een vergissing van de bank in uw voordeel, u ontvangt � 200", 200));
            this.communityChestCardList
                    .addRandom(new GotoTileCard("Goto Dorpsstraat", "Ga terug naar Dorpsstraat (Ons Dorp)",
                            aTileList.getTileByName(Tiles.MEDITERRANEAN_AVENUE), false));
            this.communityChestCardList.addRandom(new GotoJailCard());
            this.communityChestCardList
                    .addRandom(new ReceiveCard("Birthday", "U bent jarig en ontvangt van iedere speler � 10", 10));
            this.communityChestCardList.addRandom(new ReceiveCard("Beauty Contest",
                    "U hebt de tweede prijs in een schoonheidswedstrijd gewonnen en ontvangt � 10", 10));
            this.communityChestCardList.addRandom(new PayCard("Doctors bill", "Betaal uw doktersrekening � 50", 50));
            this.communityChestCardList
                    .addRandom(new PayCard("Insurace bill", "Betaal uw verzekeringspremie � 50", 50));
            this.communityChestCardList
                    .addRandom(new ReceiveCard("Sell stock", "Door verkoop van effecten ontvangt u � 50", 50));
            this.communityChestCardList.addRandom(
                    new GetOutOfJailCard("Verlaat de gevangenis", "Verlaat de gevangenis zonder te betalen"));
            this.communityChestCardList
                    .addRandom(new ReceiveCard("Refund taxws", "Restitutie inkomstenbelasting, u ontvangt � 20", 20));
            this.communityChestCardList
                    .addRandom(new ReceiveCard("Aannuity", "Lijfrente vervalt, u ontvangt � 100", 100));
            this.communityChestCardList.addRandom(new PayCard("Hospital bill", "Betaal het hospitaal � 100", 100));
            this.communityChestCardList.addRandom(
                    new GotoTileCard("Goto Start", "Ga verder naar \"Start\"", aTileList.getTileByName(Tiles.START)));
            this.communityChestCardList
                    .addRandom(new ChoiceCard("Choice", "Betaal � 10 boete of neem een Kanskaart", 10));

            System.out.println(this.communityChestCardList);
        }
        return this.communityChestCardList;
    }

}
