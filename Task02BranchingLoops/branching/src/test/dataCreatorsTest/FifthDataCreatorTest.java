import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class FifthDataCreatorTest {

    private FifthDataCreator fifthDataCreator = new FifthDataCreator();

    @DataProvider(name = "PositiveDataForDataCreationForFifthTask")
    public Object[][] createDataForFifthTask() {
        return new Object[][] {
                {new Data[]{new Data(14), new Data(5), new Data(8)}}
        };
    }

    @Test(description = "Positive scenario for data creation for fifth task", dataProvider = "PositiveDataForDataCreationForFifthTask")
    public void testCreateData(Data[] data) throws FileNotFoundException {
        List<Data> actual = fifthDataCreator.createData();
        List<Data> expected = new ArrayList<Data>(Arrays.asList(data));
        assertEquals(actual, expected);
    }

}
