package nl.gremmee.antopoly.core.cards.tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.core.Municipality;
import nl.gremmee.antopoly.core.cards.impl.GotoStepsCard;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.impl.StartTile;
import nl.gremmee.antopoly.core.tiles.impl.StreetTile;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.impl.Player;

public class GotoStepsCardTest {

    private static final int NUM_STEPS = 3;

    private Player player;
    private StreetTile medAveTile;
    private StartTile startTile;
    private GotoStepsCard goBackCard;

    @Before
    public void setUp() throws Exception {
        Initialize.getInstance().initializeArtificialIntelligenceList();
        startTile = new StartTile(Tiles.CHANCE_2);
        player = new Player(0, "TestPlayer");
        player.setCurrentTile(startTile);

        medAveTile = new StreetTile(Tiles.MEDITERRANEAN_AVENUE, Municipality.OnsDorp, 10, 20, 30, 40, 50, 60, 80);
        player.getTileList().add(medAveTile);
        medAveTile.setOwner(player);

        goBackCard = new GotoStepsCard("Go back " + NUM_STEPS, "Ga terug", NUM_STEPS, false);
    }

    @Test
    public void testGetName() {
        assertEquals("Go back " + NUM_STEPS, goBackCard.getName());
    }

    @Test
    public void testGetSteps() {
        assertEquals(NUM_STEPS, goBackCard.getNumSteps());
    }

    @Test
    public void testGetBackwards() {
        assertEquals(false, goBackCard.isForward());
    }

    @Test
    public void testExecuteBackwards() throws CloneNotSupportedException {
        Initialize.getInstance().initializeRuleList();
        Initialize.getInstance().initializeTileList();
        Player playerBefore = player.clone();
        goBackCard.execute(player);
        assertEquals(playerBefore.getCurrentTile().getID() - NUM_STEPS, player.getCurrentTile().getID());
    }

}
