package nl.gremmee.antopoly.core;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import nl.gremmee.antopoly.core.tiles.TileTests;

@RunWith(Suite.class)
@SuiteClasses({ DieTest.class, MunicipalityTest.class, //
        TileTests.class })

public class CoreTests {

}
