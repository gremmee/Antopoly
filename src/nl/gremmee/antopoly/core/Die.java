package nl.gremmee.antopoly.core;

public class Die {

    private int sides;

    public Die(final int aSides) {
        this.sides = aSides;
    }

    public int getSides() {
        return this.sides;
    }

    public Long roll() {
        Long result = new Long(Math.round(Math.floor(Math.random() * this.sides) + 1));
        return result;
    }
}
