import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;

import static org.testng.AssertJUnit.assertEquals;

public class ArrayDAOImplTest {

    private ArrayDAOImpl arrayDAO = new ArrayDAOImpl();

    @DataProvider(name = "PositiveDataForCreatingArrayFromFile")
    public Object[][] createDataToCreateArrayFromFile() {
        return new Object[][] {
                {"src/by.training.task03DecompositionLayeredArchitecture/resources/array.txt", new Integer[]{2, 567, 6, 8, 7}}
        };
    }

    @Test(description = "Positive scenario for creating Array from file", dataProvider = "PositiveDataForCreatingArrayFromFile")
    public void testFillArrayFromFile(String source, Integer[] c) throws DAOException {
        Array actual = new Array();
        arrayDAO.fillArrayFromFile(actual, new File(source));
        Array expected = new Array();
        expected.getValues().addAll(Arrays.asList(c));
        assertEquals(expected, actual);
    }

}
