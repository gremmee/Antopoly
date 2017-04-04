package nl.gremmee.antopoly.core.tiles.impl;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.core.tiles.abs.Tile;
import nl.gremmee.antopoly.players.IPlayer;

public class FreeParkingTile extends Tile {

    int pot;

    public FreeParkingTile(int aID) {
        super(aID, "Vrij parkeren", TileType.TT_FreeParking);
        this.pot = 0;
    }

    public void addToPot(int aValue) {
        this.pot += aValue;
    }

    public int collectPot() {
        int value = pot;
        this.pot = 0;
        return value;
    }

    @Override
    public void execute(IPlayer aPlayer) {
        if (Settings.USE_FREE_PARKING_POT) {
            if (aPlayer.getCurrentTile().equals(this)) {
                aPlayer.setMoney(aPlayer.getMoney() + this.collectPot());
            }
        }
        super.execute(aPlayer);
    }

}
