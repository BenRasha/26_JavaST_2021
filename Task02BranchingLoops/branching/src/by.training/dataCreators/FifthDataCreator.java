import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FifthDataCreator {

    final static Logger fifthDataCreatorLogger = LogManager.getLogger(FifthDataCreator.class.getName());
    ArrayList<Data>fifthTask = new ArrayList<>();

    /**
     * Used to create and validate data for the fifth task.
     * @param fileOpener Scanner object, which let's read from file.
     * @return array list of data, created using constructor with 1 parameter.
     */

    public ArrayList<Data> createData (FileOpener fileOpener) throws FileNotFoundException {
        Scanner scanner = fileOpener.readFile("branching\\src\\by.training\\resources\\fifthTask.txt");
        String [] separator;
        int objectCounter = 1;
        while (scanner.hasNextLine()) {
            separator = scanner.nextLine().split(" ");
            fifthTask.add(new Data(Integer.valueOf(separator[0])));
            fifthDataCreatorLogger.info("{} object has been successfully created", objectCounter);
            objectCounter++;
        }
        return fifthTask;
    }
}
