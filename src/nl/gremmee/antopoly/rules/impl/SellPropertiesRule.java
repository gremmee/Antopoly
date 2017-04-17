package nl.gremmee.antopoly.rules.impl;

import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.players.impl.Owe;
import nl.gremmee.antopoly.rules.abs.Rule;

public class SellPropertiesRule extends Rule {

    public SellPropertiesRule() {
        super("Sell Properties");
    }

    @Override
    public void execute(IPlayer aPlayer) {
        if (!isMe(aPlayer)) {
            Owe owe = aPlayer.getOwe();
            int owesMoney = owe.getOwesMoney();
            int playerMoney = aPlayer.getMoney();
            if (playerMoney < owesMoney) {
                System.out.println("Executing rule: " + this);

                aPlayer.getArtificialIntelligence().executeSellProperties(aPlayer);

                IPlayer owesTo = owe.getOwesTo();
                if (owesTo != null) {
                    if (playerMoney > owesMoney) {
                        owesTo.receiveMoney(owesMoney);
                        owe.setOwesMoney(playerMoney - owesMoney);
                    } // else get mortgage
                } else {
                    aPlayer.payMoney(owesMoney);
                    owe.setOwesTo(null);
                    owe.setOwesMoney(0);
                }
            }
        }
    }

}
