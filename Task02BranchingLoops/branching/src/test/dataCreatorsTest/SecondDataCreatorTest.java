import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class SecondDataCreatorTest {

    private SecondDataCreator secondDataCreator = new SecondDataCreator();

    @DataProvider(name = "PositiveDataForDataCreationForSecondTask")
    public Object[][] createDataForSecondTask() {
        return new Object[][] {
                {new Data[]{new Data(5,3), new Data(7,8)}}
        };
    }

    @Test(description = "Positive scenario for data creation for second task", dataProvider = "PositiveDataForDataCreationForSecondTask")
    public void testCreateData(Data[] data) throws FileNotFoundException, NumbersException {
        List<Data> actual = secondDataCreator.createData();
        List<Data> expected = new ArrayList<Data>(Arrays.asList(data));
        assertEquals(actual, expected);
    }

}
