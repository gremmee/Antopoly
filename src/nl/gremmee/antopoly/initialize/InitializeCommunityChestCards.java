package nl.gremmee.antopoly.initialize;

import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.core.cards.impl.ChoiceCard;
import nl.gremmee.antopoly.core.cards.impl.GetOutOfJailCard;
import nl.gremmee.antopoly.core.cards.impl.GotoCard;
import nl.gremmee.antopoly.core.cards.impl.GotoJailCard;
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

    public CommunityChestCardList initializeCommunityChestCards(TileList aTileList) {
        if (communityChestCardList == null) {
            System.out.println("Initializing Community Chest Cards");
            communityChestCardList = new CommunityChestCardList();

            ICard card = new ReceiveCard("Inherit", "U erft ƒ 100", 100);
            communityChestCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new ReceiveCard("Intrest", "U ontvangt rente van 7% preferente aandelen ƒ 25", 25);
            communityChestCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new ReceiveCard("Mistake Bank", "Een vergissing van de bank in uw voordeel, u ontvangt ƒ 200", 200);
            communityChestCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new GotoCard("Goto Dorpsstraat", "Ga terug naar Dorpsstraat (Ons Dorp)",
                    aTileList.getTileByName(Tiles.MEDITERRANEAN_AVENUE));
            communityChestCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new GotoJailCard();
            communityChestCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new ReceiveCard("Birthday", "U bent jarig en ontvangt van iedere speler ƒ 10", 10);
            communityChestCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new ReceiveCard("Beauty Contest",
                    "U hebt de tweede prijs in een schoonheidswedstrijd gewonnen en ontvangt ƒ 10", 10);
            communityChestCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new PayCard("Doctors bill", "Betaal uw doktersrekening ƒ 50", 50);
            communityChestCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new PayCard("Insurace bill", "Betaal uw verzekeringspremie ƒ 50", 50);
            communityChestCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new ReceiveCard("Sell stock", "Door verkoop van effecten ontvangt u ƒ 50", 50);
            communityChestCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new GetOutOfJailCard("Verlaat de gevangenis", "Verlaat de gevangenis zonder te betalen");
            communityChestCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new ReceiveCard("Refund taxws", "Restitutie inkomstenbelasting, u ontvangt ƒ 20", 20);
            communityChestCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new ReceiveCard("Aannuity", "Lijfrente vervalt, u ontvangt ƒ 100", 100);
            communityChestCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new PayCard("Hospital bill", "Betaal het hospitaal ƒ 100", 100);
            communityChestCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new GotoCard("Goto Start", "Ga verder naar \"Start\"", aTileList.getTileByName(Tiles.START));
            communityChestCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            card = new ChoiceCard("Choice", "Betaal ƒ 10 boete of neem een Kanskaart", 10);
            communityChestCardList.addRandom(card);
            System.out.println("Creating Card " + card.getName() + "...[OK]");

            System.out.println(communityChestCardList);
        }
        return communityChestCardList;
    }

}
