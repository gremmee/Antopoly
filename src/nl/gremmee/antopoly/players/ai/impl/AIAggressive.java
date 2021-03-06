package nl.gremmee.antopoly.players.ai.impl;

import java.math.BigDecimal;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.cards.impl.ChoiceCard;
import nl.gremmee.antopoly.core.lists.MunicipalityList;
import nl.gremmee.antopoly.core.lists.TileList;
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
    public void executeRepayMortgage(final IPlayer aPlayer) {
        PropertyTile property = getNextMortgage(aPlayer);
        if (property != null) {
            if (aPlayer.getMoney() > (property.getValue() / 2)) {
                aPlayer.payMoney(property.getValue() / 2);
                property.setMortgage(false);
            }
        }
    }

    private PropertyTile getNextMortgage(final IPlayer aPlayer) {
        for (PropertyTile propertyTile : aPlayer.getTileList().getPropertyTiles()) {
            if (propertyTile.isMortgage()) {
                return propertyTile;
            }

        }
        return null;
    }

    @Override
    public void executeSellProperties(IPlayer aPlayer) {
        int owes = aPlayer.getOwe().getOwesMoney();
        for (StreetTile streetTile : aPlayer.getTileList().getStreetTiles()) {
            if (owes < aPlayer.getMoney()) {
                return;
            }
            if (streetTile.getBuildings() > 0) {
                do {
                    if (owes < aPlayer.getMoney()) {
                        return;
                    }
                    int houseValue = (streetTile.getMunicipality().getHousePrice() / 2);
                    System.out.println("Selling a house on " + streetTile + " for " + houseValue);
                    aPlayer.receiveMoney(houseValue);
                    streetTile.sellHouse();
                } while (streetTile.getBuildings() > 0);
            }
        }
    }

    @Override
    public void executeGetMortgage(final IPlayer aPlayer) {

        int owes = aPlayer.getOwe().getOwesMoney();
        for (PropertyTile propertyTile : aPlayer.getTileList().getPropertyTiles()) {
            if (owes < aPlayer.getMoney()) {
                return;
            }
            if (!propertyTile.isMortgage()) {
                int mortgageValue = BigDecimal.valueOf((long) propertyTile.getValue()).multiply(Settings.MORTAGE_FACTOR)
                        .intValue();
                System.out.println("Mortgage " + propertyTile + " for " + mortgageValue);
                aPlayer.receiveMoney(mortgageValue);
                propertyTile.setMortgage(true);
            }
        }
    }

    @Override
    public void executeBuyTile(final PropertyTile aTile, final IPlayer aPlayer) {
        System.out.println("Buy Property " + aTile);
        int value = aTile.getValue() * Settings.MONEY_FACTOR;
        if (aPlayer.getMoney() > value) {
            aPlayer.addTile(aTile);
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
        for (PropertyTile propertyTile : tileList.getPropertyTiles()) {
            if (propertyTile.getOwner() == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void executeBuyHouses(final IPlayer aPlayer) {
        for (StreetTile street : aPlayer.getTileList().getStreetTiles()) {
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

    @Override
    public void executeProposeTrade(IPlayer aAcceptPlayer, IPlayer aProposedPlayer) {

    }

    @Override
    public boolean executeEvaluteTrade(IPlayer aAcceptPlayer, IPlayer aProposedPlayer) {
        return false;
    }
}
