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

public class RepayMortgageRuleTest {

    private Player player;
    private Player other;
    private IRule rule;
    private PayCard card;
    private StationTile tile;

    @Before
    public void setUp() throws Exception {
        Initialize.getInstance().initializeArtificialIntelligenceList();
        Initialize.getInstance().initializeRuleList();
        rule = Initialize.getInstance().getRuleList().getRuleByName("Repay Mortgage");
        player = new Player(0, "TestPlayer");
        player.payMoney(1480);
        tile = new StationTile(Tiles.B_O_RAILROAD);
        player.addTile(tile);
        tile.setMortgage(true);
    }

    @Test
    public void testGetName() {
        assertEquals("Repay Mortgage", rule.getName());
    }

    @Test
    public void testExecuteCannotRepay() throws CloneNotSupportedException {
        Player playerBefore = player.clone();
        player.getArtificialIntelligence().executeRepayMortgage(player);
        assertEquals(playerBefore.getMoney(), player.getMoney());
        assertEquals(true, tile.isMortgage());

    }

    @Test
    public void testExecuteCanRepay() throws CloneNotSupportedException {
        player.receiveMoney(300);
        Player playerBefore = player.clone();
        player.getArtificialIntelligence().executeRepayMortgage(player);
        assertEquals(playerBefore.getMoney() - (tile.getValue() / 2), player.getMoney());
        assertEquals(false, tile.isMortgage());

    }

}
