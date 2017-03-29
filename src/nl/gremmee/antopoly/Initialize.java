package nl.gremmee.antopoly;

import nl.gremmee.antopoly.core.DiceList;
import nl.gremmee.antopoly.core.Die;
import nl.gremmee.antopoly.core.Municipality;
import nl.gremmee.antopoly.core.cards.ChanceCardList;
import nl.gremmee.antopoly.core.cards.ChoiceCard;
import nl.gremmee.antopoly.core.cards.CommunityChestCardList;
import nl.gremmee.antopoly.core.cards.GetOutOfJailCard;
import nl.gremmee.antopoly.core.cards.GoDirect;
import nl.gremmee.antopoly.core.cards.GotoCard;
import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.core.cards.PayCard;
import nl.gremmee.antopoly.core.cards.RecieveCard;
import nl.gremmee.antopoly.core.tiles.ChanceTile;
import nl.gremmee.antopoly.core.tiles.CommunityChestTile;
import nl.gremmee.antopoly.core.tiles.GotoJailTile;
import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.core.tiles.JailTile;
import nl.gremmee.antopoly.core.tiles.StartTile;
import nl.gremmee.antopoly.core.tiles.Station;
import nl.gremmee.antopoly.core.tiles.Street;
import nl.gremmee.antopoly.core.tiles.TaxTile;
import nl.gremmee.antopoly.core.tiles.Tile;
import nl.gremmee.antopoly.core.tiles.TileList;
import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.core.tiles.Utility;
import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.players.Player;
import nl.gremmee.antopoly.players.PlayerList;

/**
 * Initialize
 */
public class Initialize {
    private static final long SLEEP = 250;
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

