import java.io.File;

public class MatrixCreator {

    public Matrix createMatrixFromFile(File sizes, File data) throws ServiceException {
        Matrix matrix;
        DAOFactory daoFactory = DAOFactory.getInstance();
        MatrixDAO matrixDAO = daoFactory.getMatrixDAOImpl();
        try {
            matrix = matrixDAO.createFromFile(sizes, data);
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
        return matrix;
    }

}
