package nl.gremmee.antopoly.core.tiles.impl;

import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.abs.Tile;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.IPlayer;

public class ChanceTile extends Tile {

    public ChanceTile(Tiles aTiles) {
        super(aTiles, TileType.TT_Chance);
    }

    @Override
    public void execute(IPlayer aPlayer) {
        System.out.println(Initialize.getInstance().getChanceCardList());
        ICard card = Initialize.getInstance().getChanceCardList().pickTopCard();
        System.out.println("Chance " + card.getName());
        if (!card.excute(aPlayer)) {
            Initialize.getInstance().getChanceCardList().putBack(card);
        }
        super.execute(aPlayer);
    }

}
