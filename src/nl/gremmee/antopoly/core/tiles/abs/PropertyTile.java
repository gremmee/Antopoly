package nl.gremmee.antopoly.core.tiles.abs;

import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.players.IPlayer;

public abstract class PropertyTile extends Tile {

    private int value;
    private IPlayer owner;

    public PropertyTile(final Tiles aTiles, final TileType aTileType, final int aValue) {
        super(aTiles, aTileType);
        this.setValue(aValue);
        this.setOwner(null);
    }

    public int getValue() {
        return value;
    }

    public void setValue(final int aValue) {
        this.value = aValue;
    }

    public IPlayer getOwner() {
        return owner;
    }

    public void setOwner(final IPlayer aOwner) {
        this.owner = aOwner;
    }

    protected void buyProperty(final IPlayer aPlayer) {
        aPlayer.getArtificialIntelligence().executeBuyTile(this, aPlayer);
    }

}
