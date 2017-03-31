package nl.gremmee.antopoly.core.tiles;

import nl.gremmee.antopoly.Initialize;
import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.players.IPlayer;

public class CommunityChestTile extends Tile {

    public CommunityChestTile(int aID, int aNumber) {
        super(aID, "Community Chest " + aNumber, TileType.TT_CommunityChest);
    }

    @Override
    public void execute(IPlayer aCurrent) {
        System.out.println(Initialize.getInstance().getCommunityChestCardList());
        ICard card = Initialize.getInstance().getCommunityChestCardList().pickTopCard();
        System.out.println("Community " + card.getName());
        if (!card.excute(aCurrent)) {
            Initialize.getInstance().getCommunityChestCardList().putBack(card);
        }

    }

}
