import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class SecondDataCreator {

    static final Logger secondDataCreatorLogger = LogManager.getLogger(SecondDataCreator.class.getName());
    ArrayList<Data>secondTask = new ArrayList<>();

    public ArrayList<Data> createData (FileOpener fileOpener) throws NumbersException {
        Scanner scanner = fileOpener.readFile("branching\\src\\by.training\\resources\\secondTask.txt");
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
