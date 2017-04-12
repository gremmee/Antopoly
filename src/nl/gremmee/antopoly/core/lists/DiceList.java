package nl.gremmee.antopoly.core.lists;

import java.util.ArrayList;

import nl.gremmee.antopoly.core.Die;

public class DiceList extends ArrayList<Die> {
    private static final long serialVersionUID = 1866660346615706168L;

    private RollList rollList;

    public DiceList() {
        this.rollList = new RollList();
    }

    @Override
    public boolean add(final Die aDie) {
        System.out.println("Creating Die " + (this.size() + 1) + "...[OK]");
        return super.add(aDie);
    }

    public RollList getRollList() {
        return this.rollList;
    }

    public RollList roll() {
        this.rollList.clear();
        System.out.print("Rolling ");
        for (int i = 0; i < this.size(); i++) {
            Long roll = this.get(i).roll();
            this.rollList.add(roll);
            System.out.print(roll.intValue() + " ");
        }
        System.out.println();
        return this.rollList;
    }
}
