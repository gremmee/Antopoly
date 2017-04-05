package nl.gremmee.antopoly.core.tiles.impl;

import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.abs.Tile;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.IPlayer;

public class CommunityChestTile extends Tile {

    public CommunityChestTile(Tiles aTiles) {
        super(aTiles, TileType.TT_CommunityChest);
    }

    @Override
    public void execute(IPlayer aPlayer) {
        System.out.println(Initialize.getInstance().getCommunityChestCardList());
        ICard card = Initialize.getInstance().getCommunityChestCardList().pickTopCard();
        System.out.println("Community " + card.getName());
        if (!card.excute(aPlayer)) {
            Initialize.getInstance().getCommunityChestCardList().putBack(card);
        }
        super.execute(aPlayer);
    }

}
