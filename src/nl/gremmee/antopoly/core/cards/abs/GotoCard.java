package nl.gremmee.antopoly.core.cards.abs;

public abstract class GotoCard extends Card {

    private boolean forward;

    public GotoCard(final String aName, final String aText, final boolean aForward) {
        super(aName, aText);
        this.setForward(aForward);
    }

    public boolean isForward() {
        return this.forward;
    }

    private void setForward(final boolean aForward) {
        this.forward = aForward;
    }

}
