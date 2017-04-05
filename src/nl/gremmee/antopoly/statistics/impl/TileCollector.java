package nl.gremmee.antopoly.statistics.impl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.statistics.abs.Collector;

public class TileCollector extends Collector {

    Map<String, Integer> coll;

    public TileCollector() {
        super("Tile Collector");
        coll = new HashMap<>();
    }

    @Override
    public void collect(IPlayer aPlayer) {
        ITile tile = aPlayer.getCurrentTile();
        Integer value = coll.get(tile.getName());
        if (value != null) {
            value = Integer.valueOf(value.intValue() + 1);
            coll.remove(tile.getName());
            coll.put(tile.getName(), value);
        } else {

            coll.put(tile.getName(), Integer.valueOf(1));
        }

    }

    @Override
    public String toString() {
        Map<String, Integer> sorted = sortByValues(coll);
        return sorted.toString();
    }

    private static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> aMap) {
        Comparator<K> valueComparator = new Comparator<K>() {
            public int compare(K aKey1, K aKey2) {
                int compare = aMap.get(aKey2).compareTo(aMap.get(aKey1));
                if (compare == 0)
                    return 1;
                else
                    return compare;
            }
        };
        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(aMap);
        return sortedByValues;
    }

}