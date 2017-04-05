package nl.gremmee.antopoly.core.cards.tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.core.cards.impl.ChoiceCard;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.impl.Player;

public class ChoiceCardTest {

    private Player player;
    private ChoiceCard card;

    @Before
    public void setUp() throws Exception {
        Initialize.getInstance().initializeArtificialIntelligenceList();
        player = new Player(0, "TestPlayer");
        card = new ChoiceCard("ChoiceCard", "Choice Card", 10);
    }

    @Test
    public void testGetName() {
        assertEquals("ChoiceCard", card.getName());
    }

    @Test
    public void testExecutePay() throws CloneNotSupportedException {
        Player playerBefore = player.clone();
        card.excute(player);
        assertEquals(playerBefore.getMoney() - card.getValue(), player.getMoney());
    }

    @Test
    public void testExecuteChance() throws CloneNotSupportedException {
        Initialize.getInstance().initializeRuleList();
        Initialize.getInstance().initializeTileList();
        Initialize.getInstance().initializeChanceCardsList();
        player.setCurrentTile(Initialize.getInstance().getTileList().getTileByName("Start"));
        // player.setMoney(170); // make sure it's below the thresshold
        Player playerBefore = player.clone();
        card.excute(player);
        assertEquals(playerBefore, player);
        System.out.println(playerBefore);
        System.out.println(player);
    }

}
