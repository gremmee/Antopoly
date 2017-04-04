package nl.gremmee.antopoly.rules.abs;

import nl.gremmee.antopoly.rules.IRule;

public abstract class Rule implements IRule {

    private String name;

    public Rule(String aName) {
        this.setName(aName);
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        this.name = aName;
    }

    @Override
    public String toString() {
        return ("|" + this.getName() + "|");
    }
}
