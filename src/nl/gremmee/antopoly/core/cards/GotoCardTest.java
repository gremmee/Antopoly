package nl.gremmee.antopoly.core.cards;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.core.tiles.StartTile;
import nl.gremmee.antopoly.core.tiles.StationTile;
import nl.gremmee.antopoly.players.Player;

public class GotoCardTest {

    Player player;
    StationTile tile;
    StartTile startTile;
    GotoCard card;

    @Before
    public void setUp() throws Exception {
        startTile = new StartTile(0);
        tile = new StationTile(1, "Station");
        player = new Player(0, "TestPlayer");
        player.getTileList().add(tile);
        tile.setOwner(player);
        player.setCurrentTile(startTile);

        card = new GotoCard("Goto Station", "Ga naar station", tile);
    }

    @Test
    public void testGetName() {
        assertEquals("Goto Station", card.getName());
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
        assertEquals(playerBefore.getMoney(), player.getMoney());
    }

}
