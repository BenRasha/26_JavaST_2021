import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class RunnerTest {

    private Runner runner = new Runner();

    @DataProvider(name = "input_a_b")
    public Object[][] createCorrectData() {
        return new Object[][]{
                        {new double[]{2.0, 3.0}, 15.7},
                        {new double[]{0.5, 0.6}, 0.3454},
                        {new double[]{1.0, 1.0}, 0.0},
                        {new double[]{0.0, 0.0}, 0.0},
                };
    }

    @Test
    public void testTest() {
        String expected = "TestNG is working fine";
        String actual = "TestNG is working fine";
        assertEquals(actual, expected);
    }

    @Test(description = "Positive scenario for area",dataProvider = "input_a_b")
    public void testArea (double []ab, double c) {
        double actual = runner.areaCounter(ab[0], ab[1]);
        double expected = c;
        assertEquals(actual,expected,0.0001);
    }
}
