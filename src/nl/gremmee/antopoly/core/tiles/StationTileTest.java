package nl.gremmee.antopoly.core.tiles;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.players.Player;

public class StationTileTest {
    StationTile stationTile1;
    StationTile stationTile2;
    StationTile stationTile3;
    StationTile stationTile4;
    Player player;
    Player owner;

    @Before
    public void setUp() throws Exception {
        player = new Player(0, "TestPlayer");
        owner = new Player(1, "TestOwner");
        stationTile1 = new StationTile(1, "Station 1");
        stationTile2 = new StationTile(2, "Station 2");
        stationTile3 = new StationTile(3, "Station 3");
        stationTile4 = new StationTile(4, "Station 4");
    }

    @Test
    public void testOwnValue() {
        assertEquals(200, stationTile1.getValue());
    }

    @Test
    public void testOwnName() {
        assertEquals("Station 1", stationTile1.getName());
    }

    @Test
    public void textExecuteOwnTile() {
        stationTile1.setOwner(player);
        player.getTileList().add(stationTile1);
        int money = player.getMoney();
        stationTile1.execute(player);
        assertEquals(money, player.getMoney());
    }

    @Test
    public void textExecuteBuyTile() {
        int money = player.getMoney();
        stationTile1.execute(player);
        assertEquals(money - stationTile1.getValue(), player.getMoney());
    }

    @Test
    public void textExecuteOwner1Tile() {
        stationTile1.setOwner(owner);
        owner.getTileList().add(stationTile1);
        int ownMoney = player.getMoney();
        int ownerMoney = owner.getMoney();
        stationTile1.execute(player);
        assertEquals(ownMoney - StationTile.RENT_ONE, player.getMoney());
        assertEquals(ownerMoney + StationTile.RENT_ONE, owner.getMoney());
    }

    @Test
    public void textExecuteOwner2Tiles() {
        stationTile1.setOwner(owner);
        owner.getTileList().add(stationTile1);
        stationTile2.setOwner(owner);
        owner.getTileList().add(stationTile2);
        int ownMoney = player.getMoney();
        int ownerMoney = owner.getMoney();
        stationTile1.execute(player);
        assertEquals(ownMoney - StationTile.RENT_TWO, player.getMoney());
        assertEquals(ownerMoney + StationTile.RENT_TWO, owner.getMoney());
    }

    @Test
    public void textExecuteOwner3Tiles() {
        stationTile1.setOwner(owner);
        owner.getTileList().add(stationTile1);
        stationTile2.setOwner(owner);
        owner.getTileList().add(stationTile2);
        stationTile3.setOwner(owner);
        owner.getTileList().add(stationTile3);
        int ownMoney = player.getMoney();
        int ownerMoney = owner.getMoney();
        stationTile1.execute(player);
        assertEquals(ownMoney - StationTile.RENT_THREE, player.getMoney());
        assertEquals(ownerMoney + StationTile.RENT_THREE, owner.getMoney());
    }

    @Test
    public void textExecuteOwner4Tiles() {
        stationTile1.setOwner(owner);
        owner.getTileList().add(stationTile1);
        stationTile2.setOwner(owner);
        owner.getTileList().add(stationTile2);
        stationTile3.setOwner(owner);
        owner.getTileList().add(stationTile3);
        stationTile4.setOwner(owner);
        owner.getTileList().add(stationTile4);
        int ownMoney = player.getMoney();
        int ownerMoney = owner.getMoney();
        stationTile1.execute(player);
        assertEquals(ownMoney - StationTile.RENT_FOUR, player.getMoney());
        assertEquals(ownerMoney + StationTile.RENT_FOUR, owner.getMoney());
    }

}
