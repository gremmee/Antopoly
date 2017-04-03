package nl.gremmee.antopoly.core.cards;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.core.Municipality;
import nl.gremmee.antopoly.core.tiles.StreetTile;
import nl.gremmee.antopoly.players.Player;

public class PayPropertyCardTest {

    Player player;
    PayPropertyCard card;
    StreetTile street1;
    StreetTile street2;

    @Before
    public void setUp() throws Exception {
        player = new Player(0, "TestPlayer");
        card = new PayPropertyCard("PayProperty", "Pay Property", 104, 200);
        street1 = new StreetTile(0, "Street1", Municipality.OnsDorp, 100, 10, 20, 30, 40, 50, 75);
        street2 = new StreetTile(0, "Street2", Municipality.OnsDorp, 100, 10, 20, 30, 40, 50, 75);
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
        card.excute(player);
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
        card.excute(player);
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
        card.excute(player);
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
        card.excute(player);
        assertEquals(playerBefore.getMoney() - ((4 * card.getPerHouse()) + (1 * card.getPerHotel())),
                player.getMoney());
    }

}
