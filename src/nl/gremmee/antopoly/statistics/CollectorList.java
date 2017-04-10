package nl.gremmee.antopoly.statistics;

import java.util.ArrayList;

public class CollectorList extends ArrayList<ICollector> {

    private static final long serialVersionUID = 8638978140693596281L;

    public ICollector getCollectorTileByName(final String aName) {
        for (ICollector collector : this) {
            if (collector.getName().equals(aName))
                return collector;
        }
        return null;
    }

    public ICollector getTileCollector() {
        ICollector collector = this.getCollectorTileByName("Tile Collector");
        return collector;

    }
}
