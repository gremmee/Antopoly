package nl.gremmee.antopoly.rules.tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.core.Municipality;
import nl.gremmee.antopoly.core.cards.impl.PayCard;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.impl.StationTile;
import nl.gremmee.antopoly.core.tiles.impl.StreetTile;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.impl.Player;
import nl.gremmee.antopoly.rules.IRule;

public class SellPropertiesRuleTest {

    private Player player;
    private Player other;
    private IRule rule;
    private PayCard card;
    private StationTile tile;
    private StreetTile medAveTile;

    @Before
    public void setUp() throws Exception {
        Initialize.getInstance().initializeArtificialIntelligenceList();
        Initialize.getInstance().initializeRuleList();
        rule = Initialize.getInstance().getRuleList().getRuleByName("Sell Properties");
        player = new Player(0, "TestPlayer");
        medAveTile = new StreetTile(Tiles.MEDITERRANEAN_AVENUE, Municipality.BROWN, 10, 20, 30, 40, 50, 60, 80);
        player.addTile(medAveTile);
        medAveTile.buyHouse();
        medAveTile.buyHouse();
        player.payMoney(1480);
    }

    @Test
    public void testGetName() {
        assertEquals("Sell Properties", rule.getName());
    }

    @Test
    public void testExecuteToBank() throws CloneNotSupportedException {
        card = new PayCard("Pay", "Pay", 100);
        player.getOwe().setOwesMoney(200);
        Player playerBefore = player.clone();
        player.getArtificialIntelligence().executeSellProperties(player);
        assertEquals(playerBefore.getMoney() + ((Municipality.BROWN.getHousePrice() / 2) * 2), player.getMoney());
        card.execute(player);
        assertEquals(0, player.getMoney());
    }

    @Test
    public void testExecuteToOtherPlayer() throws CloneNotSupportedException {
        other = new Player(1, "TestOther");
        tile = new StationTile(Tiles.B_O_RAILROAD);
        other.addTile(tile);
        player.getOwe().setOwesMoney(20);
        player.getOwe().setOwesTo(other);
        player.setCurrentTile(tile);
        Player playerBefore = player.clone();
        Player otherBefore = other.clone();
        player.getArtificialIntelligence().executeSellProperties(player);
        assertEquals(playerBefore.getMoney() + (Municipality.BROWN.getHousePrice() / 2), player.getMoney());
        tile.execute(player);
        assertEquals(otherBefore.getMoney() + (Municipality.BROWN.getHousePrice() / 2), other.getMoney());
    }

    @Test
    public void testExecuteMultipleProperties() throws CloneNotSupportedException {
        StreetTile balAveTile = new StreetTile(Tiles.BALTIC_AVENUE, Municipality.BROWN, 20, 20, 30, 40, 50, 60, 80);
        player.addTile(balAveTile);
        balAveTile.buyHouse();
        other = new Player(1, "TestOther");
        tile = new StationTile(Tiles.B_O_RAILROAD);
        other.addTile(tile);
        player.getOwe().setOwesMoney(140);
        player.getOwe().setOwesTo(other);
        player.setCurrentTile(tile);
        Player playerBefore = player.clone();
        player.getArtificialIntelligence().executeSellProperties(player);
        assertEquals(playerBefore.getMoney() + ((Municipality.BROWN.getHousePrice() / 2) * 3), player.getMoney());
    }

}
