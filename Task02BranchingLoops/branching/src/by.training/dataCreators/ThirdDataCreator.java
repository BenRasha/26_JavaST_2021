import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ThirdDataCreator {

    static final Logger thirdDataCreatorLogger = LogManager.getLogger(ThirdDataCreator.class.getName());
    ArrayList<Data>thirdTask = new ArrayList<>();

    /**
     * Used to create and validate data for the third task
     * @param fileOpener Scanner object, which let's read from file
     * @return array list with data, created using constructor with 2 parameters.
     * @throws NumbersException custom exception with constructor that's parsing String message.
     */

    public ArrayList<Data> createData (FileOpener fileOpener) throws NumbersException, FileNotFoundException {
        Scanner scanner = fileOpener.readFile("branching\\src\\by.training\\resources\\thirdTask.txt");
        String [] separator;
        int counter = 1;
        while (scanner.hasNextLine()) {
            separator = scanner.nextLine().split(" ");
            if (separator.length != 2) {
                thirdDataCreatorLogger.error(new NumbersException("Not enough elements to create object"));
                throw new NumbersException("Not enough elements to create object");
            } else if (Integer.valueOf(separator[0]) < 0 || Integer.valueOf(separator[0]) > 31) {
                thirdDataCreatorLogger.error(new NumbersException("Incorrect day date format"));
                throw new NumbersException("Incorrect day date format");
            } else if (Integer.valueOf(separator[1]) < 0 || Integer.valueOf(separator[1]) > 12) {
                thirdDataCreatorLogger.error(new NumbersException("Incorrect month date format"));
                throw new NumbersException("Incorrect month date format");
            }
            thirdTask.add(new Data(Integer.valueOf(separator[0]), Integer.valueOf(separator[1])));
            thirdDataCreatorLogger.info("{} object has been created successfully", counter);
            counter++;
        }
        return thirdTask;
    }
}
