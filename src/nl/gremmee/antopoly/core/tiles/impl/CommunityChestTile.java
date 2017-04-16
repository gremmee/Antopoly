package nl.gremmee.antopoly.core.tiles.impl;

import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.core.lists.CommunityChestCardList;
import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.abs.Tile;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.IPlayer;

public class CommunityChestTile extends Tile {

    public CommunityChestTile(final Tiles aTiles) {
        super(aTiles, TileType.TT_CommunityChest);
    }

    @Override
    public void execute(final IPlayer aPlayer) {
        CommunityChestCardList communityChestCardList = Initialize.getInstance().getCommunityChestCardList();
        System.out.println(communityChestCardList);
        ICard card = communityChestCardList.pickTopCard();
        System.out.println("Community " + card.getName());
        if (!card.execute(aPlayer)) {
            communityChestCardList.putBack(card);
        }
        super.execute(aPlayer);
    }

}
