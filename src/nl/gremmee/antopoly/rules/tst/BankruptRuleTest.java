package nl.gremmee.antopoly.rules.tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.core.cards.impl.PayCard;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.impl.StationTile;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.impl.Player;
import nl.gremmee.antopoly.rules.IRule;

public class BankruptRuleTest {

    private Player player;
    private Player other;
    private IRule rule;
    private PayCard card;
    private StationTile tile;

    @Before
    public void setUp() throws Exception {
        Initialize.getInstance().initializeArtificialIntelligenceList();
        Initialize.getInstance().initializeRuleList();
        rule = Initialize.getInstance().getRuleList().getRuleByName("BankRupt");
        player = new Player(0, "TestPlayer");
        player.payMoney(1480);
    }

    @Test
    public void testGetName() {
        assertEquals("BankRupt", rule.getName());
    }

    @Test
    public void testExecuteToBank() throws CloneNotSupportedException {
        card = new PayCard("Pay", "Pay", 100);
        Player playerBefore = player.clone();
        System.out.println(playerBefore.getMoney());
        card.excute(player);
        assertEquals(0, player.getMoney());
    }

    @Test
    public void testExecuteToOtherPlayer() throws CloneNotSupportedException {
        other = new Player(1, "TestOther");
        tile = new StationTile(Tiles.B_O_RAILROAD);
        tile.setOwner(other);
        other.getTileList().add(tile);
        player.setCurrentTile(tile);
        Player playerBefore = player.clone();
        Player otherBefore = other.clone();
        System.out.println(playerBefore.getMoney());
        tile.execute(player);
        assertEquals(otherBefore.getMoney() + (playerBefore.getMoney() - player.getMoney()), other.getMoney());
        assertEquals(0, player.getMoney());
    }

}