        tile = new Street(i++, "Dorpsstraat", Municipality.OnsDorp, 60, 2/* 10,30,90,160,250 */);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new CommunityChestTile(i++);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Brink", Municipality.OnsDorp, 60, 4 /* 20,60,180,320,450 */);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new TaxTile(i++, 200);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Station(i++, "Station Zuid");
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Steenstraat", Municipality.Arnhem, 100, 6/* 30,90,270,400,550 */);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new ChanceTile(i++);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Ketelstraat", Municipality.Arnhem, 100, 6/* 30,90,270,400,550 */);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Velperplein", Municipality.Arnhem, 120, 8/* 40,100,300,450,600 */);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new JailTile(i++);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Barteljorisstraat", Municipality.Haarlem, 140, 10 /* 50,150,450,625,750 */);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Utility(i++, "Elektriciteitsbedrijf");
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Zijlweg", Municipality.Haarlem, 140, 10 /* 50,150,450,625,750 */);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Houtstraat", Municipality.Haarlem, 160, 12 /* 60,180,500,700,900 */);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Station(i++, "Station West");
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Neude", Municipality.Utrect, 180, 14/* 70,200550,750,950 */);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new CommunityChestTile(i++);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Biltstraat", Municipality.Utrect, 180, 14/* 70,200550,750,950 */);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Vreeburg", Municipality.Utrect, 200, 16/* 80,220,600,800,1000 */);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Tile(i++, "Vrij parkeren", TileType.TT_FreeParking);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "A. Kerkhof", Municipality.Groningen, 220, 18/* 90,250,700,875,1050 */);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new ChanceTile(i++);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Grote Markt", Municipality.Groningen, 220, 18/* 90,250,700,875,1050 */);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Heerestraat", Municipality.Groningen, 240, 20/* 100,300,750,925,1100 */);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Station(i++, "Station Noord");
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Spui", Municipality.DenHaag, 260, 22/* 120,330,800,975,1150 */);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Plein", Municipality.DenHaag, 260, 22/* 120,330,800,975,1150 */);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Utility(i++, "Waterleiding");
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "L. Poten", Municipality.DenHaag, 280, 22/* 120,360,850,1025,1200 */);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new GotoJailTile(i++);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Hofplein", Municipality.Rotterdam, 300, 26/* 130,390,900,1100,1275 */);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Brink", Municipality.Rotterdam, 300, 26/* 130,390,900,1100,1275 */);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new CommunityChestTile(i++);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Coolsingel", Municipality.Rotterdam, 320, 28/* 150,450,1000,1200,1400 */);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Station(i++, "Station Oost");
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new ChanceTile(i++);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Leidsestraat", Municipality.Amsterdam, 350, 35/* 175,500,1100,1300,1500 */);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new TaxTile(i++, 100);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Kalverstraat", Municipality.Amsterdam, 400, 50/* 200,600,1400,1700,2000 */);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");
        return tileList;
    }

    public ChanceCardList initializeChanceCards() {
        System.out.println("Initializing Chance Cards");
        chanceCardList = new ChanceCardList();
        ICard card = new PayCard("Speeding", "Boete voor te snel rijden ƒ 15", 15);
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new PayCard("Schoolfee", "Betaal schoolgeld ƒ 150", 150);
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoCard("Goto Barteljorisstraat",
                "Ga verder naar Barteljorisstraat. Indien u langs \"Start\" komt, ontvangt u ƒ 200",
                tileList.getTileByName("Barteljorisstraat"));
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoCard("Goto West", "Reis naar station \"West\". Indien u langs \"Start\" komt, ontvangt u ƒ 200",
                tileList.getTileByName("Station West"));
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoCard("Goto Start", "Ga verder naar \"Start\"", tileList.getTileByName("Start"));
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoCard("Goto Back 3", "Ga drie plaatsen terug", tileList.get(1));
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GoDirect("Goto Jail", "Ga direct naar de gevangenis. Ga niet langs \"Start\". U ontvangt geen ƒ 20",
                tileList.getTileByName("Naar de gevangenis"));
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoCard("Goto Heerestraat",
                "Ga verder naar Heerestraat. Indien u langs \"Start\" komt, ontvangt u ƒ 200",
                tileList.getTileByName("Heerestraat"));
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new PayCard("Bank pays", "De bank betaalt u ƒ 50 dividend", 50);
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GetOutOfJailCard("Verlaat de gevangenis", "Verlaat de gevangenis zonder te betalen");
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new PayCard("Fix houses", "Repareer uw huizen. Betaal voor elk huis ƒ 25, betaal voor elk hotel ƒ 100",
                50);
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new PayCard("Streettax", "U wordt aangeslagen voor straatgeld. ƒ 40 per huis, ƒ 115 per hotel", 50);
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard("Buildinginsurance", "Uw bouwverzekering vervalt, u ontvangt ƒ 150", 150);
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new PayCard("Drunk", "Aangehouden wegens dronkenschap ƒ 20 boete", 20);
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoCard("Goto Kalverstraat", "Ga verder naar Kalverstraat.",
                tileList.getTileByName("Kalverstraat"));
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard("Crossword puzzle", "U hebt een kruiswoordpuzzel gewonnen en ontvangt ƒ 100", 100);
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");
        System.out.println(chanceCardList);
        return chanceCardList;
    }

    public CommunityChestCardList initializeCommunityChestCards() {
        System.out.println("Initializing Community Chest Cards");
        communityChestCardList = new CommunityChestCardList();
        ICard card = new RecieveCard("Inherit", "U erft ƒ 100", 100);
        communityChestCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard("Intrest", "U ontvangt rente van 7% preferente aandelen ƒ 25", 25);
        communityChestCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard("Mistake Bank", "Een vergissing van de bank in uw voordeel, u ontvangt ƒ 200", 200);
        communityChestCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoCard("Goto Dorpsstraat", "Ga terug naar Dorpsstraat (Ons Dorp)",
                tileList.getTileByName("Dorpsstraat"));
        communityChestCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GoDirect("Goto Jail", "Ga direct naar de gevangenis. Ga niet langs \"Start\". U ontvangt geen ƒ 200",
                tileList.getTileByName("Naar de gevangenis"));
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard("Birthday", "U bent jarig en ontvangt van iedere speler ƒ 10", 10);
        communityChestCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard("Beauty Contest",
                "U hebt de tweede prijs in een schoonheidswedstrijd gewonnen en ontvangt ƒ 10", 10);
        communityChestCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new PayCard("Doctors bill", "Betaal uw doktersrekening ƒ 50", 50);
        communityChestCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new PayCard("Insurace bill", "Betaal uw verzekeringspremie ƒ 50", 50);
        communityChestCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard("Sell stock", "Door verkoop van effecten ontvangt u ƒ 50", 50);
        communityChestCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GetOutOfJailCard("Verlaat de gevangenis", "Verlaat de gevangenis zonder te betalen");
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard("Refund taxws", "Restitutie inkomstenbelasting, u ontvangt ƒ 20", 20);
        communityChestCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard("Aannuity", "Lijfrente vervalt, u ontvangt ƒ 100", 100);
        communityChestCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new PayCard("Hospital bill", "Betaal het hospitaal ƒ 100", 100);
        communityChestCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoCard("Goto Start", "Ga verder naar \"Start\"", tileList.getTileByName("Start"));
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new ChoiceCard("Choice", "Betaal ƒ 10 boete of neem een Kanskaart", 10);
        communityChestCardList.add(card);
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
