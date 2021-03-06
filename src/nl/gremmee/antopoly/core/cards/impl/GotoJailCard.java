package nl.gremmee.antopoly.core.cards.impl;

import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.IPlayer;

public class GotoJailCard extends GotoTileCard {

    public GotoJailCard() {
        super("Goto Jail", "Ga direct naar de gevangenis. Ga niet langs \"Start\". U ontvangt geen � 20",
                Initialize.getInstance().getTileList().getTileByName(Tiles.JAIL));
    }

    @Override
    public boolean execute(final IPlayer aPlayer) {
        ITile goDirectTile = this.getTile();
        System.out.println("Goto Jail");
        aPlayer.setCurrentTile(goDirectTile);
        aPlayer.setInJail(true);
        goDirectTile.execute(aPlayer);
        return super.execute(aPlayer);
    }

    @Override
    protected boolean getKeepCard() {
        return false;
    }

}
