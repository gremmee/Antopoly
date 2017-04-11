package nl.gremmee.antopoly.core.tiles.tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.core.tiles.impl.StationTile;
import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.players.impl.Player;

public class StationTileTest {

    private StationTile stationTile1;
    private StationTile stationTile2;
    private StationTile stationTile3;
    private StationTile stationTile4;
    private Player player;
    private Player owner;

    @Before
    public void setUp() throws Exception {
        Initialize.getInstance().initializeArtificialIntelligenceList();
        Initialize.getInstance().initializeRuleList();
        player = new Player(0, "TestPlayer");
        owner = new Player(1, "TestOwner");
        stationTile1 = new StationTile(Tiles.READING_RAILROAD);
        stationTile2 = new StationTile(Tiles.PENNSYLVANIA_RAILROAD);
        stationTile3 = new StationTile(Tiles.B_O_RAILROAD);
        stationTile4 = new StationTile(Tiles.SHORT_LINE);
    }

    @Test
    public void testOwnValue() {
        assertEquals(200, stationTile1.getValue());
    }

    @Test
    public void testOwnName() {
        assertEquals("Reading Railroad", stationTile1.getName());
    }

    @Test
    public void textExecuteOwnTile() {
        player.addTile(stationTile1);
        int money = player.getMoney();
        stationTile1.execute(player);
        assertEquals(money, player.getMoney());
    }

    @Test
    public void textExecuteBuyTile() throws CloneNotSupportedException {
        IPlayer playerBefore = player.clone();
        stationTile1.execute(player);
        playerBefore.payMoney(stationTile1.getValue());
        assertEquals(playerBefore.getMoney(), player.getMoney());
    }

    @Test
    public void textExecuteOwner1Tile() throws CloneNotSupportedException {
        IPlayer playerBefore = player.clone();
        IPlayer ownerBefore = owner.clone();
        owner.addTile(stationTile1);
        stationTile1.execute(player);
        playerBefore.payMoney(StationTile.RENT_ONE);
        ownerBefore.receiveMoney(StationTile.RENT_ONE);
        assertEquals(playerBefore.getMoney(), player.getMoney());
        assertEquals(ownerBefore.getMoney(), owner.getMoney());
    }

    @Test
    public void textExecuteOwner2Tiles() throws CloneNotSupportedException {
        IPlayer playerBefore = player.clone();
        IPlayer ownerBefore = owner.clone();
        owner.addTile(stationTile1);
        owner.addTile(stationTile2);
        stationTile1.execute(player);
        playerBefore.payMoney(StationTile.RENT_TWO);
        ownerBefore.receiveMoney(StationTile.RENT_TWO);
        assertEquals(playerBefore.getMoney(), player.getMoney());
        assertEquals(ownerBefore.getMoney(), owner.getMoney());
    }

    @Test
    public void textExecuteOwner3Tiles() throws CloneNotSupportedException {
        IPlayer playerBefore = player.clone();
        IPlayer ownerBefore = owner.clone();
        owner.addTile(stationTile1);
        owner.addTile(stationTile2);
        owner.addTile(stationTile3);
        stationTile1.execute(player);
        playerBefore.payMoney(StationTile.RENT_THREE);
        ownerBefore.receiveMoney(StationTile.RENT_THREE);
        assertEquals(playerBefore.getMoney(), player.getMoney());
        assertEquals(ownerBefore.getMoney(), owner.getMoney());
    }

    @Test
    public void textExecuteOwner4Tiles() throws CloneNotSupportedException {
        IPlayer playerBefore = player.clone();
        IPlayer ownerBefore = owner.clone();
        owner.addTile(stationTile1);
        owner.addTile(stationTile2);
        owner.addTile(stationTile3);
        owner.addTile(stationTile4);
        stationTile1.execute(player);
        playerBefore.payMoney(StationTile.RENT_FOUR);
        ownerBefore.receiveMoney(StationTile.RENT_FOUR);
        assertEquals(playerBefore.getMoney(), player.getMoney());
        assertEquals(ownerBefore.getMoney(), owner.getMoney());
    }

}
