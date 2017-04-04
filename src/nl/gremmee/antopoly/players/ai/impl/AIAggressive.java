package nl.gremmee.antopoly.players.ai.impl;

import nl.gremmee.antopoly.Initialize;
import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.cards.impl.ChoiceCard;
import nl.gremmee.antopoly.core.lists.TileList;
import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.core.tiles.abs.PropertyTile;
import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.players.ai.abs.ArtificialIntelligence;

public class AIAggressive extends ArtificialIntelligence {

    public AIAggressive() {
        super("AIAggressive");
    }

    @Override
    public String toString() {
        return "| " + this.getName() + "|";
    }

    @Override
    public void executeRepayMortage() {
    }

    @Override
    public void executeGetMortage() {
    }

    @Override
    public void executeBuyTile(PropertyTile aTile, IPlayer aPlayer) {
        System.out.println("Buy Property " + aTile);
        int value = aTile.getValue() * Settings.MONEY_FACTOR;
        if (aPlayer.getMoney() > value) {
            aPlayer.getTileList().add(aTile);
            aTile.setOwner(aPlayer);
            System.out.println("tileValue " + value);
            aPlayer.payMoney(value);
        } else {
            System.out.println("Not enough money!");
        }

    }

    @Override
    public boolean executeChoiceCard(ChoiceCard aChoiceCard, IPlayer aPlayer) {
        return (aPlayer.getMoney() < aChoiceCard.getValue() * 20);
    }

    @Override
    public boolean executeGetOutOfJail() {
        TileList tileList = Initialize.getInstance().getTileList();
        for (ITile tile : tileList) {
            if (tile instanceof PropertyTile) {
                PropertyTile propertyTile = (PropertyTile) tile;
                if (propertyTile.getOwner() == null) {
                    return true;
                }
            }
        }
        return false;
    }
}
