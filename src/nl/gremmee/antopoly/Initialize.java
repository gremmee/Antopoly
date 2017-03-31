package nl.gremmee.antopoly;

import nl.gremmee.antopoly.core.DiceList;
import nl.gremmee.antopoly.core.Die;
import nl.gremmee.antopoly.core.Municipality;
import nl.gremmee.antopoly.core.cards.ChanceCardList;
import nl.gremmee.antopoly.core.cards.ChoiceCard;
import nl.gremmee.antopoly.core.cards.CommunityChestCardList;
import nl.gremmee.antopoly.core.cards.GetOutOfJailCard;
import nl.gremmee.antopoly.core.cards.GotoCard;
import nl.gremmee.antopoly.core.cards.GotoJailCard;
import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.core.cards.PayCard;
import nl.gremmee.antopoly.core.cards.PayPropertyCard;
import nl.gremmee.antopoly.core.cards.RecieveCard;
import nl.gremmee.antopoly.core.tiles.ChanceTile;
import nl.gremmee.antopoly.core.tiles.CommunityChestTile;
import nl.gremmee.antopoly.core.tiles.FreeParkingTile;
import nl.gremmee.antopoly.core.tiles.GotoJailTile;
import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.core.tiles.JailTile;
import nl.gremmee.antopoly.core.tiles.StartTile;
import nl.gremmee.antopoly.core.tiles.StationTile;
import nl.gremmee.antopoly.core.tiles.StreetTile;
import nl.gremmee.antopoly.core.tiles.TaxTile;
import nl.gremmee.antopoly.core.tiles.TileList;
import nl.gremmee.antopoly.core.tiles.UtilityTile;
import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.players.Player;
import nl.gremmee.antopoly.players.PlayerList;

/**
 * Initialize
 */
public class Initialize {
    private static final long SLEEP = 0;
    private static Initialize instance;
    private DiceList diceList;
    private ChanceCardList chanceCardList;
    private CommunityChestCardList communityChestCardList;
    private PlayerList playerList;
    private TileList tileList;

    private Initialize() {
    }

    public static Initialize getInstance() {
        if (instance == null) {
            instance = new Initialize();
        }
        return instance;
    }

    public DiceList initializeDice(int aNumDice) {
        System.out.println("Initializing Dice");
        diceList = new DiceList();
        for (int i = 0; i < aNumDice; i++) {
            System.out.print("Creating Die " + (i + 1) + "...");
            Die die = new Die(6);
            diceList.add(die);
            System.out.println("[OK]");
            repaint("Creating Die " + (i + 1) + "...");
        }
        return diceList;
    }

    public PlayerList initializePlayers(int aNumPlayers) {
        System.out.println("Initializing Players");
        playerList = new PlayerList();
        for (int i = 0; i < aNumPlayers; i++) {
            System.out.print("Creating Player " + (i + 1) + "...");
            IPlayer player = new Player(i + 1, "Player " + (i + 1));
            player.setCurrentTile(Initialize.getInstance().getTileList().getTileByName("Start"));
            playerList.add(player);
            System.out.println("[OK]");
            repaint("Creating Player " + (i + 1) + "...");
        }
        return playerList;
    }

