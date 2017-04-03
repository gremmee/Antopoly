package nl.gremmee.antopoly.core.tiles.tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.core.tiles.impl.TaxTile;
import nl.gremmee.antopoly.players.impl.Player;

public class TaxTileTest {
    TaxTile tile;
    Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player(0, "TestPlayer");
        tile = new TaxTile(1, "Income Taxes", 200);
    }

    @Test
    public void testValue() {
        assertEquals(200, tile.getValue());
    }

    @Test
    public void testName() {
        assertEquals("Income Taxes", tile.getName());
    }

    @Test
    public void textExecute() {
        int money = player.getMoney();
        tile.execute(player);
        assertEquals(money - tile.getValue(), player.getMoney());
    }
}
