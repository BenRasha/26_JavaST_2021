import java.io.File;

public interface MatrixDAO {

    Matrix createFromFile(File sizes, File data) throws DAOException;
    int getNumberOfThreads(File sizes) throws DAOException;
}
