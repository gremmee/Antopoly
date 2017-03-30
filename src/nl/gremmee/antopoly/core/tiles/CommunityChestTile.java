package nl.gremmee.antopoly.core.tiles;

import nl.gremmee.antopoly.Initialize;
import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.players.Player;

public class CommunityChestTile extends Tile {

    public CommunityChestTile(int aID) {
        super(aID, "Community Chest", TileType.TT_CommunityChest);
    }

    @Override
    public void execute(Player aCurrent) {
        System.out.println(Initialize.getInstance().getCommunityChestCardList());
        ICard card = Initialize.getInstance().getCommunityChestCardList().pickTopCard();
        System.out.println("Community " + card.getName());
        card.excute(aCurrent);
        if (card.isGetOutOfJailCard()) {
            aCurrent.getCardList().add(card);
            System.out.println("Store Get Out Of Jail Community Chest");
        } else {
            Initialize.getInstance().getCommunityChestCardList().putBack(card);
        }

    }

}
