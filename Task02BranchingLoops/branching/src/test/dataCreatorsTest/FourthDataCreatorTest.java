import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class FourthDataCreatorTest {

    private FourthDataCreator fourthDataCreator = new FourthDataCreator();

    @DataProvider(name = "PositiveDataForDataCreationForFourthTask")
    public Object[][] createDataForFourthTask() {
        return new Object[][] {
                {new Data[]{new Data(3,4,5, 6, 7), new Data(5,4,3, 6, 7),new Data(7,8,2, 6, 7)}}
        };
    }

    @Test(description = "Positive scenario for data creation for fourth task", dataProvider = "PositiveDataForDataCreationForFourthTask")
    public void testCreateData(Data[] data) throws FileNotFoundException, NumbersException {
        List<Data> actual = fourthDataCreator.createData();
        List<Data> expected = new ArrayList<Data>(Arrays.asList(data));
        assertEquals(actual, expected);
    }

}
