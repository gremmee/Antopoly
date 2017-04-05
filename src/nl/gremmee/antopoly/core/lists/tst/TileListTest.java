package nl.gremmee.antopoly.core.lists.tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.core.lists.TileList;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.initialize.Initialize;

public class TileListTest {

    private TileList tileList;

    @Before
    public void setUp() throws Exception {
        tileList = Initialize.getInstance().initializeTileList();
    }

    @Test
    public void testName() {
        assertEquals("Boardwalk", tileList.getTileByID(Tiles.BOARDWALK.getId()).getName());
    }

    @Test
    public void testID() {
        assertEquals(39, tileList.getTileByName(Tiles.BOARDWALK).getID());
    }

}
