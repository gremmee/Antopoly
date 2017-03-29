package nl.gremmee.antopoly.core.cards;

import nl.gremmee.antopoly.core.tiles.ITile;

public class GoDirect extends GotoCard {

    public GoDirect(String aName, String aText, ITile aTile) {
        super(CardAction.CA_GoDirect, aName, aText, aTile);
    }

}
