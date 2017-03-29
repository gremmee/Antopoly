package nl.gremmee.antopoly.core.tiles;

public class UtilityTile extends PropertyTile {

    public static final int FACTOR_OWN_SINGLE = 4;
    public static final int FACTOR_OWN_DOUBLE = 10;

    public UtilityTile(int aID, String aName) {
        super(aID, aName, TileType.TT_Utility, 150);
    }

}
