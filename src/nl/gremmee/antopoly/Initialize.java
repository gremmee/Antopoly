package nl.gremmee.antopoly;

import nl.gremmee.antopoly.core.DiceList;
import nl.gremmee.antopoly.core.Die;
import nl.gremmee.antopoly.core.Municipality;
import nl.gremmee.antopoly.core.cards.CardAction;
import nl.gremmee.antopoly.core.cards.CardList;
import nl.gremmee.antopoly.core.cards.Chance;
import nl.gremmee.antopoly.core.cards.CommunityChest;
import nl.gremmee.antopoly.core.cards.ICard;
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
    private CardList cardList;
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

    public CardList initializeCards() {
        System.out.println("Initializing Cards");
        cardList = new CardList();
        ICard card = new Chance(CardAction.Pay, "Speeding", "Boete voor te snel rijden ƒ 15", 15);
        cardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");
        card = new CommunityChest(CardAction.Recieve, "Inherit", "U erft ƒ 100", 100);
        cardList.add(card);
        System.out.print("Creating Card " + card.getName() + "...");
        System.out.println("[OK]");
        return cardList;

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
