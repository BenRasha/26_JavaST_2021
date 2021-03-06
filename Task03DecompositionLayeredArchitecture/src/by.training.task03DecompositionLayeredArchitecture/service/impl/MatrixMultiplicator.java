import java.io.File;

public class MatrixMultiplicator implements MatrixOperator{

    /**
     * Multiplies two matrices
     * @param p first Matrix to operate with
     * @param q second Matrix to operate with
     * @return result Matrix after multiplication
     * @throws ServiceException custom exception, which provides info to the other layers
     */
    @Override
    public Matrix completeOperation(Matrix p, Matrix q) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            MatrixDAO matrixDAO = daoFactory.getMatrixDAOImpl();
            String source = "src/by.training.task03DecompositionLayeredArchitecture/resources/matrix.txt";
            matrixDAO.createFromFile(p, new File(source));
            matrixDAO.createFromFile(q, new File(source));
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        int vertical = p.getVerticalSize();
        int horizontal = q.getHorizontalSize();
        int controlSize = p.getHorizontalSize();
        if (controlSize != q.getVerticalSize()) {
            throw new ServiceException("Incomplete matrices");
        }
        Matrix result;
        try {
            result = new Matrix(vertical, horizontal);
            for (int i = 0; i < vertical; i++) {
                for (int j = 0; j < horizontal; j++) {
                    int value = 0;
                    for (int k = 0; k < controlSize; k++) {
                        value += p.getValue(i, k) * q.getValue(k, j);
                    }
                    result.setValue(i, j, value);
                }
            }
        } catch (MatrixException e) {
            throw new ServiceException(e);
        }
        return result;
    }
}
