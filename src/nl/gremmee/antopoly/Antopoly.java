package nl.gremmee.antopoly;

import java.util.List;

import nl.gremmee.antopoly.core.DiceList;
import nl.gremmee.antopoly.core.Player;
import nl.gremmee.antopoly.core.cards.CardList;
import nl.gremmee.antopoly.core.tiles.TileList;

public class Antopoly {
    private static final int NUM_DICE = 2;
    private static final int NUM_PLAYERS = 2;
    private static DiceList diceList;
    private static CardList cardList;
    private static List<Player> playerList;
    private static TileList tileList;

    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();
        System.out.println("Starting application " + Antopoly.class.getSimpleName() + "...");
        System.out.println("Initializing...");
        initialize();
        System.out.println("Running...");
        // game();
        System.out.println("Stopping application " + Antopoly.class.getSimpleName() + "...");
        long endTime = System.currentTimeMillis() - beginTime;
        System.out.println("Time (in ms): " + endTime);

    }

    public static void initialize() {
        Initialize.getInstance();
        diceList = Initialize.getInstance().initializeDice(NUM_DICE);
        int max = diceList.size();
        cardList = Initialize.getInstance().initializeCards();
        max += cardList.size();
        tileList = Initialize.getInstance().initializeTileList();
        max += tileList.size();
        playerList = Initialize.getInstance().initializePlayers(NUM_PLAYERS);
        max += playerList.size();

    }

}
