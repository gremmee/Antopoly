package nl.gremmee.antopoly.core.tiles.abs;

import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.players.IPlayer;

public abstract class PropertyTile extends Tile {

    private int value;
    private IPlayer owner;

    public PropertyTile(int aID, String aName, TileType aTileType, int aValue) {
        super(aID, aName, aTileType);
        this.setValue(aValue);
        this.setOwner(null);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int aValue) {
        this.value = aValue;
    }

    public IPlayer getOwner() {
        return owner;
    }

    public void setOwner(IPlayer aOwner) {
        this.owner = aOwner;
    }

    protected void buyProperty(IPlayer aPlayer) {
        aPlayer.getArtificialIntelligence().executeBuyTile(this, aPlayer);
    }

}
