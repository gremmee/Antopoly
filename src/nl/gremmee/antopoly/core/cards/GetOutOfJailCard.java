package nl.gremmee.antopoly.core.cards;

import nl.gremmee.antopoly.players.IPlayer;

public class GetOutOfJailCard extends Card {

    public GetOutOfJailCard(String aName, String aText) {
        super(CardAction.CA_GetOutOfJail, aName, aText);
    }

    @Override
    public boolean excute(IPlayer aPlayer) {
        aPlayer.getCardList().add(this);
        System.out.println("Store Get Out Of Jail " + this.getCardType());
        return super.excute(aPlayer);
    }

    @Override
    protected boolean getKeepCard() {
        return true;
    }

}
