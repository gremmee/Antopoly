package nl.gremmee.antopoly.core.tiles;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TileListTest.class, ChanceTileTest.class, CommunityChestTileTest.class, FreeParkingTileTest.class,
        GotoJailTileTest.class, JailTileTest.class, StartTileTest.class, StationTileTest.class, StreetTileTest.class,
        TaxTileTest.class, UtilityTileTest.class })
public class TileTests {

}
