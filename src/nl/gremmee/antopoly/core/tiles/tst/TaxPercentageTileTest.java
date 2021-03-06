package nl.gremmee.antopoly.core.tiles.tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.impl.TaxPercentageTile;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.impl.Player;

public class TaxPercentageTileTest {
    private TaxPercentageTile tile;
    private Player player;

    @Before
    public void setUp() throws Exception {
        Initialize.getInstance().initializeArtificialIntelligenceList();
        Initialize.getInstance().initializeRuleList();
        Initialize.getInstance().initializeTileList();
        player = new Player(0, "TestPlayer");
        tile = new TaxPercentageTile(Tiles.TAXES_PERCENTAGE, 10);
    }

    @Test
    public void testValue() {
        assertEquals(10, tile.getPercentage());
    }

    @Test
    public void testName() {
        assertEquals("Taxes Percentage", tile.getName());
    }

    @Test
    public void textExecute() {
        int money = player.getMoney();
        tile.execute(player);
        assertEquals(money - (money * tile.getPercentage()) / 100, player.getMoney());
    }
}