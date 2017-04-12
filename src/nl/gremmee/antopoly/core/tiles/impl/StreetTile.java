package nl.gremmee.antopoly.core.tiles.impl;

import java.util.Collections;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.Municipality;
import nl.gremmee.antopoly.core.lists.MunicipalityList;
import nl.gremmee.antopoly.core.lists.TileList;
import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.abs.PropertyTile;
import nl.gremmee.antopoly.players.IPlayer;

public class StreetTile extends PropertyTile {

    private Municipality municipality;
    private int buildings;
    private int rent;
    private int rentHouse1, rentHouse2, rentHouse3, rentHouse4;
    private int rentHotel;

    public StreetTile(final Tiles aTiles, final Municipality aMunicipality, final int aValue, final int aRent,
            final int aRentHouse1, final int aRentHouse2, final int aRentHouse3, final int aRentHouse4,
            final int aRentHotel) {
        super(aTiles, TileType.TT_Street, aValue);
        this.setMunicipality(aMunicipality);
        this.setRent(aRent);
        this.setRentHouse1(aRentHouse1);
        this.setRentHouse2(aRentHouse2);
        this.setRentHouse3(aRentHouse3);
        this.setRentHouse4(aRentHouse4);
        this.setRentHotel(aRentHotel);
        this.buildings = 0;
    }

    @Override
    public void execute(final IPlayer aPlayer) {
        System.out.println("Landing on Street");
        super.execute(aPlayer);
    }

    public int build(final int aNumBuildings) {
        assert aNumBuildings + this.buildings < 5 : "Cannot build more than a rentHotel!";

        return 0;
    }

    public Municipality getMunicipality() {
        return this.municipality;
    }

    private void setMunicipality(final Municipality aMunicipality) {
        this.municipality = aMunicipality;
    }

    public int getRent() {
        return this.rent;
    }

    private void setRent(final int aRent) {
        this.rent = aRent;
    }

    public void buyHouse() {
        assert (this.getOwner() != null) : "Cannot buy a house when not owned!";
        assert (!this.isMortgage()) : "Cannot buy a house when mortgaged!";
        this.buildings++;
    }

    public void buyHotel() {
        int diff = 5 - this.buildings;
        for (int i = 0; i < diff; i++) {
            buyHouse();
        }
    }

    public void sellHouse() {
        this.buildings--;
    }

    @Override
    public String toString() {
        return "| " + this.getName() + ", " + this.getMunicipality().getAbbreviation() + ", " + this.buildings + " |";
    }

    public int getRentHouse1() {
        return this.rentHouse1;
    }

    private void setRentHouse1(final int aHouse1) {
        this.rentHouse1 = aHouse1;
    }

    public int getRentHouse2() {
        return this.rentHouse2;
    }

    private void setRentHouse2(final int aHouse2) {
        this.rentHouse2 = aHouse2;
    }

    public int getRentHouse3() {
        return this.rentHouse3;
    }

    private void setRentHouse3(final int aHouse3) {
        this.rentHouse3 = aHouse3;
    }

    public int getRentHouse4() {
        return this.rentHouse4;
    }

    private void setRentHouse4(final int aHouse4) {
        this.rentHouse4 = aHouse4;
    }

    public int getRentHotel() {
        return this.rentHotel;
    }

    private void setRentHotel(final int aHotel) {
        this.rentHotel = aHotel;
    }

    public int getBuildings() {
        return this.buildings;
    }

    @Override
    protected void payRent(final IPlayer aPlayer, final IPlayer aOwner) {
        if (!this.isMortgage()) {
            System.out.println("PayRent to " + aOwner.getName());
            int rentValue = 0;
            if (this.getBuildings() == 0) {
                int factor = hasMunicipality(aOwner, this) ? 2 : 1;
                rentValue = this.getRent() * factor;
            } else {
                switch (this.getBuildings()) {
                    case 1:
                        rentValue = this.getRentHouse1();
                        break;
                    case 2:
                        rentValue = this.getRentHouse2();
                        break;
                    case 3:
                        rentValue = this.getRentHouse3();
                        break;
                    case 4:
                        rentValue = this.getRentHouse4();
                        break;
                    case 5:
                        rentValue = this.getRentHotel();
                        break;

                    default:
                        rentValue = this.getRentHotel();
                        break;
                }
            }
            rentValue *= Settings.MONEY_FACTOR;
            if (rentValue > aPlayer.getMoney()) {
                aPlayer.getOwe().setOwesTo(aOwner);
                aPlayer.getOwe().setOwesMoney(rentValue);
            } else {
                aPlayer.payMoney(rentValue);
                aOwner.receiveMoney(rentValue);
                aPlayer.getOwe().resetOwe();
            }
        } else {
            System.out.println(this + " is mortgaged");
        }
    }

    public boolean hasMunicipality(final IPlayer aOwner, final StreetTile aStreet) {
        int complete = aStreet.getMunicipality().getSize();
        for (StreetTile street : aOwner.getTileList().getStreetTiles()) {
            if (street.getMunicipality().equals(aStreet.getMunicipality())) {
                complete--;
            }
        }
        return (complete == 0);
    }

    public MunicipalityList getMunicipality(final TileList aTileList, final StreetTile aStreet) {
        MunicipalityList municipalityList = new MunicipalityList();
        for (StreetTile street : aTileList.getStreetTiles()) {

            if (street.getMunicipality().equals(aStreet.getMunicipality())) {

                municipalityList.add(street);

            }
        }
        Collections.sort(municipalityList);
        return municipalityList;
    }

}
