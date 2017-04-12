package nl.gremmee.antopoly.initialize;

import nl.gremmee.antopoly.core.lists.ArtificialIntelligenceList;
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
        if (this.artificialIntelligenceList == null) {
            System.out.println("Initializing Artificial Intelligences");

            this.artificialIntelligenceList = new ArtificialIntelligenceList();

            artificialIntelligenceList.add(new AIAggressive());
        }
        return artificialIntelligenceList;
    }

}
