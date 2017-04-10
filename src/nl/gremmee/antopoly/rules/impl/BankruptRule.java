package nl.gremmee.antopoly.rules.impl;

import nl.gremmee.antopoly.core.cards.CardType;
import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.core.lists.CardList;
import nl.gremmee.antopoly.core.tiles.ITile;
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
        if (aPlayer.getMoney() < aPlayer.getOwesMoney()) {
            System.out.println("Executing rule: " + this);

            // Try to sell

            // Try to mortgage

            // Bankrupt
            IPlayer owes = aPlayer.getOwes();
            if (owes != null) {
                // Gets all money
                owes.receiveMoney(aPlayer.getMoney());

                // Gets all properties
                for (ITile tile : aPlayer.getTileList()) {
                    if (tile instanceof PropertyTile) {
                        PropertyTile propertyTile = (PropertyTile) tile;
                        owes.getTileList().add(propertyTile);
                        propertyTile.setOwner(owes);
                    }
                }
                aPlayer.getTileList().clear();

                // Gets all cards
                for (ICard card : aPlayer.getCardList()) {
                    owes.getCardList().add(card);
                }
                aPlayer.getCardList().clear();
            } else {
                for (ITile tile : aPlayer.getTileList()) {
                    if (tile instanceof PropertyTile) {
                        PropertyTile propertyTile = (PropertyTile) tile;
                        propertyTile.setOwner(null);
                    }
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
            aPlayer.setOwes(null);
            aPlayer.setOwesMoney(0);
        }

    }

}
