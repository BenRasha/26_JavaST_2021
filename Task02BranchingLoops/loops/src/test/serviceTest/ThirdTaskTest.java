import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;


public class ThirdTaskTest {

    private ThirdTask thirdTask = new ThirdTask();

    @DataProvider(name = "PositiveDataForThirdTask")
    public Object[][] createDataForThirdTask() {
        return new Object[][] {
                {3, 0.7126526199642642},
                {4, 0.26369136828036654},
                {5, 0.16263047860276142}
        };
    }

    @Test(description = "Positive scenario for function count", dataProvider = "PositiveDataForThirdTask")
    public void testCount(int a, double c) {
        double actual = thirdTask.count(a);
        double expected = c;
        assertEquals(actual, expected);
    }

}
