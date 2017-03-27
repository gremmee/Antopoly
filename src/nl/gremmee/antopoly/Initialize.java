package nl.gremmee.antopoly;

import java.util.ArrayList;
import java.util.List;

import nl.gremmee.antopoly.core.DiceList;
import nl.gremmee.antopoly.core.Die;
import nl.gremmee.antopoly.core.Municipality;
import nl.gremmee.antopoly.core.Player;
import nl.gremmee.antopoly.core.cards.CardAction;
import nl.gremmee.antopoly.core.cards.CardList;
import nl.gremmee.antopoly.core.cards.Chance;
import nl.gremmee.antopoly.core.cards.CommunityChest;
import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.core.tiles.TileList;
import nl.gremmee.antopoly.core.tiles.streets.Street;

/**
 * Initialize
 */
public class Initialize {
    private static final long SLEEP = 250;
    private static Initialize instance;
    private DiceList diceList;
    private CardList cardList;
    private ArrayList<Player> playerList;
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

    public List<Player> initializePlayers(int aNumPlayers) {
        System.out.println("Initializing Players");
        playerList = new ArrayList<Player>();
        for (int i = 0; i < aNumPlayers; i++) {
            System.out.print("Creating Player " + (i + 1) + "...");
            Player player = new Player(i + 1, "Player " + (i + 1));
            playerList.add(player);
            System.out.println("[OK]");
            repaint("Creating Player " + (i + 1) + "...");
        }
        return playerList;
    }

    public TileList initializeTileList() {
        System.out.println("Initializing Tiles");
        tileList = new TileList();
        ITile tile = new Street("Kalverstraat", Municipality.Amsterdam, 5000);
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
}
