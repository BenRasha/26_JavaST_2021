import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.AssertJUnit.assertEquals;

public class EngineDAOImplTest {

    private EngineDAOImpl engineDAO = new EngineDAOImpl();

    @DataProvider(name = "PositiveDataForEngineReadingFromFile")
    public Object[][] createEngineFromFile() {
        return new Object[][] {
                {new File("src/test/resources/Engines.txt"), new Engine("yo", 0.1, false)},
        };
    }
    @DataProvider(name = "NegativeScenarioForReadingEngineFromFile")
    public Object[][] negativeCreateEngineFromFile() {
        return new Object[][] {
                {new File("not existing")}
        };
    }

    @Test(description = "Positive scenario for reading engines from file", dataProvider = "PositiveDataForEngineReadingFromFile")
    public void testReadEngineFromFile(File file, Engine a) throws DAOException {
        Engine actual = engineDAO.createEngineFromFile(file);
        Engine expected = a;
        assertEquals(actual, expected);
    }

    @Test(description = "Negative scenario for reading engines from file", dataProvider = "NegativeScenarioForReadingEngineFromFile", expectedExceptions = DAOException.class)
    public void testNegativeCreateFromFile(File file) throws DAOException {
        Engine actual = engineDAO.createEngineFromFile(file);
    }

}
