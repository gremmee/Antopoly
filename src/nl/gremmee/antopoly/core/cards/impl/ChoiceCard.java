package nl.gremmee.antopoly.core.cards.impl;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.core.lists.ChanceCardList;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.IPlayer;

public class ChoiceCard extends PayCard {

    public ChoiceCard(final String aName, final String aText, final int aValue) {
        super(aName, aText, aValue);
    }

    @Override
    public boolean execute(final IPlayer aPlayer) {

        int value = this.getValue() * Settings.MONEY_FACTOR;

        Initialize initialize = Initialize.getInstance();
        if (aPlayer.getArtificialIntelligence().executeChoiceCard(this, aPlayer)) {
            ChanceCardList chanceCardList = initialize.getChanceCardList();
            ICard card = chanceCardList.pickTopCard();
            if (!card.execute(aPlayer)) {
                chanceCardList.putBack(card);
            }

        } else {
            aPlayer.payMoney(value);
        }

        initialize.executeRules(aPlayer);
        return getKeepCard();
    }

    @Override
    protected boolean getKeepCard() {
        return false;
    }

}
