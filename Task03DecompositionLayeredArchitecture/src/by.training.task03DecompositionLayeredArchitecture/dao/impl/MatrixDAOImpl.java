import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MatrixDAOImpl implements MatrixDAO{

    @Override
    public void createFromFile(Matrix matrix, File f) throws DAOException {
        int rows = matrix.getVerticalSize();
        int columns = matrix.getHorizontalSize();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(f);
        } catch (FileNotFoundException e) {
            throw new DAOException("File was not found", e);
        }
        try (Scanner inputFile = new Scanner(fileReader)) {
            String[] line;
            while (inputFile.hasNextLine()) {
                for (int i = 0; i < rows; i++) {
                    line = inputFile.nextLine().split(" ");
                    for (int j = 0; j < columns; j++) {
                        matrix.setValue(i, j, Integer.parseInt(line[j]));
                    }
                }
            }
        } catch (NoSuchElementException | MatrixException exception) {
            throw new DAOException(exception);
        }
    }

}
