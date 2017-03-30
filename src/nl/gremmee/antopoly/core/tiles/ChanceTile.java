package nl.gremmee.antopoly.core.tiles;

import nl.gremmee.antopoly.Initialize;
import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.players.IPlayer;

public class ChanceTile extends Tile {

    public ChanceTile(int aID) {
        super(aID, "Chance", TileType.TT_Chance);
    }

    @Override
    public void execute(IPlayer aCurrent) {
        System.out.println(Initialize.getInstance().getChanceCardList());
        ICard card = Initialize.getInstance().getChanceCardList().pickTopCard();
        System.out.println("Chance " + card.getName());
        if (!card.excute(aCurrent)) {
            Initialize.getInstance().getChanceCardList().putBack(card);
        }

    }

}
