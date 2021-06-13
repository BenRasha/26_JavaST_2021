import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class MatrixMultiplicator implements MatrixOperator{

    static final Logger matrixMultiplicator = LogManager.getLogger(MatrixMultiplicator.class.getName());

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
            p = new Matrix(3,3);
            q = new Matrix(3,3);
            DAOFactory daoFactory = DAOFactory.getInstance();
            MatrixDAO matrixDAO = daoFactory.getMatrixDAOImpl();
            String source = "src/by.training.task03DecompositionLayeredArchitecture/resources/matrix.txt";
            matrixDAO.createFromFile(p, new File(source));
            matrixMultiplicator.info("Method createFromFile(Matrix matrix,File file) has been invoked");
            matrixDAO.createFromFile(q, new File(source));
            matrixMultiplicator.info("Method createFromFile(Matrix matrix,File file) has been invoked");
        } catch (DAOException | MatrixException e) {
            matrixMultiplicator.error(new ServiceException("Error during creating matrices and filling them"));
            throw new ServiceException(e);
        }
        int vertical = p.getVerticalSize();
        int horizontal = q.getHorizontalSize();
        int controlSize = p.getHorizontalSize();
        if (controlSize != q.getVerticalSize()) {
            throw new ServiceException("Incomplete matrices");
        }
        Matrix result = null;
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
            matrixMultiplicator.error(new ServiceException("Error creating result matrix"));
            throw new ServiceException(e);
        }
        return result;
    }
}
