package nl.gremmee.antopoly.core.tiles.impl;

import java.util.Collections;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.Municipality;
import nl.gremmee.antopoly.core.lists.MunicipalityList;
import nl.gremmee.antopoly.core.lists.TileList;
import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.core.tiles.TileType;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.abs.PropertyTile;
import nl.gremmee.antopoly.players.IPlayer;

public class StreetTile extends PropertyTile {

    private Municipality municipality;
    private int building;
    private int rent;
    private int house1, house2, house3, house4;
    private int hotel;

    public StreetTile(final Tiles aTiles, final Municipality aMunicipality, final int aValue, final int aRent,
            final int aHouse1, final int aHouse2, final int aHouse3, final int aHouse4, final int aHotel) {
        super(aTiles, TileType.TT_Street, aValue);
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
    public void execute(final IPlayer aPlayer) {
        System.out.println("Street");
        IPlayer owner = this.getOwner();
        if (owner == null) {
            buyProperty(aPlayer);
        } else {
            payRent(aPlayer, owner);
        }
        super.execute(aPlayer);
    }

    public int build(final int aNumBuildings) {
        assert aNumBuildings + this.building < 5 : "Cannot build more than a hotel!";

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
        this.building++;
    }

    public void sellHouse() {
        this.building--;
    }

    @Override
    public String toString() {
        return "| " + this.getName() + ", " + this.building + " |";
    }

    public int getHouse1() {
        return house1;
    }

    private void setHouse1(final int aHouse1) {
        this.house1 = aHouse1;
    }

    public int getHouse2() {
        return house2;
    }

    private void setHouse2(final int aHouse2) {
        this.house2 = aHouse2;
    }

    public int getHouse3() {
        return house3;
    }

    private void setHouse3(final int aHouse3) {
        this.house3 = aHouse3;
    }

    public int getHouse4() {
        return house4;
    }

    private void setHouse4(final int aHouse4) {
        this.house4 = aHouse4;
    }

    public int getHotel() {
        return hotel;
    }

    private void setHotel(final int aHotel) {
        this.hotel = aHotel;
    }

    public int getBuildings() {
        return this.building;
    }

    private void payRent(final IPlayer aPlayer, final IPlayer aOwner) {
        if (!this.isMortgage()) {
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
            if (rentValue > aPlayer.getMoney()) {
                aPlayer.setOwes(aOwner);
                aPlayer.setOwesMoney(rentValue);
            } else {
                aPlayer.payMoney(rentValue);
                aOwner.receiveMoney(rentValue);
            }
        } else {
            System.out.println(this + " is mortaged");
        }
    }

    public boolean hasMunicipality(final IPlayer aOwner, final StreetTile aStreet) {
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

    public MunicipalityList getMunicipality(final TileList aTileList, final StreetTile aStreet) {
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
