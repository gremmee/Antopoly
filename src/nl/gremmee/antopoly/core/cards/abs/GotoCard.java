package nl.gremmee.antopoly.core.cards.abs;

public abstract class GotoCard extends Card {

    private boolean forward;

    public GotoCard(String aName, String aText, boolean aForward) {
        super(aName, aText);
        this.setForward(aForward);
    }

    public boolean isForward() {
        return forward;
    }

    private void setForward(boolean aForward) {
        this.forward = aForward;
    }

}
