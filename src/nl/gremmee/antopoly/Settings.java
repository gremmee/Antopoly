package nl.gremmee.antopoly;

import java.math.BigDecimal;

public class Settings {

    public static final int NUM_DICE = 2;
    public static final int NUM_PLAYERS = 5;

    public static final BigDecimal SELL_HOUSE_FACTOR = new BigDecimal("0.5");
    public static final BigDecimal MORTAGE_FACTOR = new BigDecimal("0.5");
    public static final BigDecimal MORTGAGE_INTEREST = new BigDecimal("0.1");

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
