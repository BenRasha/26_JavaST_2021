import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ArrayDAOImpl implements ArrayDAO {

    static final Logger arrayDAOImplLogger = LogManager.getLogger(ArrayDAOImpl.class.getName());

    @Override
    public Array fillArrayFromFile(Array array, File file) throws DAOException{
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException | NullPointerException exception) {
            arrayDAOImplLogger.error(new DAOException("File was not found"));
            throw new DAOException("File was not found", exception);
        }
        Scanner scanner = new Scanner(fileReader);
        String[] split;
        try {
            while (scanner.hasNextLine()) {
                split = scanner.nextLine().split(" ");
                for (String flag : split) {
                    array.getValues().add(Integer.parseInt(flag));
                }
            }
        } catch (NullPointerException e) {
            arrayDAOImplLogger.error(new DAOException("No elements were found"));
            throw new DAOException("No elements were found", e);
        } finally {
            scanner.close();
        }
        return array;
    }

    @Override
    public void addElement(Array array, int element) throws DAOException {
        array.getValues().add(element);
    }

    @Override
    public void deleteElement(Array array, int index) throws DAOException {
        array.getValues().remove(array.getValue(index));
    }
}