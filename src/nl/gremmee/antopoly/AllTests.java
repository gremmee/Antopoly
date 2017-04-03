package nl.gremmee.antopoly;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import nl.gremmee.antopoly.core.CoreTests;
import nl.gremmee.antopoly.players.tst.PlayerTest;

@RunWith(Suite.class)
@SuiteClasses({ CoreTests.class, PlayerTest.class })
public class AllTests {

}
