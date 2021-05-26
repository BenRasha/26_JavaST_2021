import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileOpener {

    /**
     * Opens resource file.
     * @param source is a way to the source file.
     * @return Scanner object which after can be used to read information
     */

    public Scanner readFile (String source) {
        FileReader fileReader = null;
        try {
            File file = new File(source);
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new Scanner(fileReader);
    }
}
