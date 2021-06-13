import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class MatrixSummator implements MatrixOperator {

    static final Logger matrixSummatorLogger = LogManager.getLogger(MatrixSummator.class.getName());

    /**
     * Finds sum of the elements of two matrices
     * @param p first Matrix to operate with
     * @param q second Matrix to operate with
     * @return result Matrix with summed elements
     * @throws ServiceException custom exception, which provides info to the other layers
     */
    @Override
    public Matrix completeOperation(Matrix p, Matrix q) throws ServiceException {
        try {
            p = new Matrix(3, 3);
            q = new Matrix(3, 3);
            DAOFactory daoFactory = DAOFactory.getInstance();
            MatrixDAO matrixDAO = daoFactory.getMatrixDAOImpl();
            String source = "src/by.training.task03DecompositionLayeredArchitecture/resources/matrix.txt";
            matrixDAO.createFromFile(p, new File(source));
            matrixSummatorLogger.info("Method createFromFile(Matrix matrix,File file) has been invoked");
            matrixDAO.createFromFile(q, new File(source));
            matrixSummatorLogger.info("Method createFromFile(Matrix matrix,File file) has been invoked");
        } catch (DAOException | MatrixException e) {
            matrixSummatorLogger.error(new ServiceException("Error during creating and filling matrices"));
            throw new ServiceException(e);
        }
        int pVertical = p.getVerticalSize();
        int pHorizontal = p.getHorizontalSize();
        int qVertical = q.getVerticalSize();
        int qHorizontal = q.getHorizontalSize();
        if (pVertical != qVertical || pHorizontal != qHorizontal) {
            matrixSummatorLogger.error(new ServiceException("Not the same matrices"));
            throw new ServiceException("Not same matrix");
        }
        Matrix result = null;
        try {
            result = new Matrix(pVertical, pHorizontal);
            for (int i = 0; i < pVertical; i++) {
                for (int j = 0; j < pHorizontal; j++) {
                    int value = p.getValue(i, j) + q.getValue(i, j);
                    result.setValue(i, j, value);
                }
            }
        } catch (MatrixException e) {
            matrixSummatorLogger.error(new ServiceException("Error during result matrix creation"));
            throw new ServiceException(e);
        }
        return result;
    }

}
