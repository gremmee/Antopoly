package nl.gremmee.antopoly.core.tiles;

import nl.gremmee.antopoly.Initialize;
import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.players.Player;

public class ChanceTile extends Tile {

    public ChanceTile(int aID) {
        super(aID, "Chance", TileType.TT_Chance);
    }

    @Override
    public void execute(Player aCurrent) {
        System.out.println(Initialize.getInstance().getChanceCardList());
        ICard card = Initialize.getInstance().getChanceCardList().pickTopCard();
        System.out.println("Chance " + card.getName());
        card.excute(aCurrent);
        if (card.isGetOutOfJailCard()) {
            aCurrent.getCardList().add(card);
            System.out.println("Store Get Out Of Jail Chance");
        } else {
            Initialize.getInstance().getChanceCardList().putBack(card);
        }

    }

}
