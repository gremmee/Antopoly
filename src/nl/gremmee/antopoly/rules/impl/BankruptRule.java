package nl.gremmee.antopoly.rules.impl;

import nl.gremmee.antopoly.core.cards.CardType;
import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.core.lists.CardList;
import nl.gremmee.antopoly.core.tiles.abs.PropertyTile;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.rules.abs.Rule;

public class BankruptRule extends Rule {

    public BankruptRule() {
        super("BankRupt");
    }

    @Override
    public void execute(final IPlayer aPlayer) {
        if (aPlayer.getMoney() < aPlayer.getOwe().getOwes()) {
            System.out.println("Executing rule: " + this);

            // Try to sell

            // Try to mortgage

            // Bankrupt
            IPlayer owes = aPlayer.getOwe().getOwesTo();
            if (owes != null) {
                // Gets all money
                owes.receiveMoney(aPlayer.getMoney());

                // Gets all properties
                for (PropertyTile propertyTile : aPlayer.getTileList().getPropertyTiles()) {
                    owes.addTile(propertyTile);
                }
                aPlayer.getTileList().clear();

                // Gets all cards
                for (ICard card : aPlayer.getCardList()) {
                    owes.getCardList().add(card);
                }
                aPlayer.getCardList().clear();
            } else {
                for (PropertyTile propertyTile : aPlayer.getTileList().getPropertyTiles()) {
                    propertyTile.setOwner(null);
                }
                aPlayer.getTileList().clear();

                // Put back all cards
                for (ICard card : aPlayer.getCardList()) {
                    CardType cardType = card.getCardType();
                    CardList cardList = CardType.CT_Chance.equals(cardType)
                            ? Initialize.getInstance().getChanceCardList()
                            : Initialize.getInstance().getCommunityChestCardList();
                    cardList.putBack(card);
                }
                aPlayer.getCardList().clear();

            }
            aPlayer.resetMoney();
            aPlayer.setBusted(true);
            aPlayer.getOwe().setOwesTo(null);
            aPlayer.getOwe().setOwes(0);
        }

    }

}
