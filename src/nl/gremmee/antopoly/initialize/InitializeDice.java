package nl.gremmee.antopoly.initialize;

import nl.gremmee.antopoly.core.Die;
import nl.gremmee.antopoly.core.lists.DiceList;

public class InitializeDice {
    private static InitializeDice instance;
    private DiceList diceList;

    private InitializeDice() {
    }

    public static InitializeDice getInstance() {
        if (instance == null) {
            instance = new InitializeDice();
        }
        return instance;
    }

    public DiceList initializeDice(final int aNumDice) {
        System.out.println("Initializing Dice");
        this.diceList = new DiceList();
        for (int i = 0; i < aNumDice; i++) {
            System.out.print("Creating Die " + (i + 1) + "...");
            Die die = new Die(6);
            this.diceList.add(die);
            System.out.println("[OK]");
        }
        return this.diceList;
    }

}
