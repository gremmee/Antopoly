package nl.gremmee.antopoly.core.cards.impl;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.IPlayer;

public class ChoiceCard extends PayCard {

    public ChoiceCard(String aName, String aText, int aValue) {
        super(aName, aText, aValue);
    }

    @Override
    public boolean excute(IPlayer aPlayer) {

        int value = this.getValue() * Settings.MONEY_FACTOR;

        if (aPlayer.getArtificialIntelligence().executeChoiceCard(this, aPlayer)) {
            ICard card = Initialize.getInstance().getChanceCardList().pickTopCard();
            if (!card.excute(aPlayer)) {
                Initialize.getInstance().getChanceCardList().putBack(card);
            }

        } else {
            aPlayer.payMoney(value);
        }

        Initialize.getInstance().executeRules(aPlayer);
        return getKeepCard();
    }

    @Override
    protected boolean getKeepCard() {
        return false;
    }

}
