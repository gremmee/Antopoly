package nl.gremmee.antopoly.players.ai.abs;

import nl.gremmee.antopoly.players.ai.IArtificialIntelligence;

public abstract class ArtificialIntelligence implements IArtificialIntelligence {

    private String name;

    public ArtificialIntelligence(String aName) {
        this.setName(aName);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String aName) {
        this.name = aName;
    }

}
