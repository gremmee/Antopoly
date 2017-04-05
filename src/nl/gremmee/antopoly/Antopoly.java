package nl.gremmee.antopoly;

import nl.gremmee.antopoly.core.lists.ArtificialIntelligenceList;
import nl.gremmee.antopoly.core.lists.ChanceCardList;
import nl.gremmee.antopoly.core.lists.CommunityChestCardList;
import nl.gremmee.antopoly.core.lists.DiceList;
import nl.gremmee.antopoly.core.lists.PlayerList;
import nl.gremmee.antopoly.core.lists.RuleList;
import nl.gremmee.antopoly.core.lists.TileList;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.statistics.InitializeStatistics;

public class Antopoly {
    private static DiceList diceList;
    private static ChanceCardList chanceCardList;
    private static CommunityChestCardList communityChestCardList;
    private static PlayerList playerList;
    private static TileList tileList;
    private static RuleList ruleList;
    private static ArtificialIntelligenceList artificialIntelligenceList;

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
        diceList = Initialize.getInstance().initializeDiceList(Settings.NUM_DICE);
        int max = diceList.size();
        tileList = Initialize.getInstance().initializeTileList();
        max += tileList.size();
        ruleList = Initialize.getInstance().initializeRuleList();
        max += ruleList.size();
        chanceCardList = Initialize.getInstance().initializeChanceCardsList();
        max += chanceCardList.size();
        communityChestCardList = Initialize.getInstance().initializeCommunityChestCardsList();
        max += communityChestCardList.size();
        artificialIntelligenceList = Initialize.getInstance().initializeArtificialIntelligenceList();
        max += artificialIntelligenceList.size();
        playerList = Initialize.getInstance().initializePlayerList(Settings.NUM_PLAYERS);
        max += playerList.size();

    }

    public static void game() {
        long round = 0;
        do {
            for (IPlayer player : playerList) {
                if (!player.isBusted()) {
                    do {
                        player.setActive(true);
                        System.out.println("------------------");
                        System.out.println(player.getName() + " is playing");
                        System.out.println("PlayerTileList = " + player.getTileList().toString());
                        System.out.println("CardList = " + player.getCardList().toString());
                        System.out.println("CurrentTile = " + player.getCurrentTile());
                        player.play();
                        player.setActive(false);
                        System.out.println(playerList);
                    } while (player.isAgain());
                }
            }
            round++;
            System.out.println("------------------");
            System.out.println("Round " + round);
            System.out.println(InitializeStatistics.getInstance().getCollectorList());
        } while (playerList.getWinner() == null);
        IPlayer winner = playerList.getWinner();
        System.out.println("Winner: " + winner.getName());
        System.out.println(winner.getTileList());
        System.out.println("Money " + winner.getMoney());
        System.out.println("Done!");
    }

}
