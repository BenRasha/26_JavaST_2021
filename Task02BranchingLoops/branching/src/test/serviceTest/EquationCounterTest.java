import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EquationCounterTest {

    private EquationCounter equationCounter = new EquationCounter();

    @DataProvider(name = "positiveDataForEquation")
    public Object[][] createDataForEquation () {
        return new Object[][] {
                {new Data(14), -191},
                {new Data(5), 0},
                {new Data(8), -65},
                {new Data(0), 0}
        };
    }

    @Test
    public void testTest() {
        String expected = "TestNG is working fine";
        String actual = "TestNG is working fine";
        assertEquals(expected,actual);
    }

    @Test(description = "Positive scenario for equation counting", dataProvider = "positiveDataForEquation")
    public void testCountEquation (Data data, int c) {
        int actual = equationCounter.countEquation(data);
        int expected = c;
        assertEquals(actual, expected);
    }

}
