package nl.gremmee.antopoly.core.tiles.tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.core.tiles.impl.FreeParkingTile;
import nl.gremmee.antopoly.players.impl.Player;

public class FreeParkingTileTest {

    private FreeParkingTile tile;
    private Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player(0, "TestPlayer");
        tile = new FreeParkingTile(0);
    }

    @Test
    public void testName() {
        assertEquals("Vrij parkeren", tile.getName());
    }

    @Test
    public void testExecute() throws CloneNotSupportedException {
        Player playerBefore = player.clone();
        tile.execute(player);
        assertEquals(playerBefore, player);
    }

}
