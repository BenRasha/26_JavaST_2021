import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class InputAnalyzerTest {

    private InputAnalyzer inputAnalyzer = new InputAnalyzer();

    @DataProvider(name = "PositiveDataForNumbersEqualityCheck")
    public Object[][] createDataForNumbersEqualityCheck() {
        return new Object[][] {
                {new Integer[]{1, 2, 3}, new Integer[]{0, 1, 5}, new Integer[]{1}},
                {new Integer[]{1, 2, 3}, new Integer[]{1, 2, 3}, new Integer[]{1, 2, 3}}
        };
    }

    @Test(description = "Positive scenario for numbers equality check", dataProvider = "PositiveDataForNumbersEqualityCheck")
    public void testNumbersEquality(Integer[] inputted, Integer[] generated, Integer[] c) {
        List<Integer> inputtedList = new ArrayList<>();
        List<Integer> generatedList = new ArrayList<>();
        for (Integer flag : inputted) {
            inputtedList.add(flag);
        }
        for (Integer flag : generated) {
            generatedList.add(flag);
        }
        List<Integer> actual = inputAnalyzer.numbersAreEqualCheck(inputtedList,generatedList);
        List<Integer> expected = new ArrayList<>();
        for (Integer flag : c) {
            expected.add(flag);
        }
        assertEquals(actual,expected);
    }
}
