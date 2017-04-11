package nl.gremmee.antopoly.players.impl;

import nl.gremmee.antopoly.players.IPlayer;

public class Owe {

    private IPlayer owesTo;
    private int owes;

    public Owe(final IPlayer aOwesTo, final int aOwes) {
        this.setOwesTo(aOwesTo);
        this.setOwes(aOwes);
    }

    public IPlayer getOwesTo() {
        return this.owesTo;
    }

    public void setOwesTo(final IPlayer aOwesTo) {
        this.owesTo = aOwesTo;
    }

    public int getOwes() {
        return this.owes;
    }

    public void setOwes(final int aOwes) {
        this.owes = aOwes;
    }

}
