import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MatrixDAOImpl implements MatrixDAO {

    private static final String SPACE = " ";

    @Override
    public Matrix createFromFile(File sizes, File data) throws DAOException {
        Matrix matrix;
        int size;
        try (Scanner sizeReader = new Scanner(new FileReader(sizes))) {
            size = sizeReader.nextInt();
            matrix = new Matrix(size, size);
        } catch (FileNotFoundException exception) {
            throw new DAOException(exception);
        }
        try (Scanner dataReader = new Scanner(new FileReader(data))) {
            String[] split;
            while (dataReader.hasNextLine()) {
                for (int i = 0; i < size; i++) {
                    split = dataReader.nextLine().split(SPACE);
                    for (int j = 0; j < size; j++) {
                        matrix.setValue(i, j, Integer.parseInt(split[j]));
                    }
                }
            }
        } catch (FileNotFoundException | MatrixException exception) {
            throw new DAOException(exception);
        }
        return matrix;
    }
}
