package nl.gremmee.antopoly.core.lists;

import java.util.ArrayList;

import nl.gremmee.antopoly.players.ai.IArtificialIntelligence;

public class ArtificialIntelligenceList extends ArrayList<IArtificialIntelligence> {

    private static final long serialVersionUID = 7932809588117562310L;

    public IArtificialIntelligence getAIByName(String aName) {
        for (IArtificialIntelligence artificialIntelligence : this) {
            if (artificialIntelligence.getName().equals(aName))
                return artificialIntelligence;
        }
        return null;
    }

}
