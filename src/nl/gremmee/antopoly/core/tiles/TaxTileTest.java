package nl.gremmee.antopoly.core.tiles;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TaxTileTest {
    TaxTile tile;

    @Before
    public void setUp() throws Exception {
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

}
