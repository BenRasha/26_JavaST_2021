import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class FirstTaskTest {

    private FirstTask firstTask = new FirstTask();

    @DataProvider(name = "PositiveDataForFirstTask")
    public Object[][] createDataForFirstTask() {
        return new Object[][] {
                {new Data(0, 3, 1), new Integer[]{0,-1,-2}}
        };
    }

    @Test(description = "Positive scenario for equation count", dataProvider = "PositiveDataForFirstTask")
    public void testFunctionCount(Data data, Integer[] a) {
        List<Integer> actual = firstTask.functionCount(data);
        List<Integer> expected = new ArrayList<>();
        for (Integer flag : a) {
            expected.add(flag);
        }
        assertEquals(actual, expected);
    }

}
