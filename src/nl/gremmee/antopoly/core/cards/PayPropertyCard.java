package nl.gremmee.antopoly.core.cards;

public class PayPropertyCard extends Card {

    private int perHouse;
    private int perHotel;

    public PayPropertyCard(String aName, String aText, int aPerHouse, int aPerHotel) {
        super(CardAction.CA_PayProperty, aName, aText);
        this.setPerHouse(aPerHouse);
        this.setPerHotel(aPerHotel);
    }

    public int getPerHouse() {
        return perHouse;
    }

    public void setPerHouse(int aPerHouse) {
        this.perHouse = aPerHouse;
    }

    public int getPerHotel() {
        return perHotel;
    }

    public void setPerHotel(int aPerHotel) {
        this.perHotel = aPerHotel;
    }

}
