package nl.gremmee.antopoly;

import nl.gremmee.antopoly.core.DiceList;
import nl.gremmee.antopoly.core.cards.CardList;
import nl.gremmee.antopoly.core.tiles.TileList;
import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.players.PlayerList;

public class Antopoly {
    private static final int NUM_DICE = 2;
    private static final int NUM_PLAYERS = 4;
    private static DiceList diceList;
    private static CardList cardList;
    private static PlayerList playerList;
    private static TileList tileList;

    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();
        System.out.println("Starting application " + Antopoly.class.getSimpleName() + "...");
        System.out.println("Initializing...");
        initialize();
        System.out.println("Running...");
        game();
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

    public static void game() {
        GAME: do {
            for (IPlayer player : playerList) {
                player.setActive(true);
                System.out.println(player.getName() + " is playing");
                System.out.println("PlayerTileList = " + player.getTileList().toString());
                // int points = player.play();
                if (player.getName().contains("4")) {
                    player.setWinner(true);
                }
                if (player.isWinner()) {
                    break;
                }
                player.setActive(false);
            }
        } while (!playerList.isWinner());
        IPlayer winner = playerList.getWinner();
        System.out.println("Winner: " + winner.getName());
        System.out.println("Done!");
    }

}
