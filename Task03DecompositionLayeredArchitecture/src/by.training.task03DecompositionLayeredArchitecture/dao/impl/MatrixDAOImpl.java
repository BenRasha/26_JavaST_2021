import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MatrixDAOImpl implements MatrixDAO{

    static final Logger matrixDAOImpl = LogManager.getLogger(MatrixDAOImpl.class.getName());

    @Override
    public void createFromFile(Matrix matrix, File f) throws DAOException {
        int rows = matrix.getVerticalSize();
        int columns = matrix.getHorizontalSize();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(f);
        } catch (FileNotFoundException e) {
            matrixDAOImpl.error("File was not found");
            throw new DAOException("File was not found", e);
        }
        Scanner inputFile = new Scanner(fileReader);
        String[] line;
        while (inputFile.hasNextLine()) {
            try {
                for (int i = 0; i < rows; i++) {
                    line = inputFile.nextLine().split(" ");
                    for (int j = 0; j < columns; j++) {
                        matrix.setValue(i, j, Integer.parseInt(line[j]));
                    }
                }
            } catch (NoSuchElementException | MatrixException exception) {
                matrixDAOImpl.error(new DAOException("No elements were found"));
                throw new DAOException();
            }
        }
    }

}
