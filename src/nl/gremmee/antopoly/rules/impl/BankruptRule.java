package nl.gremmee.antopoly.rules.impl;

import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.core.tiles.abs.PropertyTile;
import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.rules.abs.Rule;

public class BankruptRule extends Rule {

    public BankruptRule() {
        super("BankRupt");
    }

    @Override
    public void execute(IPlayer aPlayer) {
        if (aPlayer.getMoney() < 0) {
            System.out.println("Executing rule: " + this);
            aPlayer.setBusted(true);
            aPlayer.resetMoney();
            for (ITile tile : aPlayer.getTileList()) {
                if (tile instanceof PropertyTile) {
                    PropertyTile propertyTile = (PropertyTile) tile;
                    propertyTile.setOwner(null);
                }
            }
        }

    }

}
