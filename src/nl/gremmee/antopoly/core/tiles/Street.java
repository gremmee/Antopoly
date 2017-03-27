package nl.gremmee.antopoly.core.tiles;

import nl.gremmee.antopoly.core.Municipality;

public class Street extends Property {

    private Municipality municipality;
    private int building;

    public Street(int aID, String aName, Municipality aMunicipality, int aValue) {
        super(aID, aName, TileType.TT_Street, aValue);
        this.setMunicipality(aMunicipality);
        this.building = 0;
    }

    public int build(int aNumBuildings) {
        assert aNumBuildings + this.building < 5 : "Cannot build more than a hotel!";

        return 0;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality aMunicipality) {
        this.municipality = aMunicipality;
    }
}
