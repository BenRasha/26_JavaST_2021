import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
public class FitCheckerTest {

    private FitChecker fitChecker = new FitChecker();

    @DataProvider(name = "PositiveDataForFitChecking")
    public Object[][] createDataForFitChecking() {
        return new Object[][] {
                {new Data(3,4,5, 6, 7), false},
                {new Data(5,4,3, 6, 7), false},
                {new Data(7,8,2, 6, 7), true},
                {new Data(5,5,5, 6, 7), false}
        };
    }

    @Test(description = "Positive scenario for checking whether brick fits in a hole", dataProvider = "PositiveDataForFitChecking")
    public void testCheckWhetherBrickFits (Data data, boolean c) {
        boolean actual = fitChecker.checkWhetherBrickFits(data);
        boolean expected = c;
        assertEquals(actual, expected);
    }

}
