package nl.gremmee.antopoly;

public class Settings {

    public static final int NUM_DICE = 2;
    public static final int NUM_PLAYERS = 8;

    public static final int MONEY_FACTOR = 1;

    private boolean freeParkingPot = false;
    private boolean taxesPercentage = false;

    // TODO implement
    public static final boolean USE_SHORT_PLAY = false;

    public boolean isFreeParkingPot() {
        return freeParkingPot;
    }

    public void setFreeParkingPot(final boolean aFreeParkingPot) {
        freeParkingPot = aFreeParkingPot;
    }

    public boolean isTaxesPercentage() {
        return taxesPercentage;
    }

    public void setTaxesPercentagefinal(final boolean aTaxesPercentage) {
        taxesPercentage = aTaxesPercentage;
    }

}
