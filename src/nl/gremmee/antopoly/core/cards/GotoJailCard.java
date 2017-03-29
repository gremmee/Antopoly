package nl.gremmee.antopoly.core.cards;

import nl.gremmee.antopoly.core.tiles.ITile;

public class GotoJailCard extends GotoCard {

    public GotoJailCard(String aName, String aText, ITile aTile) {
        super(CardAction.CA_GotoJail, aName, aText, aTile);
    }

}
