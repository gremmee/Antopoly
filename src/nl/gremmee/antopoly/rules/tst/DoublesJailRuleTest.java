package nl.gremmee.antopoly.rules.tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.gremmee.antopoly.initialize.Initialize;
import nl.gremmee.antopoly.players.impl.Player;
import nl.gremmee.antopoly.rules.IRule;

public class DoublesJailRuleTest {

    private Player player;
    private IRule rule;

    @Before
    public void setUp() throws Exception {
        Initialize.getInstance().initializeArtificialIntelligenceList();
        Initialize.getInstance().initializeRuleList();
        rule = Initialize.getInstance().getRuleList().getRuleByName("Doubles Jail");
        player = new Player(0, "TestPlayer");
        player.payMoney(1480);
    }

    @Test
    public void testGetName() {
        assertEquals("Doubles Jail", rule.getName());
    }

}
