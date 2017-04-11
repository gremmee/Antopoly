package nl.gremmee.antopoly.core.cards.tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.core.Municipality;
import nl.gremmee.antopoly.core.cards.impl.GotoTileCard;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.impl.StartTile;
import nl.gremmee.antopoly.core.tiles.impl.StationTile;
import nl.gremmee.antopoly.core.tiles.impl.StreetTile;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.impl.Player;

public class GotoTileCardTest {

    private Player player;
    private StationTile stationTile;
    private StreetTile medAveTile;
    private StartTile startTile;
    private GotoTileCard stationCard;
    private GotoTileCard medaveCard;

    @Before
    public void setUp() throws Exception {
        Initialize.getInstance().initializeArtificialIntelligenceList();
        startTile = new StartTile(Tiles.CHANCE_1);
        stationTile = new StationTile(Tiles.PENNSYLVANIA_RAILROAD);
        player = new Player(0, "TestPlayer");
        player.getTileList().add(stationTile);
        stationTile.setOwner(player);
        player.setCurrentTile(startTile);

        medAveTile = new StreetTile(Tiles.MEDITERRANEAN_AVENUE, Municipality.OnsDorp, 10, 20, 30, 40, 50, 60, 80);
        player.getTileList().add(medAveTile);
        medAveTile.setOwner(player);

        stationCard = new GotoTileCard("Goto Station", "Ga naar stationCard", stationTile);
        medaveCard = new GotoTileCard("Goto Med ave", "Ga naar dorpsstraat", medAveTile, false);
    }

    @Test
    public void testGetName() {
        assertEquals("Goto Station", stationCard.getName());
    }

    @Test
    public void testGetTile() {
        assertEquals(stationTile, stationCard.getTile());
    }

    @Test
    public void testGetForwards() {
        assertEquals(true, stationCard.isForward());
    }

    @Test
    public void testGetBackwards() {
        assertEquals(false, medaveCard.isForward());
    }

    @Test
    public void testExecuteForwards() throws CloneNotSupportedException {
        Initialize.getInstance().initializeRuleList();
        Player playerBefore = player.clone();
        stationCard.execute(player);
        assertEquals(stationTile, player.getCurrentTile());
        assertEquals(playerBefore.getMoney(), player.getMoney());
    }

    @Test
    public void testExecuteBackwards() throws CloneNotSupportedException {
        Initialize.getInstance().initializeRuleList();
        Player playerBefore = player.clone();
        medaveCard.execute(player);
        assertEquals(medAveTile, player.getCurrentTile());
        assertEquals(playerBefore.getMoney(), player.getMoney());
    }

}
