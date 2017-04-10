package nl.gremmee.antopoly.rules.impl;

import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.rules.abs.Rule;

public class GetMortgageRule extends Rule {

    public GetMortgageRule() {
        super("GetMortgage");
    }

    @Override
    public void execute(IPlayer aPlayer) {
        if (aPlayer.getMoney() < aPlayer.getOwesMoney()) {
            System.out.println("Executing rule: " + this);

            aPlayer.getArtificialIntelligence().executeGetMortgage(aPlayer);

            IPlayer owes = aPlayer.getOwes();
            if (owes != null) {
                if (aPlayer.getMoney() < aPlayer.getOwesMoney()) {
                    owes.receiveMoney(aPlayer.getMoney());
                    aPlayer.resetMoney();
                    aPlayer.setOwesMoney(aPlayer.getOwesMoney() - aPlayer.getMoney());
                }
            } else {
                owes.receiveMoney(aPlayer.getOwesMoney());
                aPlayer.payMoney(aPlayer.getOwesMoney());
                aPlayer.setOwes(null);
                aPlayer.setOwesMoney(0);
            }
        }
    }

}
