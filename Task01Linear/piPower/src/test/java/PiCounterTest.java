import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PiCounterTest {

    @DataProvider(name = "positiveDataForElevation")
    public Object[][] createPositiveDataForElevation() {
        return new Object[][]{
                {0, 1.0},
                {1, Math.PI},
                {2, Math.pow(Math.PI,2)},
                {3, Math.pow(Math.PI,3)}
        };
    }

    @Test
    public void testTest() {
        String expected = "TestNG is working fine";
        String actual = "TestNG is working fine";
        assertEquals(actual, expected);
    }

    @Test(description = "Positive scenario for PI elevation",dataProvider = "positiveDataForElevation")
    public void areaTest (int a, double c) {
        double expected = c;
        double actual = PiCounter.piElevator(a);
        assertEquals(actual, expected,0.0001);
    }
}
