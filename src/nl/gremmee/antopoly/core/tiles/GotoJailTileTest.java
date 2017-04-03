package nl.gremmee.antopoly.core.tiles;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.Initialize;
import nl.gremmee.antopoly.players.Player;

public class GotoJailTileTest {

    private ITile tile;
    private Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player(0, "TestPlayer");
        Initialize.getInstance().initializeTileList();
        tile = Initialize.getInstance().getTileList().getTileByName("Goto Jail");
    }

    @Test
    public void testName() {
        assertEquals("Goto Jail", tile.getName());
    }

    @Test
    public void testExecute() throws CloneNotSupportedException {
        Player playerBefore = player.clone();
        tile.execute(player);
        playerBefore.setInJail(true);
        assertEquals(playerBefore, player);
    }

}