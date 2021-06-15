import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class DataCreatorTest {

    private DataCreator dataCreator = new DataCreator();

    @DataProvider(name = "PositiveDataForDataCreation")
    public Object[][] createData() {
        return new Object[][] {
                {new Data[]{new Data(0, 10, 1), new Data(1, 9, 2), new Data(4, 6, 1)}}
        };
    }

    @Test(description = "Positive scenario for data creation", dataProvider = "PositiveDataForDataCreation")
    public void testCreate(Data[] data) {
        List<Data> actual = dataCreator.createData();
        List<Data> expected = new ArrayList<Data>(Arrays.asList(data));
        assertEquals(actual, expected);
    }

}
