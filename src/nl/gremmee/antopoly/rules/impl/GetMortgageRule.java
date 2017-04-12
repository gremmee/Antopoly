package nl.gremmee.antopoly.rules.impl;

import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.rules.abs.Rule;

public class GetMortgageRule extends Rule {

    public GetMortgageRule() {
        super("GetMortgage");
    }

    @Override
    public void execute(IPlayer aPlayer) {
        if (!isMe(aPlayer)) {
            if (aPlayer.getMoney() < aPlayer.getOwe().getOwesMoney()) {
                System.out.println("Executing rule: " + this);

                aPlayer.getArtificialIntelligence().executeGetMortgage(aPlayer);

                IPlayer owesTo = aPlayer.getOwe().getOwesTo();
                if (owesTo != null) {
                    if (aPlayer.getMoney() > aPlayer.getOwe().getOwesMoney()) {
                        owesTo.receiveMoney(aPlayer.getOwe().getOwesMoney());
                        aPlayer.getOwe().setOwesMoney(aPlayer.getMoney() - aPlayer.getOwe().getOwesMoney());
                    } // else bankrupt
                } else {
                    aPlayer.payMoney(aPlayer.getOwe().getOwesMoney());
                    aPlayer.getOwe().setOwesTo(null);
                    aPlayer.getOwe().setOwesMoney(0);
                }
            }
        }
    }

}
