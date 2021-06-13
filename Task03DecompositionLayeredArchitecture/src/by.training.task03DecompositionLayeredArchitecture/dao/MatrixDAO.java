import java.io.File;

public interface MatrixDAO {

    /**
     * Reads integers from the provided file and fills them into the values field of the Matrix
     * @param matrix provided Matrix, which is going to be filled
     * @param f provided File, from which we're reading
     * @throws DAOException custom exception, which provides info to the other layers
     */
    public void createFromFile(Matrix matrix, File f) throws DAOException;
}
