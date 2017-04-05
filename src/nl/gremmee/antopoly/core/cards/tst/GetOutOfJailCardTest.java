package nl.gremmee.antopoly.core.cards.tst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.core.cards.impl.GetOutOfJailCard;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.impl.Player;

public class GetOutOfJailCardTest {

    private Player player;
    private GetOutOfJailCard card;

    @Before
    public void setUp() throws Exception {
        Initialize.getInstance().initializeArtificialIntelligenceList();
        Initialize.getInstance().initializeRuleList();
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
