package nl.gremmee.antopoly.core.tiles;

import nl.gremmee.antopoly.core.Municipality;

public class StreetTile extends PropertyTile {

    private Municipality municipality;
    private int building;
    private int rent;
    private int house1, house2, house3, house4;
    private int hotel;

    public StreetTile(int aID, String aName, Municipality aMunicipality, int aValue, int aRent, int aHouse1,
            int aHouse2, int aHouse3, int aHouse4, int aHotel) {
        super(aID, aName, TileType.TT_Street, aValue);
        this.setMunicipality(aMunicipality);
        this.setRent(aRent);
        this.setHouse1(aHouse1);
        this.setHouse2(aHouse2);
        this.setHouse3(aHouse3);
        this.setHouse4(aHouse4);
        this.setHotel(aHotel);
        this.building = 0;
    }

    public int build(int aNumBuildings) {
        assert aNumBuildings + this.building < 5 : "Cannot build more than a hotel!";

        return 0;
    }

    public Municipality getMunicipality() {
        return this.municipality;
    }

    public void setMunicipality(Municipality aMunicipality) {
        this.municipality = aMunicipality;
    }

    public int getRent() {
        return this.rent;
    }

    public void setRent(int aRent) {
        this.rent = aRent;
    }

    public void buyHouse() {
        this.building++;
    }

    public void sellHouse() {
        this.building--;
    }

    @Override
    public String toString() {
        return this.getName() + ", " + this.building;
    }

    public int getHouse1() {
        return house1;
    }

    public void setHouse1(int aHouse1) {
        this.house1 = aHouse1;
    }

    public int getHouse2() {
        return house2;
    }

    public void setHouse2(int aHouse2) {
        this.house2 = aHouse2;
    }

    public int getHouse3() {
        return house3;
    }

    public void setHouse3(int aHouse3) {
        this.house3 = aHouse3;
    }

    public int getHouse4() {
        return house4;
    }

    public void setHouse4(int aHouse4) {
        this.house4 = aHouse4;
    }

    public int getHotel() {
        return hotel;
    }

    public void setHotel(int aHotel) {
        this.hotel = aHotel;
    }

    public int getBuildings() {
        return this.building;
    }

}
