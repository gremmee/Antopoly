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
        return Arrays.asList(new Object[][] { { Municipality.Amsterdam, 2, 200 }, { Municipality.Arnhem, 3, 50 },
                { Municipality.DenHaag, 3, 150 }, { Municipality.Groningen, 3, 150 }, { Municipality.Haarlem, 3, 100 },
                { Municipality.OnsDorp, 2, 50 }, { Municipality.Rotterdam, 3, 200 }, { Municipality.Utrect, 3, 100 } });
    }

    private Municipality municipality;
    private int expectedSize;
    private int expectedHousePrice;

    public MunicipalityTest(Municipality aMunicipality, int aExpectedSize, int aExpectedHousePrice) {
        municipality = aMunicipality;
        expectedSize = aExpectedSize;
        expectedHousePrice = aExpectedHousePrice;
    }

    @Test
    public void testSize() {
        int size = municipality.getSize();
        assertEquals(expectedSize, size);
    }

    @Test
    public void testHousePrice() {
        int housePrice = municipality.getHousePrice();
        assertEquals(expectedHousePrice, housePrice);
    }

}
