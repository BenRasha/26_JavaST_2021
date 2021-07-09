import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class WheelDAOImpl implements WheelDAO{

    private Wheel wheel;

    @Override
    public Wheel createWheelFromFile(File file) throws DAOException {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException exception) {
            throw new DAOException("File was not found", exception);
        }
        try (Scanner scanner = new Scanner(fileReader)){
            String[] split;
            while (scanner.hasNextLine()) {
                split = scanner.nextLine().split(" ");
                wheel = new Wheel(Double.parseDouble(split[0]), Double.parseDouble(split[1]), Boolean.parseBoolean(split[2]));
            }
        }
        return wheel;
    }
}
