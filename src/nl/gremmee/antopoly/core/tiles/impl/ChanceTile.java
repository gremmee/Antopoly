package nl.gremmee.antopoly.core.tiles.impl;

import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.core.lists.ChanceCardList;
import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.abs.Tile;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.IPlayer;

public class ChanceTile extends Tile {

    public ChanceTile(final Tiles aTiles) {
        super(aTiles, TileType.TT_Chance);
    }

    @Override
    public void execute(final IPlayer aPlayer) {
        ChanceCardList chanceCardList = Initialize.getInstance().getChanceCardList();
        System.out.println(chanceCardList);
        ICard card = chanceCardList.pickTopCard();
        System.out.println("Chance " + card.getName());
        if (!card.execute(aPlayer)) {
            chanceCardList.putBack(card);
        }
        super.execute(aPlayer);
    }

}
