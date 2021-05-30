import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArithmeticCompilerTest {

    private ArithmeticCompiler arithmeticCompiler = new ArithmeticCompiler();

    @DataProvider(name = "positiveDataForHalfOfTheSum")
    public Object[][] createDataForHalfOfTheSum() {
        return new Object[][]{
                {new Data(1,3), 2},
                {new Data(0,0), 0},
                {new Data(1,1), 1},
                {new Data(2,3), 2}
        };
    }

    @DataProvider(name = "positiveDataForDoubledMultiplication")
    public Object[][] createDataForDoubledMultiplication() {
        return new Object[][] {
                {new Data(0,0), 0},
                {new Data(1,1), 2},
                {new Data(-1, 3), -6},
                {new Data(-1,-1), 2}
        };
    }

    @DataProvider(name = "positiveDataForNumbersSwap")
    public Object[][] createDataForNumbersSwap() {
        return new Object[][] {
                {new Data(5, 3), new Data(30, 4)},
                {new Data(7, 8), new Data(7, 112)},
                {new Data(1,2), new Data(1, 4)}
        };
    }

    @Test
    public void testTest() {
        String expected = "TestNG is working fine";
        String actual = "TestNG is working fine";
        assertEquals(expected,actual);
    }

    @Test(description = "Positive scenario for half of the sum",dataProvider = "positiveDataForHalfOfTheSum")
    public void testHalfSumFinder (Data data, int c) {
        int actual = arithmeticCompiler.halfSumFinder(data);
        int expected = c;
        assertEquals(actual,expected);
    }

    @Test(description = "Positive scenario for doubled result of multiplication", dataProvider = "positiveDataForDoubledMultiplication")
    public void testDualMultiFinder (Data data, int c) {
        int actual = arithmeticCompiler.dualMultiFinder(data);
        int expected = c;
        assertEquals(actual, expected);
    }

    @Test(description = "Positive scenario for numbers swap", dataProvider = "positiveDataForNumbersSwap")
    public void testNumberReplacer (Data data, Data c) {
        Data actual = arithmeticCompiler.numberReplacer(data);
        Data expected = c;
        assertEquals(actual, expected);
    }
}
