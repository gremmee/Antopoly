package nl.gremmee.antopoly.core.cards.impl;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.cards.abs.ValueCard;
import nl.gremmee.antopoly.players.IPlayer;

public class ReceiveCard extends ValueCard {

    public ReceiveCard(final String aName, final String aText, final int aValue) {
        super(aName, aText, aValue);
    }

    @Override
    public boolean excute(final IPlayer aPlayer) {
        int receive = this.getValue() * Settings.MONEY_FACTOR;
        System.out.println("Receive " + receive);
        aPlayer.receiveMoney(receive);
        return super.excute(aPlayer);
    }

    @Override
    protected boolean getKeepCard() {
        return false;
    }

}
