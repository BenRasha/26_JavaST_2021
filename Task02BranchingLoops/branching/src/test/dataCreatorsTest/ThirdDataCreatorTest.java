import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class ThirdDataCreatorTest {

    private ThirdDataCreator thirdDataCreator = new ThirdDataCreator();

    @DataProvider(name = "PositiveDataForDataCreationForThirdTask")
    public Object[][] createDataForThirdTask() {
        return new Object[][] {
                {new Data[]{new Data(12,5), new Data(1,1)}}
        };
    }

    @Test(description = "Positive scenario for data creation for third task", dataProvider = "PositiveDataForDataCreationForThirdTask")
    public void testCreateData(Data[] data) throws FileNotFoundException, NumbersException {
        ArrayList<Data> actual = thirdDataCreator.createData();
        ArrayList<Data> expected = new ArrayList<>();
        for (Data flag: data) {
            expected.add(flag);
        }
        assertEquals(actual,expected);
    }

}
