package nl.gremmee.antopoly;

import nl.gremmee.antopoly.core.DiceList;

public class Antopoly {
    private static final int NUM_DICE = 2;
    private static DiceList diceList;

    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();
        System.out.println("Starting application " + Antopoly.class.getSimpleName() + "...");
        System.out.println("Initializing...");
        initialize();
        System.out.println("Running...");
        // game();
        System.out.println("Stopping application " + Antopoly.class.getSimpleName() + "...");
        long endTime = System.currentTimeMillis() - beginTime;
        System.out.println("Time (in ms): " + endTime);

    }

    public static void initialize() {
        Initialize.getInstance();
        int max = NUM_DICE;
        diceList = Initialize.getInstance().initializeDice(NUM_DICE);
    }

}
