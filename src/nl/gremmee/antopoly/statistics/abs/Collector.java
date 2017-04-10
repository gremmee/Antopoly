package nl.gremmee.antopoly.statistics.abs;

import nl.gremmee.antopoly.statistics.ICollector;

public abstract class Collector implements ICollector {

    private String name;

    public Collector(final String aName) {
        this.setName(aName);
    }

    public String getName() {
        return name;
    }

    public void setName(final String aName) {
        this.name = aName;
    }

    @Override
    public String toString() {
        return "| " + this.getName() + " |";
    }
}
