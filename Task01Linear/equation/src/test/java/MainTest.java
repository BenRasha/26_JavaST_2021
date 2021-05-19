import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MainTest {

    private Main main = new Main();

    @DataProvider(name = "dataForFirstAction")
    public Object[][] createDataForFirstAction () {
        return new Object[][] {
                {1, 2},
                {0, 0},
                {3, 162}
        };
    }

    @DataProvider(name = "dataForSecondAction")
    public Object[][] createDataForSecondAction () {
        return new Object[][] {
                {1, 3},
                {0, 0},
                {3, 81}
        };
    }

    @DataProvider(name = "dataForThirdAction")
    public Object[][] createDataForThirdAction () {
        return new Object[][] {
                {1, 4},
                {0, 0},
                {3, 36}
        };
    }

    @DataProvider(name = "dataForFourthAction")
    public Object[][] createDataForFourthAction () {
        return new Object[][] {
                {1, 5},
                {0, 0},
                {3, 15}
        };
    }

    @DataProvider(name = "dataForWholeEquation")
    public Object[][] createDataForEquation () {
        return new Object[][] {
                {1, 4},
                {0, 6},
                {3, 108},
                {10, 17356}
        };
    }

    @Test(description = "Positive scenario for first action", dataProvider = "dataForFirstAction")
    public void firstActionTest (int a, int b) {
        int expected = b;
        int actual = main.firstAction(a);
        assertEquals(actual, expected);
    }

    @Test(description = "Positive scenario for second action", dataProvider = "dataForSecondAction")
    public void secondActionTest (int a, int b) {
        int expected = b;
        int actual = main.secondAction(a);
        assertEquals(actual,expected);
    }

    @Test(description = "Positive scenario for third action", dataProvider = "dataForThirdAction")
    public void thirdActionTest (int a, int b) {
        int expected = b;
        int actual = main.thirdAction(a);
        assertEquals(actual,expected);
    }

    @Test(description = "Positive scenario for fourth action", dataProvider = "dataForFourthAction" )
    public void fourthActionTest (int a, int b) {
        int expected = b;
        int actual = main.fourthAction(a);
        assertEquals(actual,expected);
    }

    @Test(description = "Positive scenario for whole equation", dataProvider = "dataForWholeEquation")
    public void wholeEquationTest (int a, int b) {
        int expected = b;
        int actual = main.wholeAnswer(a);
        assertEquals(actual,expected);
    }
}
