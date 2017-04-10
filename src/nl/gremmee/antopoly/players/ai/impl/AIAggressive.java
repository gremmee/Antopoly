package nl.gremmee.antopoly.players.ai.impl;

import java.math.BigDecimal;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.cards.impl.ChoiceCard;
import nl.gremmee.antopoly.core.lists.MunicipalityList;
import nl.gremmee.antopoly.core.lists.TileList;
import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.core.tiles.abs.PropertyTile;
import nl.gremmee.antopoly.core.tiles.impl.StreetTile;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.players.ai.abs.ArtificialIntelligence;

public class AIAggressive extends ArtificialIntelligence {

    public AIAggressive() {
        super("AIAggressive");
    }

    @Override
    public String toString() {
        return "| " + this.getName() + "|";
    }

    @Override
    public void executeRepayMortgage() {
    }

    @Override
    public void executeGetMortgage(final IPlayer aPlayer) {

        int owes = aPlayer.getOwesMoney();
        for (ITile tile : aPlayer.getTileList()) {
            if (owes < aPlayer.getMoney()) {
                return;
            }
            if (tile instanceof PropertyTile) {
                PropertyTile propertyTile = (PropertyTile) tile;
                if (!propertyTile.isMortgage()) {
                    int mortgageValue = BigDecimal.valueOf((long) propertyTile.getValue())
                            .multiply(Settings.MORTAGE_FACTOR).intValue();
                    aPlayer.receiveMoney(mortgageValue);
                    propertyTile.setMortgage(true);
                }
            }
        }
    }

    @Override
    public void executeBuyTile(final PropertyTile aTile, final IPlayer aPlayer) {
        System.out.println("Buy Property " + aTile);
        int value = aTile.getValue() * Settings.MONEY_FACTOR;
        if (aPlayer.getMoney() > value) {
            aPlayer.getTileList().add(aTile);
            aTile.setOwner(aPlayer);
            System.out.println("tileValue " + value);
            aPlayer.payMoney(value);
        } else {
            System.out.println("Not enough money!");
        }

    }

    @Override
    public boolean executeChoiceCard(final ChoiceCard aChoiceCard, final IPlayer aPlayer) {
        return (aPlayer.getMoney() < aChoiceCard.getValue() * 20);
    }

    @Override
    public boolean executeGetOutOfJail() {
        TileList tileList = Initialize.getInstance().getTileList();
        for (ITile tile : tileList) {
            if (tile instanceof PropertyTile) {
                PropertyTile propertyTile = (PropertyTile) tile;
                if (propertyTile.getOwner() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void executeBuyHouses(final IPlayer aPlayer) {
        for (ITile tile : aPlayer.getTileList()) {
            if (tile instanceof StreetTile) {
                StreetTile street = (StreetTile) tile;
                if (street.hasMunicipality(aPlayer, street)) {
                    MunicipalityList municipalityList = street.getMunicipality(aPlayer.getTileList(), street);
                    for (StreetTile municipalityTile : municipalityList) {
                        int housePrice = municipalityTile.getMunicipality().getHousePrice();
                        if (aPlayer.getMoney() > housePrice) {
                            buyHouse(aPlayer, municipalityTile);
                        }
                    }
                }
            }
        }
    }
}
