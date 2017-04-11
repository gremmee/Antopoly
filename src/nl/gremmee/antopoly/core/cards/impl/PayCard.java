package nl.gremmee.antopoly.core.cards.impl;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.cards.abs.ValueCard;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.impl.FreeParkingTile;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.IPlayer;

public class PayCard extends ValueCard {

    public PayCard(final String aName, final String aText, final int aValue) {
        super(aName, aText, aValue);
    }

    @Override
    public boolean execute(final IPlayer aPlayer) {
        int pay = this.getValue() * Settings.MONEY_FACTOR;
        System.out.println("Pay " + pay);
        if (pay > aPlayer.getMoney()) {
            aPlayer.getOwe().setOwesTo(null);
            aPlayer.getOwe().setOwes(pay);
        } else {
            aPlayer.payMoney(pay);
        }
        if (Initialize.getInstance().getSettings().isFreeParkingPot()) {
            FreeParkingTile tile = (FreeParkingTile) Initialize.getInstance().getTileList()
                    .getTileByName(Tiles.FREE_PARKING);
            tile.addToPot(pay);
        }

        return super.execute(aPlayer);
    }

    @Override
    protected boolean getKeepCard() {
        return false;
    }

}
