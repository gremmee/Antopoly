package nl.gremmee.antopoly;

import nl.gremmee.antopoly.core.DiceList;
import nl.gremmee.antopoly.core.cards.ChanceCardList;
import nl.gremmee.antopoly.core.cards.CommunityChestCardList;
import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.core.tiles.TileList;
import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.players.PlayerList;

public class Antopoly {
    private static final int NUM_DICE = 2;
    private static final int NUM_PLAYERS = 8;
    private static DiceList diceList;
    private static ChanceCardList chanceCardList;
    private static CommunityChestCardList communityChestCardList;
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
        tileList = Initialize.getInstance().initializeTileList();
        max += tileList.size();
        chanceCardList = Initialize.getInstance().initializeChanceCards();
        max += chanceCardList.size();
        communityChestCardList = Initialize.getInstance().initializeCommunityChestCards();
        max += communityChestCardList.size();
        playerList = Initialize.getInstance().initializePlayers(NUM_PLAYERS);
        max += playerList.size();

    }

    public static void game() {
        GAME: do {
            for (IPlayer player : playerList) {
                if (!player.isBusted()) {
                    do {
                        player.setActive(true);
                        System.out.println("------------------");
                        System.out.println(player.getName() + " is playing");
                        System.out.println("PlayerTileList = " + player.getTileList().toString());
                        System.out.println("CardList = " + player.getCardList().toString());
                        player.play();
                        player.setActive(false);
                        if (player.getMoney() < 0) {
                            player.setBusted(true);
                            player.setMoney(0);
                            for (ITile tile : player.getTileList()) {
                                tile.setOwner(null);
                            }
                        }
                        System.out.println(playerList);
                    } while (player.isAgain());
                }
            }

        } while (playerList.getWinner() == null);
        IPlayer winner = playerList.getWinner();
        System.out.println("Winner: " + winner.getName());
        System.out.println("Done!");
    }

}
