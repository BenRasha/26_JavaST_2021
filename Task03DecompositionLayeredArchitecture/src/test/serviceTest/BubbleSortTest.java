import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.AssertJUnit.assertEquals;

public class BubbleSortTest {

    private BubbleSort bubbleSort = new BubbleSort();

    @DataProvider(name = "PositiveDataForBubbleSorting")
    public Object[][] createDataForBubbleSorting() {
        return new Object[][] {
                {true, new Integer[]{2, 6, 7 ,8, 567}},
                {false, new Integer[]{567, 8, 7, 6, 2}}
        };
    }

    @Test(description = "Positive scenario for bubble sorting", dataProvider = "PositiveDataForBubbleSorting")
    public void testSort(boolean isIncreasing, Integer[] c) throws ServiceException {
        Array actual = new Array();
        bubbleSort.sort(actual, isIncreasing);
        Array expected = new Array();
        expected.getValues().addAll(Arrays.asList(c));
        assertEquals(expected, actual);
    }

}
