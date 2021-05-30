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
     * @return array list of data, created using constructor with 1 parameter.
     */

    public ArrayList<Data> createData () throws FileNotFoundException {
        String source = "C:\\26_JavaST_2021\\Task02BranchingLoops\\branching\\src\\by.training\\resources\\fifthTask.txt";
        Scanner scanner = new FileOpener().readFile(source);
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
