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

public class GetMortgageRuleTest {

    private Player player;
    private Player other;
    private IRule rule;
    private PayCard card;
    private StationTile tile;

    @Before
    public void setUp() throws Exception {
        Initialize.getInstance().initializeArtificialIntelligenceList();
        Initialize.getInstance().initializeRuleList();
        rule = Initialize.getInstance().getRuleList().getRuleByName("Get Mortgage");
        player = new Player(0, "TestPlayer");
        player.payMoney(1480);
    }

    @Test
    public void testGetName() {
        assertEquals("Get Mortgage", rule.getName());
    }

    @Test
    public void testExecuteToBank() throws CloneNotSupportedException {
        StreetTile medAveTile = new StreetTile(Tiles.MEDITERRANEAN_AVENUE, Municipality.BROWN, 10, 20, 30, 40, 50, 60,
                80);
        player.addTile(medAveTile);
        card = new PayCard("Pay", "Pay", 100);
        player.getOwe().setOwesMoney(200);
        Player playerBefore = player.clone();
        player.getArtificialIntelligence().executeGetMortgage(player);
        assertEquals(playerBefore.getMoney() + (medAveTile.getValue() / 2), player.getMoney());
        card.execute(player);
        assertEquals(0, player.getMoney());
    }

    @Test
    public void testExecuteToOtherPlayer() throws CloneNotSupportedException {
        StreetTile medAveTile = new StreetTile(Tiles.MEDITERRANEAN_AVENUE, Municipality.BROWN, 100, 20, 30, 40, 50, 60,
                80);
        player.addTile(medAveTile);
        other = new Player(1, "TestOther");
        tile = new StationTile(Tiles.B_O_RAILROAD);
        other.addTile(tile);
        player.getOwe().setOwesTo(other);
        player.getOwe().setOwesMoney(200);
        player.setCurrentTile(tile);
        Player playerBefore = player.clone();
        Player otherBefore = other.clone();
        player.getArtificialIntelligence().executeGetMortgage(player);
        other.receiveMoney(player.getMoney());
        assertEquals(playerBefore.getMoney() + (medAveTile.getValue() / 2), player.getMoney());
        assertEquals(otherBefore.getMoney() + player.getMoney(), other.getMoney());

    }

}