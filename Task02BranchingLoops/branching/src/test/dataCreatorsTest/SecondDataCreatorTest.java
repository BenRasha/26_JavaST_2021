import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

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
        ArrayList<Data> actual = secondDataCreator.createData();
        ArrayList<Data> expected = new ArrayList<>();
        for (Data flag: data) {
            expected.add(flag);
        }
        assertEquals(actual, expected);
    }

}
