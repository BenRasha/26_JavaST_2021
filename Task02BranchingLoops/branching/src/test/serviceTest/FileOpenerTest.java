import com.sun.javafx.scene.control.TableColumnSortTypeWrapper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class FileOpenerTest {

    private FileOpener fileOpener = new FileOpener();

    @DataProvider(name = "positiveDataForFileOpening")
    public Object[][] createDataForFileOpening() {
        return new Object[][] {
                {"src/test/resources/firstSource.txt","src/test/resources/firstSource.txt"},
                {"src/test/resources/secondSource.txt", "src/test/resources/secondSource.txt"},
        };
    }

    @DataProvider(name = "negativeDataForFileOpening")
    public Object[][] createNegativeDataForFileOpening() {
        return new Object[][] {
                {"notExistingPath"}
        };
    }


    @Test(description = "Positive scenario for file reading", dataProvider = "positiveDataForFileOpening")
    public void testReadFile (String source, String c) throws FileNotFoundException {
        Scanner actual = fileOpener.readFile(source);
        FileReader fileReader = null;
        try {
            File file = new File(c);
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner expected = new Scanner(fileReader);
        assertEquals(actual,expected);
    }

    @Test(description = "Negative scenario for file opening", dataProvider = "negativeDataForFileOpening")
    public void testNegativeReadFile (String source) {
        boolean caught = false;
        try {
            Scanner actual = fileOpener.readFile(source);
        } catch (FileNotFoundException | NullPointerException e) {
            caught = true;
        }
        assertTrue(caught);
    }

}
