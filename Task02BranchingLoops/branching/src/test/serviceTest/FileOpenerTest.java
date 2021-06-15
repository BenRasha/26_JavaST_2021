import com.sun.javafx.scene.control.TableColumnSortTypeWrapper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class FileOpenerTest {

    private FileOpener fileOpener = new FileOpener();

    @DataProvider(name = "positiveDataForFileOpening")
    public Object[][] createDataForFileOpening() {
        return new Object[][]{
                {"src/test/resources/firstSource.txt", "This is a resource file for tests"},
                {"src/test/resources/secondSource.txt", "This a resource file for testing"},
        };
    }

    @DataProvider(name = "negativeDataForFileOpening")
    public Object[][] createNegativeDataForFileOpening() {
        return new Object[][]{
                {"notExistingPath"}
        };
    }


    @Test(description = "Positive scenario for file reading", dataProvider = "positiveDataForFileOpening")
    public void testReadFile(String source, String c) throws FileNotFoundException {
        List<String> actual = fileOpener.readFile(source);
        List<String> expected = new ArrayList<String>(Collections.singleton(c));
        assertEquals(actual, expected);

    }

    @Test(description = "Negative scenario for file opening", dataProvider = "negativeDataForFileOpening")
    public void testFillFromFile(String source) {
        boolean caught = false;
        try {
            List<String> actual = fileOpener.readFile(source);
        } catch (FileNotFoundException e) {
            caught = true;
        }
        assertTrue(caught);
    }
}

