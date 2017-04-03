package nl.gremmee.antopoly.core.cards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.Initialize;
import nl.gremmee.antopoly.core.tiles.JailTile;
import nl.gremmee.antopoly.core.tiles.StartTile;
import nl.gremmee.antopoly.players.Player;

public class GotoJailCardTest {

    Player player;
    JailTile tile;
    StartTile startTile;
    GotoJailCard card;

    @Before
    public void setUp() throws Exception {
        Initialize.getInstance().initializeTileList();
        startTile = new StartTile(0);
        tile = new JailTile(1);
        player = new Player(0, "TestPlayer");
        player.setCurrentTile(startTile);

        card = new GotoJailCard();
    }

    @Test
    public void testGetName() {
        assertEquals("Goto Jail", card.getName());
    }

    @Test
    public void testGetTile() {
        assertEquals(tile, card.getTile());
    }

    @Test
    public void testExecute() throws CloneNotSupportedException {
        Player playerBefore = player.clone();
        card.excute(player);
        assertEquals(tile, player.getCurrentTile());
        assertTrue(player.isInJail());
        assertEquals(playerBefore.getMoney(), player.getMoney());
    }

}
