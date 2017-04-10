package nl.gremmee.antopoly.core.cards.impl;

import nl.gremmee.antopoly.Money;
import nl.gremmee.antopoly.core.cards.abs.Card;
import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.players.IPlayer;

public class GotoCard extends Card {

    private ITile tile;
    private boolean forward;

    public GotoCard(String aName, String aText, ITile aTile, boolean aForward) {
        super(aName, aText);
        this.setTile(aTile);
        this.setForward(aForward);
    }

    public GotoCard(String aName, String aText, ITile aTile) {
        this(aName, aText, aTile, true);
    }

    public ITile getTile() {
        return tile;
    }

    public void setTile(ITile tile) {
        this.tile = tile;
    }

    @Override
    public boolean excute(IPlayer aPlayer) {
        ITile gotoTile = this.getTile();
        System.out.println("Goto Tile " + gotoTile.getName());

        int currentTileId = aPlayer.getCurrentTile().getID();
        aPlayer.setCurrentTile(gotoTile);
        int newTileID = gotoTile.getID();

        if (this.isForward()) {
            System.out.println(currentTileId + " -> " + newTileID);
        } else {
            System.out.println(currentTileId + " <- " + newTileID);
        }

        if ((this.forward) && (newTileID < currentTileId)) {
            System.out.println("Pass start get " + Money.PRICE_PASS_START);
            aPlayer.receiveMoney(Money.PRICE_PASS_START);
        }

        gotoTile.execute(aPlayer);
        return super.excute(aPlayer);
    }

    @Override
    protected boolean getKeepCard() {
        return false;
    }

    public boolean isForward() {
        return forward;
    }

    private void setForward(boolean aForward) {
        this.forward = aForward;
    }

}
