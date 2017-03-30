package nl.gremmee.antopoly.core.cards;

import nl.gremmee.antopoly.players.IPlayer;

public class RecieveCard extends ValueCard {

    public RecieveCard(String aName, String aText, int aValue) {
        super(CardAction.CA_Recieve, aName, aText, aValue);
    }

    @Override
    public boolean excute(IPlayer aPlayer) {
        int receive = this.getValue();
        System.out.println("Recieve " + receive);
        aPlayer.setMoney(aPlayer.getMoney() + receive);
        return super.excute(aPlayer);
    }

    @Override
    protected boolean getKeepCard() {
        return false;
    }

}
