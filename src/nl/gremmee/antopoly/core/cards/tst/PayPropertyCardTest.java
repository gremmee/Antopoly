package nl.gremmee.antopoly.core.cards.tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.core.Municipality;
import nl.gremmee.antopoly.core.cards.impl.PayPropertyCard;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.impl.StreetTile;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.impl.Player;

public class PayPropertyCardTest {

    private Player player;
    private PayPropertyCard card;
    private StreetTile street1;
    private StreetTile street2;

    @Before
    public void setUp() throws Exception {
        Initialize.getInstance().initializeArtificialIntelligenceList();
        Initialize.getInstance().initializeRuleList();
        player = new Player(0, "TestPlayer");
        card = new PayPropertyCard("PayProperty", "Pay Property", 104, 200);
        street1 = new StreetTile(Tiles.MEDITERRANEAN_AVENUE, Municipality.OnsDorp, 100, 10, 20, 30, 40, 50, 75);
        street2 = new StreetTile(Tiles.BALTIC_AVENUE, Municipality.OnsDorp, 100, 10, 20, 30, 40, 50, 75);
    }

    @Test
    public void testGetName() {
        assertEquals("PayProperty", card.getName());
    }

    @Test
    public void testExecuteNoHouses() throws CloneNotSupportedException {
        player.getTileList().add(street1);
        street1.setOwner(player);
        Player playerBefore = player.clone();
        card.execute(player);
        assertEquals(playerBefore.getMoney() - ((0 * card.getPerHouse()) + (0 * card.getPerHotel())),
                player.getMoney());
    }

    @Test
    public void testExecuteHouses() throws CloneNotSupportedException {
        player.getTileList().add(street1);
        street1.setOwner(player);
        street1.buyHouse();
        street1.buyHouse();
        Player playerBefore = player.clone();
        card.execute(player);
        assertEquals(playerBefore.getMoney() - ((2 * card.getPerHouse()) + (0 * card.getPerHotel())),
                player.getMoney());
    }

    @Test
    public void testExecuteHotels() throws CloneNotSupportedException {
        player.getTileList().add(street1);
        street1.setOwner(player);
        street1.buyHouse();
        street1.buyHouse();
        street1.buyHouse();
        street1.buyHouse();
        street1.buyHouse();
        Player playerBefore = player.clone();
        card.execute(player);
        assertEquals(playerBefore.getMoney() - ((0 * card.getPerHouse()) + (1 * card.getPerHotel())),
                player.getMoney());
    }

    @Test
    public void testExecuteHouseAndHotels() throws CloneNotSupportedException {
        player.getTileList().add(street1);
        street1.setOwner(player);
        street1.buyHouse();
        street1.buyHouse();
        street1.buyHouse();
        street1.buyHouse();
        street1.buyHouse();
        player.getTileList().add(street2);
        street2.setOwner(player);
        street2.buyHouse();
        street2.buyHouse();
        street2.buyHouse();
        street2.buyHouse();
        Player playerBefore = player.clone();
        card.execute(player);
        assertEquals(playerBefore.getMoney() - ((4 * card.getPerHouse()) + (1 * card.getPerHotel())),
                player.getMoney());
    }

}
