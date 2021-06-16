import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ArrayDAOImpl implements ArrayDAO {

    @Override
    public Array fillArrayFromFile(Array array, File file) throws DAOException{
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException exception) {
            throw new DAOException("File was not found", exception);
        }
        try (Scanner scanner = new Scanner(fileReader)) {
            String[] split;
            while (scanner.hasNextLine()) {
                split = scanner.nextLine().split(" ");
                for (String flag : split) {
                    array.getValues().add(Integer.parseInt(flag));
                }
            }
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