package nl.gremmee.antopoly.core.cards.impl;

import nl.gremmee.antopoly.Money;
import nl.gremmee.antopoly.core.cards.abs.GotoCard;
import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.IPlayer;

public class GotoStepsCard extends GotoCard {

    private int numSteps;

    public GotoStepsCard(String aName, String aText, int aNumSteps, boolean aForward) {
        super(aName, aText, aForward);
        this.setNumSteps(aNumSteps);
    }

    @Override
    public boolean excute(IPlayer aPlayer) {
        int currentTileId = aPlayer.getCurrentTile().getID();
        int calculatedResult = 0;
        if (this.isForward()) {
            calculatedResult = currentTileId + this.numSteps;
        } else {
            calculatedResult = currentTileId - this.numSteps;

        }

        if (isForward() && (calculatedResult >= Initialize.getInstance().getTileList().size())) {
            // pass Start
            System.out.println("Pass start");
            aPlayer.receiveMoney(Money.PRICE_PASS_START);
        }
        int newID = calculatedResult % Initialize.getInstance().getTileList().size();

        if (this.isForward()) {
            System.out.println(currentTileId + " -> " + newID);
        } else {
            System.out.println(newID + " <- " + currentTileId);
        }
        System.out.println(Initialize.getInstance().getTileList());
        ITile gotoTile = Initialize.getInstance().getTileList().getTileByID(newID);
        System.out.println("Goto : " + gotoTile);
        aPlayer.setCurrentTile(gotoTile);

        gotoTile.execute(aPlayer);
        return super.excute(aPlayer);
    }

    @Override
    protected boolean getKeepCard() {
        return false;
    }

    public int getNumSteps() {
        return numSteps;
    }

    private void setNumSteps(int aNumSteps) {
        this.numSteps = aNumSteps;
    }

}
