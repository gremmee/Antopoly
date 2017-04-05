package nl.gremmee.antopoly.statistics;

import nl.gremmee.antopoly.statistics.impl.TileCollector;

public class InitializeStatistics {
    private static InitializeStatistics instance;
    private CollectorList collectorList;

    private InitializeStatistics() {
    }

    public static InitializeStatistics getInstance() {
        if (instance == null) {
            instance = new InitializeStatistics();
        }
        return instance;
    }

    public CollectorList initializeCollectors() {
        System.out.println("Initializing Collectors");
        collectorList = new CollectorList();
        ICollector collector = new TileCollector();
        collectorList.add(collector);
        System.out.println("Creating Collector " + collector.getName() + "...[OK]");

        return collectorList;
    }

    public CollectorList getCollectorList() {
        return this.collectorList;
    }
}