    public TileList initializeTileList() {
        System.out.println("Initializing Tiles");
        tileList = new TileList();
        int i = 0;

        ITile tile = new StartTile(i++);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Dorpsstraat", Municipality.OnsDorp, 60, 2, 10, 30, 90, 160, 250);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new CommunityChestTile(i++, 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Brink", Municipality.OnsDorp, 60, 4, 20, 60, 180, 320, 450);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new TaxTile(i++, "Income Taxes", 200);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StationTile(i++, "Station Zuid");
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Steenstraat", Municipality.Arnhem, 100, 6, 30, 90, 270, 400, 550);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new ChanceTile(i++, 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Ketelstraat", Municipality.Arnhem, 100, 6, 30, 90, 270, 400, 550);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Velperplein", Municipality.Arnhem, 120, 8, 40, 100, 300, 450, 600);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new JailTile(i++);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Barteljorisstraat", Municipality.Haarlem, 140, 10, 50, 150, 450, 625, 750);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new UtilityTile(i++, "Elektriciteitsbedrijf");
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Zijlweg", Municipality.Haarlem, 140, 10, 50, 150, 450, 625, 750);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Houtstraat", Municipality.Haarlem, 160, 12, 60, 180, 500, 700, 900);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StationTile(i++, "Station West");
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Neude", Municipality.Utrect, 180, 14, 70, 200, 550, 750, 950);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new CommunityChestTile(i++, 2);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Biltstraat", Municipality.Utrect, 180, 14, 70, 200, 550, 750, 950);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Vreeburg", Municipality.Utrect, 200, 16, 80, 220, 600, 800, 1000);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new FreeParkingTile(i++);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "A. Kerkhof", Municipality.Groningen, 220, 18, 90, 250, 700, 875, 1050);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new ChanceTile(i++, 2);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Grote Markt", Municipality.Groningen, 220, 18, 90, 250, 700, 875, 1050);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Heerestraat", Municipality.Groningen, 240, 20, 100, 300, 750, 925, 1100);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StationTile(i++, "Station Noord");
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Spui", Municipality.DenHaag, 260, 22, 120, 330, 800, 975, 1150);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Plein", Municipality.DenHaag, 260, 22, 120, 330, 800, 975, 1150);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new UtilityTile(i++, "Waterleiding");
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "L. Poten", Municipality.DenHaag, 280, 22, 120, 360, 850, 1025, 1200);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new GotoJailTile(i++);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Hofplein", Municipality.Rotterdam, 300, 26, 130, 390, 900, 1100, 1275);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Blaak", Municipality.Rotterdam, 300, 26, 130, 390, 900, 1100, 1275);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new CommunityChestTile(i++, 3);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Coolsingel", Municipality.Rotterdam, 320, 28, 150, 450, 1000, 1200, 1400);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StationTile(i++, "Station Oost");
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new ChanceTile(i++, 3);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Leidsestraat", Municipality.Amsterdam, 350, 35, 175, 500, 1100, 1300, 1500);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new TaxTile(i++, "Taxes", 100);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Kalverstraat", Municipality.Amsterdam, 400, 50, 200, 600, 1400, 1700, 2000);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");
        return tileList;
    }

    public ChanceCardList initializeChanceCards() {
        System.out.println("Initializing Chance Cards");
        chanceCardList = new ChanceCardList();
        ICard card = new PayCard("Speeding", "Boete voor te snel rijden ƒ 15", 15);
        chanceCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new PayCard("Schoolfee", "Betaal schoolgeld ƒ 150", 150);
        chanceCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoCard("Goto Barteljorisstraat",
                "Ga verder naar Barteljorisstraat. Indien u langs \"Start\" komt, ontvangt u ƒ 200",
                tileList.getTileByName("Barteljorisstraat"));
        chanceCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoCard("Goto West", "Reis naar station \"West\". Indien u langs \"Start\" komt, ontvangt u ƒ 200",
                tileList.getTileByName("Station West"));
        chanceCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoCard("Goto Start", "Ga verder naar \"Start\"", tileList.getTileByName("Start"));
        chanceCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoCard("Goto Back 3", "Ga drie plaatsen terug", tileList.get(1));
        chanceCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoJailCard();
        chanceCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoCard("Goto Heerestraat",
                "Ga verder naar Heerestraat. Indien u langs \"Start\" komt, ontvangt u ƒ 200",
                tileList.getTileByName("Heerestraat"));
        chanceCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new PayCard("Bank pays", "De bank betaalt u ƒ 50 dividend", 50);
        chanceCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GetOutOfJailCard("Verlaat de gevangenis", "Verlaat de gevangenis zonder te betalen");
        chanceCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new PayPropertyCard("Fix houses",
                "Repareer uw huizen. Betaal voor elk huis ƒ 25, betaal voor elk hotel ƒ 100", 25, 100);
        chanceCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new PayPropertyCard("Streettax", "U wordt aangeslagen voor straatgeld. ƒ 40 per huis, ƒ 115 per hotel",
                40, 115);
        chanceCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard("Buildinginsurance", "Uw bouwverzekering vervalt, u ontvangt ƒ 150", 150);
        chanceCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new PayCard("Drunk", "Aangehouden wegens dronkenschap ƒ 20 boete", 20);
        chanceCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoCard("Goto Kalverstraat", "Ga verder naar Kalverstraat.",
                tileList.getTileByName("Kalverstraat"));
        chanceCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard("Crossword puzzle", "U hebt een kruiswoordpuzzel gewonnen en ontvangt ƒ 100", 100);
        chanceCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");
        System.out.println(chanceCardList);
        return chanceCardList;
    }

    public CommunityChestCardList initializeCommunityChestCards() {
        System.out.println("Initializing Community Chest Cards");
        communityChestCardList = new CommunityChestCardList();
        ICard card = new RecieveCard("Inherit", "U erft ƒ 100", 100);
        communityChestCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard("Intrest", "U ontvangt rente van 7% preferente aandelen ƒ 25", 25);
        communityChestCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard("Mistake Bank", "Een vergissing van de bank in uw voordeel, u ontvangt ƒ 200", 200);
        communityChestCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoCard("Goto Dorpsstraat", "Ga terug naar Dorpsstraat (Ons Dorp)",
                tileList.getTileByName("Dorpsstraat"));
        communityChestCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoJailCard();
        communityChestCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard("Birthday", "U bent jarig en ontvangt van iedere speler ƒ 10", 10);
        communityChestCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard("Beauty Contest",
                "U hebt de tweede prijs in een schoonheidswedstrijd gewonnen en ontvangt ƒ 10", 10);
        communityChestCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new PayCard("Doctors bill", "Betaal uw doktersrekening ƒ 50", 50);
        communityChestCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new PayCard("Insurace bill", "Betaal uw verzekeringspremie ƒ 50", 50);
        communityChestCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard("Sell stock", "Door verkoop van effecten ontvangt u ƒ 50", 50);
        communityChestCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GetOutOfJailCard("Verlaat de gevangenis", "Verlaat de gevangenis zonder te betalen");
        communityChestCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard("Refund taxws", "Restitutie inkomstenbelasting, u ontvangt ƒ 20", 20);
        communityChestCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard("Aannuity", "Lijfrente vervalt, u ontvangt ƒ 100", 100);
        communityChestCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new PayCard("Hospital bill", "Betaal het hospitaal ƒ 100", 100);
        communityChestCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoCard("Goto Start", "Ga verder naar \"Start\"", tileList.getTileByName("Start"));
        communityChestCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new ChoiceCard("Choice", "Betaal ƒ 10 boete of neem een Kanskaart", 10);
        communityChestCardList.addRandom(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        System.out.println(communityChestCardList);
        return communityChestCardList;
    }

    private void repaint(String aMessage) {
        sleep();
    }

    private void sleep() {
        try {
            Thread.sleep(SLEEP);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public DiceList getDiceList() {

        return this.diceList;
    }

    public ChanceCardList getChanceCardList() {

        return this.chanceCardList;
    }

    public CommunityChestCardList getCommunityChestCardList() {

        return this.communityChestCardList;
    }

    public TileList getTileList() {

        return this.tileList;
    }
}
