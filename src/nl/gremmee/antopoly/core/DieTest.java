package nl.gremmee.antopoly.core;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DieTest {

    private Die die;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { { 0, 0, false }, { 7, 7, false }, { 1, 6, true }, { 1, 6, true },
                { 1, 6, true }, { 1, 6, true }, { 1, 6, true }, { -10, -6, false }, { 7, 40, false } });
    }

    @Before
    public void setUp() throws Exception {
        die = new Die(6);
    }

    @Test
    public void testSides() {
        assertEquals(6, die.getSides());
    }

    private int inputMin;
    private int inputMax;
    private boolean expected;

    public DieTest(int aInputMin, int aInputMax, boolean aExpected) {
        inputMin = aInputMin;
        inputMax = aInputMax;
        expected = aExpected;
    }

    @Test
    public void testRoll() {
        long roll = die.roll().longValue();
        assertEquals(expected, inputMin <= roll && roll <= inputMax);
    }

}
