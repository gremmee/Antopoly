package nl.gremmee.antopoly.core.tiles.tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.core.tiles.impl.ChanceTile;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.impl.Player;

public class ChanceTileTest {

    private ChanceTile tile;
    private Player player;

    @Before
    public void setUp() throws Exception {
        Initialize.getInstance().initializeArtificialIntelligenceList();
        Initialize.getInstance().initializeRules();
        Initialize.getInstance().initializeTileList();
        Initialize.getInstance().initializeChanceCards();
        player = new Player(0, "TestPlayer");
        player.setCurrentTile(Initialize.getInstance().getTileList().getTileByName("Start"));
        tile = new ChanceTile(0, 1);
    }

    @Test
    public void testName() {
        assertEquals("Chance 1", tile.getName());
    }

    @Test
    public void testExecute() throws CloneNotSupportedException {
        Player playerBefore = player.clone();
        tile.execute(player);
        assertEquals(playerBefore, player);
    }

}