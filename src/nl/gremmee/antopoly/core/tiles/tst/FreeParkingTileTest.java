package nl.gremmee.antopoly.core.tiles.tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.impl.FreeParkingTile;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.impl.Player;

public class FreeParkingTileTest {

    private FreeParkingTile tile;
    private Player player;

    @Before
    public void setUp() throws Exception {
        Initialize.getInstance().initializeArtificialIntelligenceList();
        Initialize.getInstance().initializeRuleList();
        tile = new FreeParkingTile(Tiles.FREE_PARKING);
        player = new Player(0, "TestPlayer");
        player.setCurrentTile(tile);
    }

    @Test
    public void testName() {
        assertEquals("Free Parking", tile.getName());
    }

    @Test
    public void testExecute() throws CloneNotSupportedException {
        Player playerBefore = player.clone();
        tile.execute(player);
        assertEquals(playerBefore, player);
    }

}
