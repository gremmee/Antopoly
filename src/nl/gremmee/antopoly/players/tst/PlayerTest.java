package nl.gremmee.antopoly.players.tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.Money;
import nl.gremmee.antopoly.core.Municipality;
import nl.gremmee.antopoly.core.cards.ICard;
import nl.gremmee.antopoly.core.cards.impl.GetOutOfJailCard;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.impl.StreetTile;
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
        player.setCurrentTile(Initialize.getInstance().getTileList().getTileByName(Tiles.JAIL));
        ICard card = new GetOutOfJailCard("Verlaat de gevangenis", "Verlaat de gevangenis zonder te betalen");
        player.getCardList().add(card);
        player.setInJail(true);
        player.useGetOutOfJailCard();
        assertEquals(0, player.getCardList().size());
    }

    @Test
    public void testPlayerValue() {
        int expected = Money.PRICE_INITIAL_MONEY;
        assertEquals(expected, player.getValue());
        player.payMoney(50);
        expected -= 50;
        assertEquals(expected, player.getValue());
        player.receiveMoney(150);
        expected += 150;
        assertEquals(expected, player.getValue());
        StreetTile medAveTile = new StreetTile(Tiles.MEDITERRANEAN_AVENUE, Municipality.BROWN, 10, 20, 30, 40, 50, 60,
                80);
        player.addTile(medAveTile);
        expected += medAveTile.getValue() / 2;
        assertEquals(expected, player.getValue());
        StreetTile balAveTile = new StreetTile(Tiles.BALTIC_AVENUE, Municipality.BROWN, 20, 20, 30, 40, 50, 60, 80);
        player.addTile(balAveTile);
        balAveTile.buyHouse();
        expected += (balAveTile.getValue() / 2) + (balAveTile.getMunicipality().getHousePrice() / 2);
        assertEquals(expected, player.getValue());
        balAveTile.buyHouse();
        expected += (balAveTile.getMunicipality().getHousePrice() / 2);
        assertEquals(expected, player.getValue());
        balAveTile.buyHotel();
        expected += (balAveTile.getMunicipality().getHousePrice() / 2) * 3;
        assertEquals(expected, player.getValue());
        ICard card = new GetOutOfJailCard("Verlaat de gevangenis", "Verlaat de gevangenis zonder te betalen");
        player.getCardList().add(card);
        expected += Money.PRICE_GET_OUT_OF_JAIL_CARD;
        assertEquals(expected, player.getValue());
    }
}
