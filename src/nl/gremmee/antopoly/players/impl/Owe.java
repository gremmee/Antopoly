package nl.gremmee.antopoly.players.impl;

import nl.gremmee.antopoly.players.IPlayer;

public class Owe {

    private IPlayer owesTo;
    private int owesMoney;

    public Owe(final IPlayer aOwesTo, final int aOwes) {
        this.setOwesTo(aOwesTo);
        this.setOwesMoney(aOwes);
    }

    public IPlayer getOwesTo() {
        return this.owesTo;
    }

    public void setOwesTo(final IPlayer aOwesTo) {
        this.owesTo = aOwesTo;
    }

    public int getOwesMoney() {
        return this.owesMoney;
    }

    public void setOwesMoney(final int aOwesMoney) {
        this.owesMoney = aOwesMoney;
    }

    @Override
    public String toString() {
        return "| " + this.getOwesMoney() + " to " + this.getOwesTo() + " |";
    }

    public void resetOwe() {
        this.setOwesTo(null);
        this.setOwesMoney(0);
    }

}
