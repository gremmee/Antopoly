package nl.gremmee.antopoly.core.tiles;

public class Tile implements ITile {

    private String name;

    public Tile(String aName) {
        this.setName(aName);
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        this.name = aName;
    }

}
