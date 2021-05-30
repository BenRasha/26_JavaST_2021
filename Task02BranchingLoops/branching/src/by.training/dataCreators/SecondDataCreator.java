import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SecondDataCreator {

    static final Logger secondDataCreatorLogger = LogManager.getLogger(SecondDataCreator.class.getName());
    ArrayList<Data>secondTask = new ArrayList<>();

    /**
     * Used to create and validate data for the second task
     * @return array list with data, created using constructor with 2 parameters.
     * @throws NumbersException custom exception with constructor that's parsing String message.
     */

    public ArrayList<Data> createData () throws NumbersException, FileNotFoundException {
        String source = "C:\\26_JavaST_2021\\Task02BranchingLoops\\branching\\src\\by.training\\resources\\secondTask.txt";
        Scanner scanner = new FileOpener().readFile(source);
        String [] separator;
        int counter = 1;
        while (scanner.hasNextLine()) {
            separator = scanner.nextLine().split(" ");
            if (separator.length != 2) {
                secondDataCreatorLogger.error(new NumbersException("Not enough elements to create object"));
                throw new NumbersException("Not enough elements to create object");
            } else if (separator[0].equals(separator[1])) {
                secondDataCreatorLogger.error(new NumbersException("Elements can't be equal"));
                throw new NumbersException("Numbers can't be equal");
            }
            secondTask.add(new Data(Integer.valueOf(separator[0]), Integer.valueOf(separator[1])));
            secondDataCreatorLogger.info("{} object has been successfully created", counter);
            counter++;
        }
        return secondTask;
    }
}
