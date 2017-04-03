package nl.gremmee.antopoly.core.cards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.players.Player;

public class GetOutOfJailCardTest {

    Player player;
    GetOutOfJailCard card;

    @Before
    public void setUp() throws Exception {
        player = new Player(0, "TestPlayer");
        card = new GetOutOfJailCard("Verlaat de gevangenis", "Verlaat de gevangenis zonder te betalen");
    }

    @Test
    public void testGetName() {
        assertEquals("Verlaat de gevangenis", card.getName());
    }

    @Test
    public void testExecute() throws CloneNotSupportedException {
        card.excute(player);
        assertEquals(1, player.getCardList().size());
        assertTrue(player.hasGetOutOfJailCard());
    }

}