import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FitCheckerTest {

    private FitChecker fitChecker = new FitChecker();

    @DataProvider(name = "PositiveDataForFitChecking")
    public Object[][] createDataForFitChecking() {
        return new Object[][] {
                {new Data(3,4,5), new int[]{12,5}, true},
                {new Data(5,4,3), new int[]{12,5}, true},
                {new Data(7,8,2), new int[]{12,5}, true},
                {new Data(5,5,5), new int[]{0,0}, false}
        };
    }

    @Test(description = "Positive scenario for checking whether brick fits in a hole", dataProvider = "PositiveDataForFitChecking")
    public void testCheckWhetherBrickFits (Data data, int[] ab, boolean c) {
        boolean actual = fitChecker.checkWhetherBrickFits(data, ab[0], ab[1]);
        boolean expected = c;
        assertEquals(actual, expected);
    }

}
