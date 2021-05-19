import controller.Runner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RunnerTest {

    private Runner runner = new Runner();

    @DataProvider(name = "positiveDataForArea")
    public Object[][] createPositiveDataForArea() {
        return new Object[][]{
                {4.0, 12.0},
                {100.0, 300.0},
                {0.36, 1.08},
                {0.0, 0.0},
                {1.0, 3.0},
        };
    }

    @Test
    public void testTest() {
        String expected = "TestNG is working fine";
        String actual = "TestNG is working fine";
        assertEquals(actual, expected);
    }

    @Test(description = "Positive scenario for area",dataProvider = "positiveDataForArea")
    public void areaTest (double a, double c) {
        double expected = c;
        double actual = runner.areaCounter(a);
        assertEquals(actual, expected);
    }
}
