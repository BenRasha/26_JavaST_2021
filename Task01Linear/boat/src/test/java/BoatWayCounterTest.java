import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BoatWayCounterTest {

    private BoatWayCounter boatWayCounter = new BoatWayCounter();

    @DataProvider(name = "input_a_b_c_d")
    public Object[][] createPositiveDataForWay() {
        return new Object[][]{
                {new int[]{4, 2, 1, 3}, 10},
                {new int[]{0, 0, 1, 1}, 0},
                {new int[]{1, 1, 1, 1}, 1},
                {new int[]{2, 1, 5, 1}, 11},
        };
    }

    @Test
    public void testTest() {
        String expected = "TestNG is working fine";
        String actual = "TestNG is working fine";
        assertEquals(actual, expected);
    }

    @Test(description = "Positive scenario for area",dataProvider = "input_a_b_c_d")
    public void areaTest (int[] a, int c) {
        int expected = c;
        int actual = boatWayCounter.wayCounter(a);
        assertEquals(actual, expected);
    }
}
