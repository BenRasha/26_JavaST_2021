import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ModFinderTest {

    private ModFinder modFinder = new ModFinder();

    @DataProvider(name = "PositiveDataForModCounting")
    public Object[][] createDataForModFinding() {
        return new Object[][] {
                {new Data(-1,5,6,-4), 5},
                {new Data(4, -5,3,-2), 70},
                {new Data(0,0,0,0), 0},
                {new Data(0,0,0,1), 1}
        };
    }

    @Test(description = "Positive scenario for module counting", dataProvider = "PositiveDataForModCounting")
    public void testModCounter (Data data, int c) {
        int actual = modFinder.modCounter(data);
        int expected = c;
        assertEquals(actual, expected);
    }

}
