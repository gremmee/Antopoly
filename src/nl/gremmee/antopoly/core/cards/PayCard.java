package nl.gremmee.antopoly.core.cards;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.players.IPlayer;

public class PayCard extends ValueCard {

    public PayCard(String aName, String aText, int aValue) {
        this(CardAction.CA_Pay, aName, aText, aValue);
    }

    public PayCard(CardAction aCardAction, String aName, String aText, int aValue) {
        super(aCardAction, aName, aText, aValue);
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
