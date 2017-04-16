package nl.gremmee.antopoly.rules.impl;

import java.util.List;

import nl.gremmee.antopoly.core.cards.CardType;
import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.core.lists.CardList;
import nl.gremmee.antopoly.core.lists.TileList;
import nl.gremmee.antopoly.core.tiles.abs.PropertyTile;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.players.impl.Owe;
import nl.gremmee.antopoly.rules.abs.Rule;

public class BankruptRule extends Rule {

    public BankruptRule() {
        super("BankRupt");
    }

    @Override
    public void execute(final IPlayer aPlayer) {
        if (!isMe(aPlayer)) {
            Owe owe = aPlayer.getOwe();
            if (aPlayer.getMoney() < owe.getOwesMoney()) {
                System.out.println("Executing rule: " + this);

                // Bankrupt
                IPlayer owesTo = owe.getOwesTo();
                TileList tileList = aPlayer.getTileList();
                List<PropertyTile> propertyTiles = tileList.getPropertyTiles();
                CardList playerCardList = aPlayer.getCardList();
                if (owesTo != null) {
                    // Gets all money
                    owesTo.receiveMoney(aPlayer.getMoney());

                    // Gets all properties
                    for (PropertyTile propertyTile : propertyTiles) {
                        owesTo.addTile(propertyTile);
                    }
                    tileList.clear();

                    // Gets all cards
                    for (ICard card : playerCardList) {
                        owesTo.getCardList().add(card);
                    }
                    playerCardList.clear();
                } else {
                    for (PropertyTile propertyTile : propertyTiles) {
                        propertyTile.setOwner(null);
                    }
                    tileList.clear();

                    // Put back all cards
                    for (ICard card : playerCardList) {
                        CardType cardType = card.getCardType();
                        Initialize initialize = Initialize.getInstance();
                        CardList cardList = CardType.CT_Chance.equals(cardType)
                                ? initialize.getChanceCardList()
                                : initialize.getCommunityChestCardList();
                        cardList.putBack(card);
                    }
                    playerCardList.clear();

                }
                aPlayer.resetMoney();
                aPlayer.setBusted(true);
                owe.setOwesTo(null);
                owe.setOwesMoney(0);
            }
        }
    }

}
