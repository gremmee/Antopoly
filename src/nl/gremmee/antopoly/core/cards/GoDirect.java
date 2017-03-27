package nl.gremmee.antopoly.core.cards;

import nl.gremmee.antopoly.core.tiles.ITile;

public class GoDirect extends GotoCard {

    public GoDirect(CardType aCardType, String aName, String aText, ITile aTile) {
        super(aCardType, CardAction.CA_GoDirect, aName, aText, aTile);
    }

}
