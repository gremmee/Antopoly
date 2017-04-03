package nl.gremmee.antopoly.core.tiles.tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.Initialize;
import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.lists.DiceList;
import nl.gremmee.antopoly.core.lists.RollList;
import nl.gremmee.antopoly.core.tiles.impl.UtilityTile;
import nl.gremmee.antopoly.players.impl.Player;

public class UtilityTileTest {
    UtilityTile utilityTile1;
    UtilityTile utilityTile2;
    DiceList diceList;
    Player player;
    Player owner;

    @Before
    public void setUp() throws Exception {
        Initialize.getInstance().initializeDice(Settings.NUM_DICE);
        diceList = Initialize.getInstance().getDiceList();
        player = new Player(0, "TestPlayer");
        owner = new Player(1, "TestOwner");
        utilityTile1 = new UtilityTile(1, "Utility 1");
        utilityTile2 = new UtilityTile(2, "Utility 2");
    }

    @Test
    public void testOwnValue() {
        assertEquals(150, utilityTile1.getValue());
    }

    @Test
    public void testOwnName() {
        assertEquals("Utility 1", utilityTile1.getName());
    }

    @Test
    public void textExecuteOwnTile() {
        utilityTile1.setOwner(player);
        player.getTileList().add(utilityTile1);
        int money = player.getMoney();
        RollList rollList = diceList.roll();
        player.setRollList(rollList);
        utilityTile1.execute(player);
        assertEquals(money, player.getMoney());
    }

    @Test
    public void textExecuteBuyTile() {
        int money = player.getMoney();
        utilityTile1.execute(player);
        assertEquals(money - utilityTile1.getValue(), player.getMoney());
    }

    @Test
    public void textExecuteOwner1Tile() {
        utilityTile1.setOwner(owner);
        owner.getTileList().add(utilityTile1);
        int ownMoney = player.getMoney();
        int ownerMoney = owner.getMoney();
        RollList rollList = diceList.roll();
        player.setRollList(rollList);
        utilityTile1.execute(player);
        assertEquals(ownMoney - rollList.getResult() * UtilityTile.FACTOR_OWN_SINGLE, player.getMoney());
        assertEquals(ownerMoney + rollList.getResult() * UtilityTile.FACTOR_OWN_SINGLE, owner.getMoney());
    }

    @Test
    public void textExecuteOwner2Tiles() {
        utilityTile1.setOwner(owner);
        owner.getTileList().add(utilityTile1);
        utilityTile2.setOwner(owner);
        owner.getTileList().add(utilityTile2);
        int ownMoney = player.getMoney();
        int ownerMoney = owner.getMoney();
        RollList rollList = diceList.roll();
        player.setRollList(rollList);
        utilityTile1.execute(player);
        assertEquals(ownMoney - rollList.getResult() * UtilityTile.FACTOR_OWN_DOUBLE, player.getMoney());
        assertEquals(ownerMoney + rollList.getResult() * UtilityTile.FACTOR_OWN_DOUBLE, owner.getMoney());
    }

}
