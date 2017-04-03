package nl.gremmee.antopoly.core.cards;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.players.Player;

public class ReceiveCardTest {

    Player player;
    ReceiveCard card;

    @Before
    public void setUp() throws Exception {
        player = new Player(0, "TestPlayer");
        card = new ReceiveCard("Receive", "Receive", 100);
    }

    @Test
    public void testGetName() {
        assertEquals("Receive", card.getName());
    }

    @Test
    public void testExecute() throws CloneNotSupportedException {
        Player playerBefore = player.clone();
        card.excute(player);
        assertEquals(playerBefore.getMoney() + card.getValue(), player.getMoney());
    }

}
