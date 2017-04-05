package nl.gremmee.antopoly.players.tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.core.cards.impl.GetOutOfJailCard;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.impl.Player;

public class PlayerTest {

    private Player player;

    @Before
    public void setUp() throws Exception {
        Initialize.getInstance().initializeArtificialIntelligenceList();
        Initialize.getInstance().initializeRuleList();
        player = new Player(1, "TestPlayer");
    }

    @Test
    public void testGetName() {
        assertEquals("TestPlayer", player.getName());
    }

    @Test
    public void testGetID() {
        assertEquals(1, player.getId());
    }

    @Test
    public void testActive() {
        assertEquals(false, player.isActive());
        player.setActive(true);
        assertEquals(true, player.isActive());
    }

    @Test
    public void testCardList() {
        assertEquals(0, player.getCardList().size());
        ICard card = new GetOutOfJailCard("Verlaat de gevangenis", "Verlaat de gevangenis zonder te betalen");
        player.getCardList().add(card);
        assertEquals(1, player.getCardList().size());
        card = new GetOutOfJailCard("Verlaat de gevangenis", "Verlaat de gevangenis zonder te betalen");
        player.getCardList().add(card);
        assertEquals(2, player.getCardList().size());
    }

    @Test
    public void testHasGetOUtOfJailCard() {
        assertEquals(false, player.hasGetOutOfJailCard());
        ICard card = new GetOutOfJailCard("Verlaat de gevangenis", "Verlaat de gevangenis zonder te betalen");
        player.getCardList().add(card);
        assertEquals(true, player.hasGetOutOfJailCard());
    }

    @Test
    public void testUseGetOUtOfJailCard() throws CloneNotSupportedException {
        Initialize.getInstance().initializeTileList();
        Initialize.getInstance().initializeChanceCardsList();
        Initialize.getInstance().initializeCommunityChestCardsList();
        player.setCurrentTile(Initialize.getInstance().getTileList().getTileByName("Jail"));
        ICard card = new GetOutOfJailCard("Verlaat de gevangenis", "Verlaat de gevangenis zonder te betalen");
        player.getCardList().add(card);
        player.setInJail(true);
        player.useGetOutOfJailCard();
        assertEquals(0, player.getCardList().size());
    }
}
