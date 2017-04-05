package nl.gremmee.antopoly.core.cards.tst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.core.cards.impl.GotoJailCard;
import nl.gremmee.antopoly.core.tiles.impl.JailTile;
import nl.gremmee.antopoly.core.tiles.impl.StartTile;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.impl.Player;

public class GotoJailCardTest {

    private Player player;
    private JailTile tile;
    private StartTile startTile;
    private GotoJailCard card;

    @Before
    public void setUp() throws Exception {
        Initialize.getInstance().initializeArtificialIntelligenceList();
        Initialize.getInstance().initializeRuleList();
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
