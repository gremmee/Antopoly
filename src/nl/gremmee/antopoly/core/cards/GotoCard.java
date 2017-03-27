package nl.gremmee.antopoly.core.cards;

import nl.gremmee.antopoly.core.tiles.ITile;

public class GotoCard extends Card {

    private ITile tile;

    public GotoCard(CardType aCardType, String aName, String aText, ITile aTile) {
        this(aCardType, CardAction.CA_Goto, aName, aText, aTile);
    }

    public GotoCard(CardType aCardType, CardAction aCardAction, String aName, String aText, ITile aTile) {
        super(aCardType, aCardAction, aName, aText);
        this.setTile(aTile);
    }

    public ITile getTile() {
        return tile;
    }

    public void setTile(ITile tile) {
        this.tile = tile;
    }

}
