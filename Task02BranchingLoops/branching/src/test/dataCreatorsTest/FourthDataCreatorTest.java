import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class FourthDataCreatorTest {

    private FourthDataCreator fourthDataCreator = new FourthDataCreator();

    @DataProvider(name = "PositiveDataForDataCreationForFourthTask")
    public Object[][] createDataForFourthTask() {
        return new Object[][] {
                {new Data[]{new Data(3,4,5), new Data(5,4,3),new Data(7,8,2)}}
        };
    }

    @Test(description = "Positive scenario for data creation for fourth task", dataProvider = "PositiveDataForDataCreationForFourthTask")
    public void testCreateData(Data[] data) throws FileNotFoundException, NumbersException {
        ArrayList<Data> actual = fourthDataCreator.createData();
        ArrayList<Data> expected = new ArrayList<>();
        for (Data flag: data) {
            expected.add(flag);
        }
        assertEquals(actual, expected);
    }

}
