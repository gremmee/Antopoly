package nl.gremmee.antopoly;

import nl.gremmee.antopoly.material.DiceList;
import nl.gremmee.antopoly.material.Die;

/**
 * Initialize
 */
public class Initialize {
    private static final long SLEEP = 250;
    private static Initialize instance;
    private DiceList diceList;

    private Initialize() {
    }

    public static Initialize getInstance() {
        if (instance == null) {
            instance = new Initialize();
        }
        return instance;
    }

    public DiceList initializeDice(int aNumDice) {
        System.out.println("Initializing Dice");
        diceList = new DiceList();
        for (int i = 0; i < aNumDice; i++) {
            System.out.print("Creating Die " + (i + 1) + "...");
            Die die = new Die(6);
            diceList.add(die);
            System.out.println("[OK]");
            repaint("Creating Die " + (i + 1) + "...");
        }
        return diceList;
    }

    private void repaint(String aMessage) {
        sleep();
    }

    private void sleep() {
        try {
            Thread.sleep(SLEEP);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
