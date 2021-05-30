import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileOpener {

    static final Logger fileOpenerLogger = LogManager.getLogger(FileOpener.class.getName());

    /**
     * Opens and prepares file for reading.
     * @return FileReader object, with provided path to the source file
     */

    public FileReader parseResourceFile()  {
        File file = new File("C:\\26_JavaST_2021\\Task02BranchingLoops\\loops\\src\\by.training\\resources\\dataForTasks.txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            fileOpenerLogger.error("File was not found");
            e.printStackTrace();
        }
        return fileReader;
    }
}
