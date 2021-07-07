import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.AssertJUnit.assertEquals;

public class SelectionSortTest {

    private SelectionSort selectionSort = new SelectionSort();

    @DataProvider(name = "PositiveDataForSelectionSorting")
    public Object[][] createDataForSelectionSorting() {
        return new Object[][] {
                {true, new Integer[]{2, 6, 7 ,8, 567}},
                {false, new Integer[]{567, 8, 7, 6, 2}}
        };
    }

    @Test(description = "Positive scenario for selection sorting", dataProvider = "PositiveDataForSelectionSorting")
    public void testSort(boolean isIncreasing, Integer[] c) throws ServiceException {
        Array actual = new Array();
        selectionSort.sort(actual, isIncreasing);
        Array expected = new Array();
        expected.getValues().addAll(Arrays.asList(c));
        assertEquals(expected, actual);
    }

}
