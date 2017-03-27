package nl.gremmee.antopoly.core.cards;

public class Chance extends Card {

    public Chance(CardAction aCardAction, String aName, String aText, int aValue) {
        super(CardType.CT_Chance, aCardAction, aName, aText, aValue);
    }

    // Boete voor te snel rijden ƒ 15
    // Betaal schoolgeld ƒ 150
    // Ga verder naar Barteljorisstraat. Indien u langs "Start" komt, ontvangt u ƒ 200
    // Reis naar station "West" en indien u langs "Start" komt, ontvangt u ƒ 200
    // Ga verder naar "Start"
    // Ga drie plaatsen terug
    // Ga direct naar de gevangenis. Ga niet langs "Start". U ontvangt geen ƒ 200
    // Ga verder naar de Herestraat. Indien u langs "Start" komt ontvangt u ƒ 200
    // De bank betaalt u ƒ 50 dividend
    // Verlaat de gevangenis zonder te betalen
    // Repareer uw huizen. Betaal voor elk huis ƒ 25, betaal voor elk hotel ƒ 100
    // U wordt aangeslagen voor straatgeld. ƒ 40 per huis, ƒ 115 per hotel
    // Uw bouwverzekering vervalt, u ontvangt ƒ 150
    // Aangehouden wegens dronkenschap ƒ 20 boete
    // Ga verder naar Kalverstraat
    // U hebt een kruiswoordpuzzel gewonnen en ontvangt ƒ 100
}
