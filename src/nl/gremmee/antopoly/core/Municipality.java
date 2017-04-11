package nl.gremmee.antopoly.core;

import nl.gremmee.antopoly.Settings;

public enum Municipality {

    BLUE(3, 50), BROWN(2, 50), GREEM(3, 200), ORANGE(3, 100), PINK(3, 100), PURPLE(2, 200), RED(3, 150), YELLOW(3, 150);

    private int size;
    private int housePrice;

    private Municipality(final int aSize, final int aHousePrice) {
        this.size = aSize;
        this.housePrice = aHousePrice;
    }

    public int getHousePrice() {
        return this.housePrice * Settings.MONEY_FACTOR;
    }

    public int getSize() {
        return this.size;
    }

    public String getAbbreviation() {
        return this.name().substring(0, 2);
    }
}
