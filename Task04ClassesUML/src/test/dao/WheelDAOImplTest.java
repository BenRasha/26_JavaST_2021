import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.AssertJUnit.assertEquals;

public class WheelDAOImplTest {

    private WheelDAOImpl wheelDAO = new WheelDAOImpl();

    @DataProvider(name = "PositiveDataForReadingWheelsFromFile")
    public Object[][] createDataForReadingWheelsFromFile() {
        return new Object[][] {
                {new File("src/test/resources/Wheels.txt"), new Wheel(0.1, 0.1, true)}
        };
    }

    @Test(description = "Positive scenario for reading wheel from file", dataProvider = "PositiveDataForReadingWheelsFromFile")
    public void testReadWheelFromFile(File file, Wheel a) throws DAOException {
        Wheel actual = wheelDAO.createWheelFromFile(file);
        Wheel expected = a;
        assertEquals(actual, expected);
    }

}
