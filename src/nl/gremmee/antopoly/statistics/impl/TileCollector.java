package nl.gremmee.antopoly.statistics.impl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.statistics.abs.Collector;

public class TileCollector extends Collector {

    Map<String, CollectorPojo> coll;

    public TileCollector() {
        super("Tile Collector");
        coll = new HashMap<>();
    }

    @Override
    public void collect(final IPlayer aPlayer) {
        ITile tile = aPlayer.getCurrentTile();
        String name = tile.getName();
        String tileName = name;
        CollectorPojo value = this.coll.get(tileName);
        if (value != null) {
            value.increaseCount();
        } else {

            this.coll.put(tileName, new CollectorPojo());
        }
        increaseTotalCount();
    }

    public void increaseTotalCount() {
        for (CollectorPojo collPojo : this.coll.values()) {
            collPojo.increaseTotalCount();
        }
    }

    @Override
    public String toString() {
        Map<String, CollectorPojo> sorted = sortByValues(this.coll);
        return sorted.toString();
    }

    private static <Key, Value extends Comparable<Value>> Map<Key, Value> sortByValues(final Map<Key, Value> aMap) {
        Comparator<Key> valueComparator = new Comparator<Key>() {
            public int compare(Key aKey1, Key aKey2) {
                int compare = aMap.get(aKey2).compareTo(aMap.get(aKey1));
                if (compare == 0)
                    return 1;
                else
                    return compare;
            }
        };
        Map<Key, Value> sortedByValues = new TreeMap<Key, Value>(valueComparator);
        sortedByValues.putAll(aMap);
        return sortedByValues;
    }

}
