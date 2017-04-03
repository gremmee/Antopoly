package nl.gremmee.antopoly.core.cards.impl;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.cards.abs.ValueCard;
import nl.gremmee.antopoly.players.IPlayer;

public class PayCard extends ValueCard {

    public PayCard(String aName, String aText, int aValue) {
        super(aName, aText, aValue);
    }

    @Override
    public boolean excute(IPlayer aPlayer) {
        int pay = this.getValue() * Settings.MONEY_FACTOR;
        System.out.println("Pay " + pay);
        aPlayer.setMoney(aPlayer.getMoney() - pay);
        return super.excute(aPlayer);
    }

    @Override
    protected boolean getKeepCard() {
        return false;
    }

}
