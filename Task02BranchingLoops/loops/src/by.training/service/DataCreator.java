import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataCreator {

    private List<Data> data = new ArrayList<>();
    private FileOpener fileOpener = new FileOpener();
    static final Logger dataCreatorLogger = LogManager.getLogger(DataCreator.class.getName());

    /**
     * Reads information from the file and creates data according to given pattern in Data class.
     * @return list of Data read from file.
     */

    public List<Data> createData() {
        Scanner scanner = new Scanner(fileOpener.parseResourceFile());
        int objectCounter = 1;
        String []separator;
        while (scanner.hasNextLine()) {
            separator = scanner.nextLine().split(" ");
            if (separator.length != 3) {
                dataCreatorLogger.error(new IllegalArgumentException("Not enough elements"));
                throw new IllegalArgumentException("Not enough elements");
            }
            data.add(new Data(Integer.parseInt(separator[0]), Integer.parseInt(separator[1]), Integer.parseInt(separator[2])));
            dataCreatorLogger.info("Object {} has been successfully created", objectCounter);
            objectCounter++;
        }
        return data;
    }

}
