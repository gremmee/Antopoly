package nl.gremmee.antopoly.core;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import nl.gremmee.antopoly.core.cards.tst.CardTests;
import nl.gremmee.antopoly.core.lists.tst.ListsTests;
import nl.gremmee.antopoly.core.tiles.tst.TileTests;

@RunWith(Suite.class)
@SuiteClasses({ ListsTests.class, CardTests.class, DieTest.class, MunicipalityTest.class, //
        TileTests.class })

public class CoreTests {

}
