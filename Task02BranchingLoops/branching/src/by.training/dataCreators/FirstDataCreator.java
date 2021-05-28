import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class FirstDataCreator {

    private ArrayList<Data>fstTask = new ArrayList<>();
    static final Logger firstDataCreatorLogger = LogManager.getLogger(FirstDataCreator.class.getName());

    /**
     * Used to create and validate data for the first task.
     * @param fileOpener Scanner object, which let's read from file.
     * @return array list of data created using constructor with 4 parameters.
     * @throws NumbersException custom exception with constructor that parses String message.
     */

    public ArrayList<Data> createData (FileOpener fileOpener) throws NumbersException {
        Scanner scanner = fileOpener.readFile("C:\\26_JavaST_2021\\Task02BranchingLoops\\branching\\src\\by.training\\resources\\firstTask.txt");
        String [] separator;
        int counter = 1;
        while (scanner.hasNextLine()) {
            separator = scanner.nextLine().split(" ");
            if (separator.length != 4) {
                firstDataCreatorLogger.error(new NumbersException("Not enough elements to create an object"));
                throw new NumbersException("Not enough elements to create an object");
            }
            fstTask.add(new Data(Integer.valueOf(separator[0]), Integer.valueOf(separator[1]), Integer.valueOf(separator[2]), Integer.valueOf(separator[3])));
            firstDataCreatorLogger.info("{} object has been created successfully", counter);
            counter++;
        }
        return fstTask;
    }
}
