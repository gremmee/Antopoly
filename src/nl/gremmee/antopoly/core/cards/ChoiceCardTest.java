package nl.gremmee.antopoly.core.cards;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.Initialize;
import nl.gremmee.antopoly.players.Player;

public class ChoiceCardTest {

    Player player;
    ChoiceCard card;

    @Before
    public void setUp() throws Exception {
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
        Initialize.getInstance().initializeTileList();
        Initialize.getInstance().initializeChanceCards();
        player.setCurrentTile(Initialize.getInstance().getTileList().getTileByName("Start"));
        player.setMoney(170); // make sure it's below the thresshold
        Player playerBefore = player.clone();
        card.excute(player);
        assertEquals(playerBefore, player);
        System.out.println(playerBefore);
        System.out.println(player);
    }

}
