package nl.gremmee.antopoly.core.cards.impl;

import nl.gremmee.antopoly.Initialize;
import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.players.IPlayer;

public class ChoiceCard extends PayCard {

    public ChoiceCard(String aName, String aText, int aValue) {
        super(aName, aText, aValue);
    }

    @Override
    public boolean excute(IPlayer aPlayer) {
        int value = this.getValue() * Settings.MONEY_FACTOR;

        if (aPlayer.getMoney() < value * 20) {
            ICard card = Initialize.getInstance().getChanceCardList().pickTopCard();
            if (!card.excute(aPlayer)) {
                Initialize.getInstance().getChanceCardList().putBack(card);
            }

        } else {
            aPlayer.setMoney(aPlayer.getMoney() - value);
        }
        Initialize.getInstance().initializeRules();
        return getKeepCard();
    }

    @Override
    protected boolean getKeepCard() {
        return false;
    }

}
