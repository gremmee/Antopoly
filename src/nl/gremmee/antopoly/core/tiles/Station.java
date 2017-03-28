package nl.gremmee.antopoly.core.tiles;

public class Station extends Property {
    
    public static final int PRICE_ONE = 25;
    public static final int PRICE_TWO = 50;
    public static final int PRICE_THREE = 100;
    public static final int PRICE_FOUR = 200;

    public Station(int aID, String aName) {
        super(aID, aName, TileType.TT_Station, 200);
    }

}
