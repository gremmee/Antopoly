package nl.gremmee.antopoly.core.cards.impl;

import nl.gremmee.antopoly.core.cards.abs.Card;
import nl.gremmee.antopoly.players.IPlayer;

public class GetOutOfJailCard extends Card {

    public GetOutOfJailCard(final String aName, final String aText) {
        super(aName, aText);
    }

    @Override
    public boolean execute(final IPlayer aPlayer) {
        aPlayer.getCardList().add(this);
        System.out.println("Store Get Out Of Jail " + this.getCardType());
        return super.execute(aPlayer);
    }

    @Override
    protected boolean getKeepCard() {
        return true;
    }

}
