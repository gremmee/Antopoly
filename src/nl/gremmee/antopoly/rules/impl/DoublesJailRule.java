package nl.gremmee.antopoly.rules.impl;

import nl.gremmee.antopoly.Initialize;
import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.rules.abs.Rule;

public class DoublesJailRule extends Rule {

    public DoublesJailRule() {
        super("Doubles Jail");
    }

    @Override
    public void execute(IPlayer aPlayer) {
        if (!aPlayer.isInJail()) {
            if (aPlayer.getRollList() == null) {
                aPlayer.roll();
                aPlayer.setAgain(aPlayer.getRollList().isDouble());
                if (aPlayer.getRollList().getDoubles() >= 3) {
                    System.out.println("JAIL TIME");
                    aPlayer.setInJail(true);
                    aPlayer.setCurrentTile(Initialize.getInstance().getTileList().getTileByName("Jail"));
                }
            }
        }

    }
}
