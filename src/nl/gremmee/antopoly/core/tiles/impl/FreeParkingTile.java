package nl.gremmee.antopoly.core.tiles.impl;

import nl.gremmee.antopoly.Initialize;
import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.core.tiles.abs.Tile;
import nl.gremmee.antopoly.players.IPlayer;

public class FreeParkingTile extends Tile {

    private int pot;

    public FreeParkingTile(int aID) {
        super(aID, "Vrij parkeren", TileType.TT_FreeParking);
        this.pot = 0;
    }

    public void addToPot(int aValue) {
        this.pot += aValue;
    }

    private int collectPot() {
        int value = pot;
        this.pot = 0;
        return value;
    }

    @Override
    public void execute(IPlayer aPlayer) {
        if (Initialize.getInstance().getSettings().isFreeParkingPot()) {
            if (aPlayer.getCurrentTile().equals(this)) {
                aPlayer.receiveMoney(this.collectPot());
            }
        }
        super.execute(aPlayer);
    }

    @Override
    public String toString() {
        return "| " + this.getName() + ", " + this.pot + " |";
    }

}
