import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOpener {

    /**
     * Opens resource file.
     * @param source is a way to the source file.
     * @return Scanner object which after can be used to read information
     */

    public List<String> readFile (String source) throws FileNotFoundException{
        File file = new File(source);
        FileReader fileReader = new FileReader(file);
        List<String> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNextLine()) {
                result.add(scanner.nextLine());
            }
        }
        return result;
    }
}
