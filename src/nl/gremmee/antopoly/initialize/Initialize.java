package nl.gremmee.antopoly.initialize;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.lists.ArtificialIntelligenceList;
import nl.gremmee.antopoly.core.lists.ChanceCardList;
import nl.gremmee.antopoly.core.lists.CommunityChestCardList;
import nl.gremmee.antopoly.core.lists.DiceList;
import nl.gremmee.antopoly.core.lists.PlayerList;
import nl.gremmee.antopoly.core.lists.RuleList;
import nl.gremmee.antopoly.core.lists.TileList;
import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.rules.IRule;
import nl.gremmee.antopoly.statistics.InitializeStatistics;

/**
 * Initialize
 */
public class Initialize {
    private static Initialize instance;
    private ChanceCardList chanceCardList;
    private CommunityChestCardList communityChestCardList;
    private DiceList diceList;
    private PlayerList playerList;
    private RuleList ruleList;
    private ArtificialIntelligenceList artificialIntelligenceList;
    private Settings settings;
    private TileList tileList;

    private Initialize() {
        settings = new Settings();
        InitializeStatistics.getInstance().initializeCollectors();
    }

    public static Initialize getInstance() {
        if (instance == null) {
            instance = new Initialize();
        }
        return instance;
    }

    public Settings getSettings() {
        return this.settings;
    }

    public void executeRules(IPlayer aPlayer) {
        RuleList ruleList = Initialize.getInstance().getRuleList();
        for (IRule rule : ruleList) {
            System.out.println("Checking rule: " + rule + "...");
            rule.execute(aPlayer);
        }

    }

    public ArtificialIntelligenceList getArtificialIntelligenceList() {
        return this.artificialIntelligenceList;
    }

    public ArtificialIntelligenceList initializeArtificialIntelligenceList() {
        return this.artificialIntelligenceList = InitializeArtificialIntelligences.getInstance()
                .initializeArtificialIntelligenceList();
    }

    public ChanceCardList getChanceCardList() {
        return this.chanceCardList;
    }

    public ChanceCardList initializeChanceCardsList() {
        return this.chanceCardList = InitializeChanceCards.getInstance().initializeChanceCards(initializeTileList());
    }

    public CommunityChestCardList getCommunityChestCardList() {
        return this.communityChestCardList;
    }

    public CommunityChestCardList initializeCommunityChestCardsList() {
        return this.communityChestCardList = InitializeCommunityChestCards.getInstance()
                .initializeCommunityChestCards(initializeTileList());
    }

    public DiceList getDiceList() {
        return this.diceList;
    }

    public DiceList initializeDiceList(int aNumDice) {
        return this.diceList = InitializeDice.getInstance().initializeDice(aNumDice);
    }

    public PlayerList getPlayerList() {
        return this.playerList;
    }

    public PlayerList initializePlayerList(int aNumPlayers) {
        return this.playerList = InitializePlayers.getInstance().initializePlayers(aNumPlayers);
    }

    public RuleList getRuleList() {
        return this.ruleList;
    }

    public RuleList initializeRuleList() {
        return this.ruleList = InitializeRules.getInstance().initializeRules();
    }

    public TileList getTileList() {
        return this.tileList;
    }

    public TileList initializeTileList() {
        return this.tileList = InitializeTiles.getInstance().initializeTileList();
    }
}
