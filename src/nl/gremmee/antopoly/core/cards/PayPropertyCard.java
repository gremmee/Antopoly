package nl.gremmee.antopoly.core.cards;

import nl.gremmee.antopoly.players.IPlayer;

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

    @Override
    public boolean excute(IPlayer aPlayer) {
        int houses = aPlayer.getHouses();
        int hotels = aPlayer.getHotels();

        int houseCosts = this.getPerHouse() * houses;
        int hotelCosts = this.getPerHotel() * hotels;

        int totalCosts = houseCosts + hotelCosts;
        System.out.println("Pay " + totalCosts);
        aPlayer.setMoney(aPlayer.getMoney() - totalCosts);
        return super.excute(aPlayer);
    }

    @Override
    protected boolean getKeepCard() {
        return false;
    }

}
