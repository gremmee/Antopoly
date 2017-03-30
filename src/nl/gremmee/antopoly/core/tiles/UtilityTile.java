package nl.gremmee.antopoly.core.tiles;

import nl.gremmee.antopoly.players.Player;

public class UtilityTile extends PropertyTile {

    public static final int FACTOR_OWN_SINGLE = 4;
    public static final int FACTOR_OWN_DOUBLE = 10;

    public UtilityTile(int aID, String aName) {
        super(aID, aName, TileType.TT_Utility, 150);
    }

    @Override
    public void execute(Player aCurrent) {
        System.out.println("Utility");
        Player owner = this.getOwner();
        if (owner == null) {
            buyProperty(aCurrent);
        } else {
            payRent(aCurrent, owner);
        }

    }

    private void payRent(Player aCurrent, Player aOwner) {
        System.out.println("PayRent to " + aOwner.getName());
        int factor = hasBothUtilities(aOwner) ? UtilityTile.FACTOR_OWN_DOUBLE : UtilityTile.FACTOR_OWN_SINGLE;
        int diceResult = aCurrent.getRollList().getResult();
        int costs = diceResult * factor;
        aOwner.setMoney(aOwner.getMoney() + costs);
        aCurrent.setMoney(aCurrent.getMoney() - costs);
    }

    public boolean hasBothUtilities(Player aOwner) {
        int utilities = 0;
        for (ITile tile : aOwner.getTileList()) {
            if (tile instanceof UtilityTile) {
                utilities++;
            }
        }
        return (utilities >= 2);
    }
}
