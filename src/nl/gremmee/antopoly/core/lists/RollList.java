package nl.gremmee.antopoly.core.lists;

import java.util.ArrayList;

public class RollList extends ArrayList<Long> {

    int doubles = 0;

    private static final long serialVersionUID = -1283759404224639418L;

    public int getResult() {
        Long result = new Long(0);
        for (Long roll : this) {
            result += roll;
        }
        return result.intValue();
    }

    public boolean isDouble() {
        Long initRoll = new Long(0);
        for (Long roll : this) {
            if (roll.intValue() == initRoll.intValue()) {
                System.out.println("Double!!!");
                return true;
            }
            initRoll = roll;
        }
        return false;
    }

    public int increaseDoubles() {
        return ++this.doubles;
    }

    public int resetDoubles() {
        this.doubles = 0;
        return this.doubles;
    }

    public int getDoubles() {
        return this.doubles;
    }
}
