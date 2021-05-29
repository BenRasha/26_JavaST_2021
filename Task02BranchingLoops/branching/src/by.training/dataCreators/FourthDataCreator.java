import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FourthDataCreator {

    final static Logger fourthDataCreator = LogManager.getLogger(FourthDataCreator.class.getName());
    ArrayList<Data>fourthTask = new ArrayList<>();

    /**
     * Used to create and validate data for the fourth task.
     * @param fileOpener Scanner object, which let's read from file.
     * @return array list of data, created using constructor with 3 parameters.
     * @throws NumbersException custom exception with constructor that parses String message
     */

    public ArrayList<Data> createData (FileOpener fileOpener) throws NumbersException, FileNotFoundException {
        Scanner scanner = fileOpener.readFile("branching\\src\\by.training\\resources\\fourthTask.txt");
        String [] separator;
        int counter = 1;
        while (scanner.hasNextLine()) {
            separator = scanner.nextLine().split(" ");
            if (separator.length != 3) {
                fourthDataCreator.error(new NumbersException("Not enough elements to create object"));
                throw new NumbersException("Not enough elements to create object");
            } else if (Integer.valueOf(separator[0]) < 0 || Integer.valueOf(separator[1]) < 0 || Integer.valueOf(separator[2]) < 0) {
                fourthDataCreator.error(new NumbersException("Incorrect number format"));
                throw new NumbersException("Incorrect number format");
            }
            fourthTask.add(new Data(Integer.valueOf(separator[0]), Integer.valueOf(separator[1]), Integer.valueOf(separator[2])));
            fourthDataCreator.info("{} object has been created successfully", counter);
            counter++;
        }
        return fourthTask;
    }
}
