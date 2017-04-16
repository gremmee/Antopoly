package nl.gremmee.antopoly.rules.impl;

import nl.gremmee.antopoly.core.lists.RollList;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.rules.abs.Rule;

public class DoublesJailRule extends Rule {

    public DoublesJailRule() {
        super("Doubles Jail");
    }

    @Override
    public void execute(final IPlayer aPlayer) {
        if (!aPlayer.isInJail()) {
            RollList rollList = aPlayer.getRollList();
            if (rollList == null) {
                System.out.println("Executing rule: " + this);
                aPlayer.roll();
                aPlayer.setAgain(rollList.isDouble());
                if (rollList.getDoubles() >= 3) {
                    System.out.println("JAIL TIME");
                    aPlayer.setInJail(true);
                    aPlayer.setAgain(false);
                    aPlayer.setCurrentTile(Initialize.getInstance().getTileList().getTileByName(Tiles.JAIL));
                }
            }
        }

    }
}
