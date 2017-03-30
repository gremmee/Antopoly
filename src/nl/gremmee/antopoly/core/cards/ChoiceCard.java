package nl.gremmee.antopoly.core.cards;

import nl.gremmee.antopoly.Initialize;
import nl.gremmee.antopoly.players.IPlayer;

public class ChoiceCard extends PayCard {

    public ChoiceCard(String aName, String aText, int aValue) {
        super(CardAction.CA_Choice, aName, aText, aValue);
    }

    @Override
    public boolean excute(IPlayer aPlayer) {
        int value = this.getValue();

        if (aPlayer.getMoney() < value * 1000) {
            ICard card = Initialize.getInstance().getChanceCardList().pickTopCard();
            if (!card.excute(aPlayer)) {
                Initialize.getInstance().getChanceCardList().putBack(card);
            }

        } else {
            aPlayer.setMoney(aPlayer.getMoney() - value);
        }
        return super.excute(aPlayer);
    }

    @Override
    protected boolean getKeepCard() {
        return false;
    }

}
