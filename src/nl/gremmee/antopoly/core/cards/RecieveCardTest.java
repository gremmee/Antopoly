package nl.gremmee.antopoly.core.cards;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.players.Player;

public class RecieveCardTest {

    Player player;
    RecieveCard card;

    @Before
    public void setUp() throws Exception {
        player = new Player(0, "TestPlayer");
        card = new RecieveCard("Recieve", "Recieve", 100);
    }

    @Test
    public void testGetName() {
        assertEquals("Recieve", card.getName());
    }

    @Test
    public void testExecute() throws CloneNotSupportedException {
        Player playerBefore = player.clone();
        card.excute(player);
        assertEquals(playerBefore.getMoney() + card.getValue(), player.getMoney());
    }

}
