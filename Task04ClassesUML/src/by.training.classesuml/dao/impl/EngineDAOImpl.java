import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class EngineDAOImpl implements EngineDAO{

    private Engine engine;

    @Override
    public Engine createEngineFromFile(File file) throws DAOException {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        }catch (FileNotFoundException exception) {
            throw new DAOException("File was not found", exception);
        }
        try (Scanner scanner = new Scanner(fileReader)) {
            String[] split;
            while (scanner.hasNextLine()) {
                split = scanner.nextLine().split(" ");
                engine = new Engine(split[0], Double.parseDouble(split[1]), Boolean.parseBoolean(split[2]));
            }
        }
        return engine;
    }
}
