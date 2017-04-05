package nl.gremmee.antopoly.initialize;

import nl.gremmee.antopoly.core.lists.ArtificialIntelligenceList;
import nl.gremmee.antopoly.players.ai.IArtificialIntelligence;
import nl.gremmee.antopoly.players.ai.impl.AIAggressive;

public class InitializeArtificialIntelligences {
    private static InitializeArtificialIntelligences instance;
    private ArtificialIntelligenceList artificialIntelligenceList;

    private InitializeArtificialIntelligences() {
    }

    public static InitializeArtificialIntelligences getInstance() {
        if (instance == null) {
            instance = new InitializeArtificialIntelligences();
        }
        return instance;
    }

    public ArtificialIntelligenceList initializeArtificialIntelligenceList() {
        System.out.println("Initializing Artificial Intelligences");
        artificialIntelligenceList = new ArtificialIntelligenceList();
        IArtificialIntelligence ai = new AIAggressive();
        artificialIntelligenceList.add(ai);
        System.out.println("Creating Artificial Intelligences " + ai + "...[OK]");

        return artificialIntelligenceList;
    }

}
