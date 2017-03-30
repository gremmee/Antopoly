package nl.gremmee.antopoly.core.cards;

import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.players.IPlayer;

public class GotoCard extends Card {

    private ITile tile;

    public GotoCard(String aName, String aText, ITile aTile) {
        this(CardAction.CA_Goto, aName, aText, aTile);
    }

    public GotoCard(CardAction aCardAction, String aName, String aText, ITile aTile) {
        super(aCardAction, aName, aText);
        this.setTile(aTile);
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

        System.out.println(currentTileId + " -> " + newTileID);

        if (newTileID < currentTileId) {
            System.out.println("Pass start get 200");
            aPlayer.setMoney(aPlayer.getMoney() + 200);
        }

        gotoTile.execute(aPlayer);
        return super.excute(aPlayer);
    }

    @Override
    protected boolean getKeepCard() {
        return false;
    }

}
