import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOpener {

    /**
     * Opens and prepares file for reading.
     * @return String list, with provided path to the source file
     */

    public List<String> parseResourceFile() {
        File file = new File("C:\\26_JavaST_2021\\Task02BranchingLoops\\loops\\src\\by.training.loops\\resources\\dataForTasks.txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        List<String> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNextLine()) {
                result.add(scanner.nextLine());
            }
        }
        return result;
    }
}
