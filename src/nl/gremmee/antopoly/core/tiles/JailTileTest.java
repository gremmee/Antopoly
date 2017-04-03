package nl.gremmee.antopoly.core.tiles;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.players.Player;

public class JailTileTest {

    private JailTile tile;
    private Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player(0, "TestPlayer");
        tile = new JailTile(0);
    }

    @Test
    public void testName() {
        assertEquals("Jail", tile.getName());
    }

    @Test
    public void testExecute() throws CloneNotSupportedException {
        Player playerBefore = player.clone();
        tile.execute(player);
        assertEquals(playerBefore, player);
    }

}