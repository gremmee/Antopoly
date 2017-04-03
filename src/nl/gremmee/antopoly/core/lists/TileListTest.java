package nl.gremmee.antopoly.core.lists;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import nl.gremmee.antopoly.Initialize;

@RunWith(Parameterized.class)
public class TileListTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { { 0, "Start" }, { 1, "Dorpsstraat" }, { 2, "Community Chest 1" },
                { 3, "Brink" }, { 4, "Income Taxes" }, { 5, "Station Zuid" }, { 6, "Steenstraat" }, { 7, "Chance 1" },
                { 8, "Ketelstraat" }, { 9, "Velperplein" }, { 10, "Jail" }, { 11, "Barteljorisstraat" },
                { 12, "Elektriciteitsbedrijf" }, { 13, "Zijlweg" }, { 14, "Houtstraat" }, { 15, "Station West" },
                { 16, "Neude" }, { 17, "Community Chest 2" }, { 18, "Biltstraat" }, { 19, "Vreeburg" },
                { 20, "Vrij parkeren" }, { 21, "A. Kerkhof" }, { 22, "Chance 2" }, { 23, "Grote Markt" },
                { 24, "Heerestraat" }, { 25, "Station Noord" }, { 26, "Spui" }, { 27, "Plein" }, { 28, "Waterleiding" },
                { 29, "L. Poten" }, { 30, "Goto Jail" }, { 31, "Hofplein" }, { 32, "Blaak" },
                { 33, "Community Chest 3" }, { 34, "Coolsingel" }, { 35, "Station Oost" }, { 36, "Chance 3" },
                { 37, "Leidsestraat" }, { 38, "Taxes" }, { 39, "Kalverstraat" } });
    }

    private int id;
    private String name;
    private TileList tileList;

    public TileListTest(int aID, String aName) {
        id = aID;
        name = aName;
    }

    @Before
    public void setUp() throws Exception {
        tileList = Initialize.getInstance().initializeTileList();
    }

    @Test
    public void testName() {
        assertEquals(name, tileList.getTileByID(id).getName());
    }

    @Test
    public void testID() {
        assertEquals(id, tileList.getTileByName(name).getID());
    }

}
