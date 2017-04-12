package nl.gremmee.antopoly.core.lists;

import java.util.ArrayList;
import java.util.List;

import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.abs.PropertyTile;
import nl.gremmee.antopoly.core.tiles.impl.StationTile;
import nl.gremmee.antopoly.core.tiles.impl.StreetTile;
import nl.gremmee.antopoly.core.tiles.impl.UtilityTile;

public class TileList extends ArrayList<ITile> {

    private static final long serialVersionUID = -8238183105633419715L;

    @Override
    public boolean add(final ITile aTile) {
        System.out.println("Creating Tile " + aTile.getName() + "...[OK]");
        return super.add(aTile);
    }

    public ITile getTileByName(final Tiles aTiles) {
        for (ITile tile : this) {
            if (tile.getName().equals(aTiles.getName()))
                return tile;
        }
        return null;
    }

    public ITile getTileByID(final int aId) {
        for (ITile tile : this) {
            if (tile.getID() == aId)
                return tile;
        }
        return null;
    }

    public List<PropertyTile> getPropertyTiles() {
        List<PropertyTile> propertyTiles = new ArrayList<PropertyTile>();
        for (ITile tile : this) {
            if (tile instanceof PropertyTile) {
                PropertyTile propertyTile = (PropertyTile) tile;
                propertyTiles.add(propertyTile);
            }
        }
        return propertyTiles;
    }

    public List<StationTile> getStationTiles() {
        List<StationTile> stationTiles = new ArrayList<StationTile>();
        for (ITile tile : this) {
            if (tile instanceof StationTile) {
                StationTile stationTile = (StationTile) tile;
                stationTiles.add(stationTile);
            }
        }
        return stationTiles;
    }

    public List<StreetTile> getStreetTiles() {
        List<StreetTile> streetTiles = new ArrayList<StreetTile>();
        for (ITile tile : this) {
            if (tile instanceof StreetTile) {
                StreetTile streetTile = (StreetTile) tile;
                streetTiles.add(streetTile);
            }
        }
        return streetTiles;
    }

    public List<UtilityTile> getUtilityTiles() {
        List<UtilityTile> utilityTiles = new ArrayList<UtilityTile>();
        for (ITile tile : this) {
            if (tile instanceof UtilityTile) {
                UtilityTile utilityTile = (UtilityTile) tile;
                utilityTiles.add(utilityTile);
            }
        }
        return utilityTiles;
    }
}