package nl.gremmee.antopoly.core.tiles;

import nl.gremmee.antopoly.core.Municipality;

public class Street extends Property {

    private Municipality municipality;
    private int building;
    private int rent;

    public Street(int aID, String aName, Municipality aMunicipality, int aValue, int aRent) {
        super(aID, aName, TileType.TT_Street, aValue);
        this.setMunicipality(aMunicipality);
        this.setRent(aRent);
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
}
