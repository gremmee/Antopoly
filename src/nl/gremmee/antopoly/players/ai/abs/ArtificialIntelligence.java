package nl.gremmee.antopoly.players.ai.abs;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.tiles.impl.StreetTile;
import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.players.ai.IArtificialIntelligence;

public abstract class ArtificialIntelligence implements IArtificialIntelligence {

    private String name;

    public ArtificialIntelligence(String aName) {
        this.setName(aName);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String aName) {
        this.name = aName;
    }

    protected void buyHouse(IPlayer aPlayer, StreetTile aStreet) {
        if (aStreet.getBuildings() < 5) {
            aStreet.buyHouse();
            aPlayer.payMoney(aStreet.getMunicipality().getHousePrice() * Settings.MONEY_FACTOR);
        }
    }

}
