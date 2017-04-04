package nl.gremmee.antopoly.core.cards.impl;

import nl.gremmee.antopoly.Initialize;
import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.cards.abs.ValueCard;
import nl.gremmee.antopoly.core.tiles.impl.FreeParkingTile;
import nl.gremmee.antopoly.players.IPlayer;

public class PayCard extends ValueCard {

    public PayCard(String aName, String aText, int aValue) {
        super(aName, aText, aValue);
    }

    @Override
    public boolean excute(IPlayer aPlayer) {
        int pay = this.getValue() * Settings.MONEY_FACTOR;
        System.out.println("Pay " + pay);
        aPlayer.payMoney(pay);
        if (Initialize.getInstance().getSettings().isFreeParkingPot()) {
            FreeParkingTile tile = (FreeParkingTile) Initialize.getInstance().getTileList()
                    .getTileByName("Vrij parkeren");
            tile.addToPot(pay);
        }

        return super.excute(aPlayer);
    }

    @Override
    protected boolean getKeepCard() {
        return false;
    }

}
