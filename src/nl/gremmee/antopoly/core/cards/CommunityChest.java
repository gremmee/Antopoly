package nl.gremmee.antopoly.core.cards;

public class CommunityChest extends Card {

    public CommunityChest(CardAction aCardAction, String aName, String aText, int aValue) {
        super(CardType.CommunityChest, aCardAction, aName, aText, aValue);
    }

    // U erft � 100
    // U ontvangt rente van 7% preferente aandelen � 25
    // Een vergissing van de bank in uw voordeel, u ontvangt � 200
    // Ga terug naar Dorpsstraat (Ons Dorp)
    // Ga direct naar de gevangenis. Ga niet langs "Start", u ontvangt geen � 200
    // U bent jarig en ontvangt van iedere speler � 10
    // U hebt de tweede prijs in een schoonheidswedstrijd gewonnen en ontvangt � 10
    // Betaal uw doktersrekening � 50
    // Betaal uw verzekeringspremie � 50
    // Door verkoop van effecten ontvangt u � 50
    // Verlaat de gevangenis zonder betalen
    // Restitutie inkomstenbelasting, u ontvangt � 20
    // Lijfrente vervalt, u ontvangt � 100
    // Betaal het hospitaal � 100
    // Ga verder naar "Start"
    // Betaal � 10 boete of neem een Kanskaart
}
