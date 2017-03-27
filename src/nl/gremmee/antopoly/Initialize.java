package nl.gremmee.antopoly;

import nl.gremmee.antopoly.core.DiceList;
import nl.gremmee.antopoly.core.Die;
import nl.gremmee.antopoly.core.Municipality;
import nl.gremmee.antopoly.core.cards.CardType;
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
import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.core.tiles.Station;
import nl.gremmee.antopoly.core.tiles.Street;
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

        ITile tile = new Tile(i++, "Start", TileType.TT_Start);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Dorpsstraat", Municipality.OnsDorp, 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new CommunityChestTile(i++);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Brink", Municipality.OnsDorp, 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Tile(i++, "Income Taxes", TileType.TT_IncomeTaxes);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Station(i++, "Station Zuid", 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Steenstraat", Municipality.Arnhem, 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new ChanceTile(i++);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Ketelstraat", Municipality.Arnhem, 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Velperplein", Municipality.Arnhem, 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Tile(i++, "Jail", TileType.TT_Jail);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Barteljorisstraat", Municipality.Haarlem, 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Utility(i++, "Elektriciteitsbedrijf", 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Zijlweg", Municipality.Haarlem, 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Houtstraat", Municipality.Haarlem, 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Station(i++, "Station West", 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Neude", Municipality.Utrect, 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new CommunityChestTile(i++);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Biltstraat", Municipality.Utrect, 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Vreeburg", Municipality.Utrect, 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Tile(i++, "Vrij parkeren", TileType.TT_FreeParking);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "A. Kerkhof", Municipality.Groningen, 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new ChanceTile(i++);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Grote Markt", Municipality.Groningen, 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Heerestraat", Municipality.Groningen, 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Station(i++, "Station Noord", 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Spui", Municipality.DenHaag, 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Plein", Municipality.DenHaag, 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Utility(i++, "Waterleiding", 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "L. Poten", Municipality.DenHaag, 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Tile(i++, "Naar de gevangenis", TileType.TT_GotoJail);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Hofplein", Municipality.Rotterdam, 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Brink", Municipality.Rotterdam, 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new CommunityChestTile(i++);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Coolsingel", Municipality.Rotterdam, 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Station(i++, "Station Oost", 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new ChanceTile(i++);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Leidsestraat", Municipality.Amsterdam, 5000);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Tile(i++, "Extra belasting", TileType.TT_ExtraTaxes);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new Street(i++, "Kalverstraat", Municipality.Amsterdam, 5000);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");
        return tileList;
    }

    public ChanceCardList initializeChanceCards() {
        System.out.println("Initializing Chance Cards");
        chanceCardList = new ChanceCardList();
        ICard card = new PayCard(CardType.CT_Chance, "Speeding", "Boete voor te snel rijden ƒ 15", 15);
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new PayCard(CardType.CT_Chance, "Schoolfee", "Betaal schoolgeld ƒ 150", 150);
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoCard(CardType.CT_Chance, "Goto Barteljorisstraat",
                "Ga verder naar Barteljorisstraat. Indien u langs \"Start\" komt, ontvangt u ƒ 200", tileList.get(1));
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoCard(CardType.CT_Chance, "Goto West",
                "Reis naar station \"West\". Indien u langs \"Start\" komt, ontvangt u ƒ 200", tileList.get(1));
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoCard(CardType.CT_Chance, "Goto Start", "Ga verder naar \"Start\"", tileList.get(1));
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoCard(CardType.CT_Chance, "Goto Back 3", "Ga drie plaatsen terug", tileList.get(1));
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GoDirect(CardType.CT_Chance, "Goto Jail",
                "Ga direct naar de gevangenis. Ga niet langs \"Start\". U ontvangt geen ƒ 20", tileList.get(10));
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoCard(CardType.CT_Chance, "Goto Heerestraat",
                "Ga verder naar Heerestraat. Indien u langs \"Start\" komt, ontvangt u ƒ 200", tileList.get(1));
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new PayCard(CardType.CT_Chance, "Bank pays", "De bank betaalt u ƒ 50 dividend", 50);
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GetOutOfJailCard(CardType.CT_Chance, "Verlaat de gevangenis",
                "Verlaat de gevangenis zonder te betalen");
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new PayCard(CardType.CT_Chance, "Fix houses",
                "Repareer uw huizen. Betaal voor elk huis ƒ 25, betaal voor elk hotel ƒ 100", 50);
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new PayCard(CardType.CT_Chance, "Streettax",
                "U wordt aangeslagen voor straatgeld. ƒ 40 per huis, ƒ 115 per hotel", 50);
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard(CardType.CT_Chance, "Buildinginsurance", "Uw bouwverzekering vervalt, u ontvangt ƒ 150",
                150);
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new PayCard(CardType.CT_Chance, "Drunk", "Aangehouden wegens dronkenschap ƒ 20 boete", 20);
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoCard(CardType.CT_Chance, "Goto Kalverstraat", "Ga verder naar Kalverstraat.", tileList.get(1));
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard(CardType.CT_Chance, "Crossword puzzle",
                "U hebt een kruiswoordpuzzel gewonnen en ontvangt ƒ 100", 100);
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");
        return chanceCardList;
    }

    public CommunityChestCardList initializeCommunityChestCards() {
        System.out.println("Initializing Community Chest Cards");
        communityChestCardList = new CommunityChestCardList();
        ICard card = new RecieveCard(CardType.CT_CommunityChest, "Inherit", "U erft ƒ 100", 100);
        communityChestCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard(CardType.CT_CommunityChest, "Intrest",
                "U ontvangt rente van 7% preferente aandelen ƒ 25", 25);
        communityChestCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard(CardType.CT_CommunityChest, "Mistake Bank",
                "Een vergissing van de bank in uw voordeel, u ontvangt ƒ 200", 200);
        communityChestCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoCard(CardType.CT_CommunityChest, "Goto Dorpsstraat", "Ga terug naar Dorpsstraat (Ons Dorp)",
                tileList.get(1));
        communityChestCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GoDirect(CardType.CT_CommunityChest, "Goto Jail",
                "Ga direct naar de gevangenis. Ga niet langs \"Start\". U ontvangt geen ƒ 200", tileList.get(1));
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard(CardType.CT_CommunityChest, "Birthday",
                "U bent jarig en ontvangt van iedere speler ƒ 10", 10);
        communityChestCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard(CardType.CT_CommunityChest, "Beauty Contest",
                "U hebt de tweede prijs in een schoonheidswedstrijd gewonnen en ontvangt ƒ 10", 10);
        communityChestCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new PayCard(CardType.CT_CommunityChest, "Doctors bill", "Betaal uw doktersrekening ƒ 50", 50);
        communityChestCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new PayCard(CardType.CT_CommunityChest, "Insurace bill", "Betaal uw verzekeringspremie ƒ 50", 50);
        communityChestCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard(CardType.CT_CommunityChest, "Sell stock", "Door verkoop van effecten ontvangt u ƒ 50",
                50);
        communityChestCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GetOutOfJailCard(CardType.CT_CommunityChest, "Verlaat de gevangenis",
                "Verlaat de gevangenis zonder te betalen");
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard(CardType.CT_CommunityChest, "Refund taxws",
                "Restitutie inkomstenbelasting, u ontvangt ƒ 20", 20);
        communityChestCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new RecieveCard(CardType.CT_CommunityChest, "Aannuity", "Lijfrente vervalt, u ontvangt ƒ 100", 100);
        communityChestCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new PayCard(CardType.CT_CommunityChest, "Hospital bill", "Betaal het hospitaal ƒ 100", 100);
        communityChestCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new GotoCard(CardType.CT_CommunityChest, "Goto Start", "Ga verder naar \"Start\"", tileList.get(1));
        chanceCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

        card = new ChoiceCard(CardType.CT_CommunityChest, "Choice", "Betaal ƒ 10 boete of neem een Kanskaart", 10);
        communityChestCardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");

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
}
