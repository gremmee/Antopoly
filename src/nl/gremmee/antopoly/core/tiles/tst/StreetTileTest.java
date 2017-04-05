package nl.gremmee.antopoly.core.tiles.tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.core.Municipality;
import nl.gremmee.antopoly.core.tiles.impl.StreetTile;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.impl.Player;

public class StreetTileTest {

    private StreetTile ownTile;
    private StreetTile ownerTile;
    private StreetTile ownerTile1;
    private StreetTile ownerTile2;
    private StreetTile ownerTile3;
    private StreetTile buyTile;
    private Player player;
    private Player owner;

    @Before
    public void setUp() throws Exception {
        Initialize.getInstance().initializeArtificialIntelligenceList();
        Initialize.getInstance().initializeRules();
        Initialize.getInstance().initializeRules();
        player = new Player(0, "TestPlayer");
        owner = new Player(1, "TestOwner");
        ownTile = new StreetTile(0, "OwnStreet", Municipality.DenHaag, 200, 20, 30, 40, 50, 60, 170);
        ownTile.setOwner(player);
        player.getTileList().add(ownTile);
        ownerTile = new StreetTile(1, "OwnerStreet", Municipality.Arnhem, 100, 10, 20, 30, 40, 50, 160);
        ownerTile.setOwner(owner);
        owner.getTileList().add(ownerTile);
        ownerTile1 = new StreetTile(2, "OwnerStreet1", Municipality.Rotterdam, 1000, 100, 200, 300, 400, 500, 1000);
        ownerTile1.setOwner(owner);
        owner.getTileList().add(ownerTile1);
        ownerTile2 = new StreetTile(3, "OwnerStreet3", Municipality.Rotterdam, 1000, 100, 200, 300, 400, 500, 1000);
        ownerTile2.setOwner(owner);
        owner.getTileList().add(ownerTile2);
        ownerTile3 = new StreetTile(3, "OwnerStreet3", Municipality.Rotterdam, 1000, 100, 200, 300, 400, 500, 1000);
        ownerTile3.setOwner(owner);
        owner.getTileList().add(ownerTile3);
        buyTile = new StreetTile(30, "BuyStreet", Municipality.OnsDorp, 150, 20, 30, 40, 50, 60, 170);
    }

    @Test
    public void testOwnValue() {
        assertEquals(200, ownTile.getValue());
    }

    @Test
    public void testOwnerValue() {
        assertEquals(100, ownerTile.getValue());
    }

    @Test
    public void testOwnName() {
        assertEquals("OwnStreet", ownTile.getName());
    }

    @Test
    public void testOwnerName() {
        assertEquals("OwnerStreet", ownerTile.getName());
    }

    @Test
    public void textExecuteOwnTile() {
        int money = player.getMoney();
        ownTile.execute(player);
        assertEquals(money, player.getMoney());
    }

    @Test
    public void textExecuteBuyTile() {
        int money = player.getMoney();
        buyTile.execute(player);
        assertEquals(money - buyTile.getValue(), player.getMoney());
    }

    @Test
    public void textExecuteOwnerTileDoubleRent() {
        int ownMoney = player.getMoney();
        int ownerMoney = owner.getMoney();
        ownerTile1.execute(player);
        assertEquals(ownMoney - (ownerTile1.getRent() * 2), player.getMoney());
        assertEquals(ownerMoney + (ownerTile1.getRent() * 2), owner.getMoney());
    }

    @Test
    public void textExecuteOwnerTile1HouseRent() {
        int ownMoney = player.getMoney();
        int ownerMoney = owner.getMoney();
        ownerTile1.buyHouse();
        ownerTile1.execute(player);
        assertEquals(ownMoney - ownerTile1.getHouse1(), player.getMoney());
        assertEquals(ownerMoney + ownerTile1.getHouse1(), owner.getMoney());
    }

    @Test
    public void textExecuteOwnerTile2HouseRent() {
        int ownMoney = player.getMoney();
        int ownerMoney = owner.getMoney();
        ownerTile1.buyHouse();
        ownerTile1.buyHouse();
        ownerTile1.execute(player);
        assertEquals(ownMoney - ownerTile1.getHouse2(), player.getMoney());
        assertEquals(ownerMoney + ownerTile1.getHouse2(), owner.getMoney());
    }

    @Test
    public void textExecuteOwnerTile3HouseRent() {
        int ownMoney = player.getMoney();
        int ownerMoney = owner.getMoney();
        ownerTile1.buyHouse();
        ownerTile1.buyHouse();
        ownerTile1.buyHouse();
        ownerTile1.execute(player);
        assertEquals(ownMoney - ownerTile1.getHouse3(), player.getMoney());
        assertEquals(ownerMoney + ownerTile1.getHouse3(), owner.getMoney());
    }

    @Test
    public void textExecuteOwnerTile4HouseRent() {
        int ownMoney = player.getMoney();
        int ownerMoney = owner.getMoney();
        ownerTile1.buyHouse();
        ownerTile1.buyHouse();
        ownerTile1.buyHouse();
        ownerTile1.buyHouse();
        ownerTile1.execute(player);
        assertEquals(ownMoney - ownerTile1.getHouse4(), player.getMoney());
        assertEquals(ownerMoney + ownerTile1.getHouse4(), owner.getMoney());
    }

    @Test
    public void textExecuteOwnerTile1HotelRent() {
        int ownMoney = player.getMoney();
        int ownerMoney = owner.getMoney();
        ownerTile1.buyHouse();
        ownerTile1.buyHouse();
        ownerTile1.buyHouse();
        ownerTile1.buyHouse();
        ownerTile1.buyHouse();
        ownerTile1.execute(player);
        assertEquals(ownMoney - ownerTile1.getHotel(), player.getMoney());
        assertEquals(ownerMoney + ownerTile1.getHotel(), owner.getMoney());
    }

    @Test
    public void textExecuteOwnerTile() {
        int ownMoney = player.getMoney();
        int ownerMoney = owner.getMoney();
        ownerTile.execute(player);
        assertEquals(ownMoney - ownerTile.getRent(), player.getMoney());
        assertEquals(ownerMoney + ownerTile.getRent(), owner.getMoney());
    }
}
