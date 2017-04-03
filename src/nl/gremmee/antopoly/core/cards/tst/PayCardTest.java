package nl.gremmee.antopoly.core.cards.tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.core.cards.impl.PayCard;
import nl.gremmee.antopoly.players.impl.Player;

public class PayCardTest {

    Player player;
    PayCard card;

    @Before
    public void setUp() throws Exception {
        player = new Player(0, "TestPlayer");
        card = new PayCard("Pay", "Pay", 100);
    }

    @Test
    public void testGetName() {
        assertEquals("Pay", card.getName());
    }

    @Test
    public void testExecute() throws CloneNotSupportedException {
        Player playerBefore = player.clone();
        card.excute(player);
        assertEquals(playerBefore.getMoney() - card.getValue(), player.getMoney());
    }

}
