import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class FifthDataCreator {

    final static Logger fifthDataCreatorLogger = LogManager.getLogger(FifthDataCreator.class.getName());
    ArrayList<Data>fifthTask = new ArrayList<>();

    public ArrayList<Data> createData (FileOpener fileOpener) {
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
