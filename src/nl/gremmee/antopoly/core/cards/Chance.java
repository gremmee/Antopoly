package nl.gremmee.antopoly.core.cards;

public class Chance extends Card {

    public Chance(CardAction aCardAction, String aName, String aText, int aValue) {
        super(CardType.CT_Chance, aCardAction, aName, aText, aValue);
    }

    // Boete voor te snel rijden � 15
    // Betaal schoolgeld � 150
    // Ga verder naar Barteljorisstraat. Indien u langs "Start" komt, ontvangt u � 200
    // Reis naar station "West" en indien u langs "Start" komt, ontvangt u � 200
    // Ga verder naar "Start"
    // Ga drie plaatsen terug
    // Ga direct naar de gevangenis. Ga niet langs "Start". U ontvangt geen � 200
    // Ga verder naar de Herestraat. Indien u langs "Start" komt ontvangt u � 200
    // De bank betaalt u � 50 dividend
    // Verlaat de gevangenis zonder te betalen
    // Repareer uw huizen. Betaal voor elk huis � 25, betaal voor elk hotel � 100
    // U wordt aangeslagen voor straatgeld. � 40 per huis, � 115 per hotel
    // Uw bouwverzekering vervalt, u ontvangt � 150
    // Aangehouden wegens dronkenschap � 20 boete
    // Ga verder naar Kalverstraat
    // U hebt een kruiswoordpuzzel gewonnen en ontvangt � 100
}
