package nl.gremmee.antopoly.rules.impl;

import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.rules.abs.Rule;

public class SellPropertiesRule extends Rule {

    public SellPropertiesRule() {
        super("Sell Properties");
    }

    @Override
    public void execute(IPlayer aPlayer) {
        if (!isMe(aPlayer)) {
            if (aPlayer.getMoney() < aPlayer.getOwe().getOwes()) {
                System.out.println("Executing rule: " + this);

                aPlayer.getArtificialIntelligence().executeSellProperties(aPlayer);

                IPlayer owesTo = aPlayer.getOwe().getOwesTo();
                if (owesTo != null) {
                    if (aPlayer.getMoney() > aPlayer.getOwe().getOwes()) {
                        owesTo.receiveMoney(aPlayer.getOwe().getOwes());
                        aPlayer.getOwe().setOwes(aPlayer.getMoney() - aPlayer.getOwe().getOwes());
                    } // else get mortgage
                } else {
                    aPlayer.payMoney(aPlayer.getOwe().getOwes());
                    aPlayer.getOwe().setOwesTo(null);
                    aPlayer.getOwe().setOwes(0);
                }
            }
        }
    }

}
