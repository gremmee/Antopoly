package nl.gremmee.antopoly.rules.impl;

import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.rules.abs.Rule;

public class RepayMortgageRule extends Rule {

    public RepayMortgageRule() {
        super("Repay Mortgage");
    }

    @Override
    public void execute(final IPlayer aPlayer) {
        if (aPlayer.hasMortgages()) {
            System.out.println("Executing rule: " + this);

            aPlayer.getArtificialIntelligence().executeRepayMortgage(aPlayer);
        }
    }

}
