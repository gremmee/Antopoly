package nl.gremmee.antopoly.core;

public enum Municipality {

    Amsterdam(2, 200), Arnhem(3, 50), DenHaag(3, 150), Groningen(3, 150), Haarlem(3, 100), OnsDorp(2, 50), Rotterdam(3,
            200), Utrect(3, 100);

    private int size;

    private Municipality(int aSize, int aHousePrice) {
        this.size = aSize;
    }

    public int getSize() {
        return this.size;
    }

}
