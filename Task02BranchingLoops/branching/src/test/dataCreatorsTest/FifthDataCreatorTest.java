import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

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
        ArrayList<Data> actual = fifthDataCreator.createData();
        ArrayList<Data> expected = new ArrayList<>();
        for (Data flag : data) {
            expected.add(flag);
        }
        assertEquals(actual, expected);
    }

}
