package nl.gremmee.antopoly.core.tiles.impl;

import java.util.Collections;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.Municipality;
import nl.gremmee.antopoly.core.lists.MunicipalityList;
import nl.gremmee.antopoly.core.lists.TileList;
import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.core.tiles.abs.PropertyTile;
import nl.gremmee.antopoly.players.IPlayer;

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

    @Override
    public void execute(IPlayer aCurrent) {
        System.out.println("Street");
        IPlayer owner = this.getOwner();
        if (owner == null) {
            buyProperty(aCurrent);
        } else {
            payRent(aCurrent, owner);
        }
        super.execute(aCurrent);
    }

    public int build(int aNumBuildings) {
        assert aNumBuildings + this.building < 5 : "Cannot build more than a hotel!";

        return 0;
    }

    public Municipality getMunicipality() {
        return this.municipality;
    }

    private void setMunicipality(Municipality aMunicipality) {
        this.municipality = aMunicipality;
    }

    public int getRent() {
        return this.rent;
    }

    private void setRent(int aRent) {
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

    private void setHouse1(int aHouse1) {
        this.house1 = aHouse1;
    }

    public int getHouse2() {
        return house2;
    }

    private void setHouse2(int aHouse2) {
        this.house2 = aHouse2;
    }

    public int getHouse3() {
        return house3;
    }

    private void setHouse3(int aHouse3) {
        this.house3 = aHouse3;
    }

    public int getHouse4() {
        return house4;
    }

    private void setHouse4(int aHouse4) {
        this.house4 = aHouse4;
    }

    public int getHotel() {
        return hotel;
    }

    private void setHotel(int aHotel) {
        this.hotel = aHotel;
    }

    public int getBuildings() {
        return this.building;
    }

    private void payRent(IPlayer aCurrent, IPlayer aOwner) {
        System.out.println("PayRent to " + aOwner.getName());
        int rentValue = 0;
        if (this.getBuildings() == 0) {
            int factor = hasMunicipality(aOwner, this) ? 2 : 1;
            rentValue = this.getRent() * factor;
        } else {
            switch (this.getBuildings()) {
                case 1:
                    rentValue = this.getHouse1();
                    break;
                case 2:
                    rentValue = this.getHouse2();
                    break;
                case 3:
                    rentValue = this.getHouse3();
                    break;
                case 4:
                    rentValue = this.getHouse4();
                    break;
                case 5:
                    rentValue = this.getHotel();
                    break;

                default:
                    rentValue = this.getHotel();
                    break;
            }
        }
        rentValue *= Settings.MONEY_FACTOR;
        aOwner.setMoney(aOwner.getMoney() + rentValue);
        aCurrent.setMoney(aCurrent.getMoney() - rentValue);
    }

    public boolean hasMunicipality(IPlayer aOwner, StreetTile aStreet) {
        int complete = aStreet.getMunicipality().getSize();
        for (ITile tile : aOwner.getTileList()) {
            if (tile instanceof StreetTile) {
                StreetTile streetTile = (StreetTile) tile;
                if (streetTile.getMunicipality().equals(aStreet.getMunicipality())) {
                    complete--;
                }
            }
        }
        return (complete == 0);
    }

    public MunicipalityList getMunicipality(TileList aTileList, StreetTile aStreet) {
        MunicipalityList municipalityList = new MunicipalityList();
        for (ITile tile : aTileList) {
            if (tile instanceof StreetTile) {
                StreetTile street = (StreetTile) tile;

                if (street.getMunicipality().equals(aStreet.getMunicipality())) {

                    municipalityList.add(street);

                }
            }
        }
        Collections.sort(municipalityList);
        return municipalityList;
    }

}
