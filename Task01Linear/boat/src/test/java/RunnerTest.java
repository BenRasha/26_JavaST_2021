import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RunnerTest {

    private Runner runner = new Runner();

    @DataProvider(name = "input_a_b_c_d")
    public Object[][] createPositiveDataForWay() {
        return new Object[][]{
                {4, 2, 1, 3, 10},
                {0, 0, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {2, 1, 5, 1, 11},
        };
    }

    @Test
    public void testTest() {
        String expected = "TestNG is working fine";
        String actual = "TestNG is working fine";
        assertEquals(actual, expected);
    }

    @Test(description = "Positive scenario for area",dataProvider = "input_a_b_c_d")
    public void areaTest (int a, int b, int c, int d, int e) {
        double expected = e;
        double actual = runner.wayCounter(a,b,c,d);
        assertEquals(actual, expected);
    }
}
