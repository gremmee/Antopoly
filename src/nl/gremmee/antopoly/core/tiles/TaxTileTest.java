package nl.gremmee.antopoly.core.tiles;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.players.Player;

public class TaxTileTest {
    TaxTile tile;
    Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player(0, "TestPlayer");
        tile = new TaxTile(1, 200);
    }

    @Test
    public void testValue() {
        assertEquals(200, tile.getValue());
    }

    @Test
    public void testName() {
        assertEquals("Taxes", tile.getName());
    }

    @Test
    public void textExecute() {
        tile.execute(player);
        assertEquals(1300, player.getMoney());
    }
}
