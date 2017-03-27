package nl.gremmee.antopoly.core.tiles.streets;

import nl.gremmee.antopoly.core.Municipality;
import nl.gremmee.antopoly.core.tiles.Tile;

public class Street extends Tile {

    private Municipality municipality;
    private int value;
    private int building;

    public Street(String aName, Municipality aMunicipality, int aValue) {
        super(aName);
        this.setMunicipality(aMunicipality);
        this.setValue(aValue);
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

    public int getValue() {
        return value;
    }

    public void setValue(int aValue) {
        this.value = aValue;
    }
}
