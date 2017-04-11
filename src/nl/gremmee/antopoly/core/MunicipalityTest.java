package nl.gremmee.antopoly.core;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MunicipalityTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { { Municipality.PURPLE, 2, 200, "PU" }, { Municipality.BLUE, 3, 50, "BL" },
                { Municipality.YELLOW, 3, 150, "YE" }, { Municipality.RED, 3, 150, "RE" },
                { Municipality.PINK, 3, 100, "PI" }, { Municipality.BROWN, 2, 50, "BR" },
                { Municipality.GREEM, 3, 200, "GR" }, { Municipality.ORANGE, 3, 100, "OR" } });
    }

    private Municipality municipality;
    private int expectedSize;
    private int expectedHousePrice;
    private String expectedAbbreviation;

    public MunicipalityTest(Municipality aMunicipality, int aExpectedSize, int aExpectedHousePrice,
            String aExpectedAbbreviation) {
        municipality = aMunicipality;
        expectedSize = aExpectedSize;
        expectedHousePrice = aExpectedHousePrice;
        expectedAbbreviation = aExpectedAbbreviation;
    }

    @Test
    public void testSize() {
        int size = municipality.getSize();
        assertEquals(expectedSize, size);
    }

    @Test
    public void testAbbreviation() {
        String abbr = municipality.getAbbreviation();
        assertEquals(expectedAbbreviation, abbr);
    }

    @Test
    public void testHousePrice() {
        int housePrice = municipality.getHousePrice();
        assertEquals(expectedHousePrice, housePrice);
    }

}
