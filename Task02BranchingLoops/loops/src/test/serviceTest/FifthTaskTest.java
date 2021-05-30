import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FifthTaskTest {

    private FifthTask fifthTask = new FifthTask();

    @DataProvider(name = "PositiveDataForNumberSplit")
    public Object[][] createDataForNumbersSplit() {
        return new Object[][] {
                {300, 00},
                {312, 12},
                {0,0},
                {1,01}
        };
    }

    @Test(description = "Positive scenario for numbers spli", dataProvider = "PositiveDataForNumberSplit")
    public void testNumbersSplit(int a, int c) {
        int actual = fifthTask.numbersSplit(a);
        int expected = c;
        assertEquals(actual, expected);
    }

    @Test(description = "Positive scenario for number search")
    public void testNumberSearch() {
        int actual = fifthTask.numbersFinder();
        int expected = 350;
        assertEquals(actual, expected);
    }

}
