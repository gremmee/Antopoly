package nl.gremmee.antopoly.core.tiles.tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.core.tiles.impl.StartTile;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.impl.Player;

public class StartTileTest {

    private StartTile tile;
    private Player player;

    @Before
    public void setUp() throws Exception {
        Initialize.getInstance().initializeArtificialIntelligenceList();
        Initialize.getInstance().initializeRules();
        player = new Player(0, "TestPlayer");
        tile = new StartTile(0);
    }

    @Test
    public void testName() {
        assertEquals("Start", tile.getName());
    }

    @Test
    public void testExecute() throws CloneNotSupportedException {
        Player playerBefore = player.clone();
        tile.execute(player);
        assertEquals(playerBefore, player);
    }

}
