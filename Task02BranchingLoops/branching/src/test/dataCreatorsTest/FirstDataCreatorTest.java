import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.testng.Assert.assertEquals;

public class FirstDataCreatorTest {

    private FirstDataCreator firstDataCreator = new FirstDataCreator();

    @DataProvider(name = "PositiveDataForDataCreationForFirstTask")
    public Object[][] createDataForFirstTask() {
        return new Object[][] {
                {new Data[]{new Data(-1,5,6,-4), new Data(4,-5,3,-2)}},
        };
    }

    @Test(description = "Positive scenario for Data creation for first task", dataProvider = "PositiveDataForDataCreationForFirstTask")
    public void testCreateData(Data[] data) throws FileNotFoundException, NumbersException {
        List<Data> actual = firstDataCreator.createData();
        List<Data> expected = new ArrayList<Data>(Arrays.asList(data));
        assertEquals(actual, expected);
    }

}
