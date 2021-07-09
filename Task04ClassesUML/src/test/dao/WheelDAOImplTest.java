import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class WheelDAOImplTest {

    private WheelDAOImpl wheelDAO = new WheelDAOImpl();

    @DataProvider(name = "PositiveDataForReadingWheelsFromFile")
    public Object[][] createDataForReadingWheelsFromFile() {
        return new Object[][] {
                {new File("src/test/resources/Wheels.txt"), new Wheel(0.1, 0.1, true)}
        };
    }

    @DataProvider(name = "NegativeDataForReadingWheelsFromFile")
    public Object[][] negativeCreateDataForReadingWheelsFromFile() {
        return new Object[][] {
                {new File("not existing")}
        };
    }

    @Test(description = "Positive scenario for reading wheel from file", dataProvider = "PositiveDataForReadingWheelsFromFile")
    public void testReadWheelFromFile(File file, Wheel a) throws DAOException {
        Wheel actual = wheelDAO.createWheelFromFile(file);
        Wheel expected = a;
        assertEquals(actual, expected);
    }

    @Test(description = "Negative scenario for reading wheels from file", dataProvider = "NegativeDataForReadingWheelsFromFile", expectedExceptions = DAOException.class)
    public void negativeReadWheels(File file) throws DAOException {
        Wheel actual = wheelDAO.createWheelFromFile(file);
    }

}
