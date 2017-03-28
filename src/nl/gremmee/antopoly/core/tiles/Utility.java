package nl.gremmee.antopoly.core.tiles;

public class Utility extends Property {

    public static final int FACTOR_OWN_SINGLE = 4;
    public static final int FACTOR_OWN_DOUBLE = 10;

    public Utility(int aID, String aName) {
        super(aID, aName, TileType.TT_Utility, 150);
    }

}
