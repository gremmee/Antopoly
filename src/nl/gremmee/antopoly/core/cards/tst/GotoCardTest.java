package nl.gremmee.antopoly.core.cards.tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.Initialize;
import nl.gremmee.antopoly.core.cards.impl.GotoCard;
import nl.gremmee.antopoly.core.tiles.impl.StartTile;
import nl.gremmee.antopoly.core.tiles.impl.StationTile;
import nl.gremmee.antopoly.players.impl.Player;

public class GotoCardTest {

    private Player player;
    private StationTile tile;
    private StartTile startTile;
    private GotoCard card;

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
        Initialize.getInstance().initializeRules();
        Player playerBefore = player.clone();
        card.excute(player);
        assertEquals(tile, player.getCurrentTile());
        assertEquals(playerBefore.getMoney(), player.getMoney());
    }

}
