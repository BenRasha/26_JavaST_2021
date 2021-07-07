import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.AssertJUnit.assertEquals;

public class MergeSortTest {

    private MergeSort mergeSort = new MergeSort();

    @DataProvider(name = "PositiveDataForMergeSorting")
    public Object[][] createDataForMergeSorting() {
        return new Object[][] {
                {true, new Integer[]{2, 6, 7 ,8, 567}},
                {false, new Integer[]{567, 8, 7, 6, 2}}
        };
    }

    @Test(description = "Positive scenario for merge sorting", dataProvider = "PositiveDataForMergeSorting")
    public void testSort(boolean isIncreasing, Integer[] c) throws ServiceException {
        Array actual = new Array();
        mergeSort.sort(actual, isIncreasing);
        Array expected = new Array();
        expected.getValues().addAll(Arrays.asList(c));
        assertEquals(expected, actual);
    }

}
