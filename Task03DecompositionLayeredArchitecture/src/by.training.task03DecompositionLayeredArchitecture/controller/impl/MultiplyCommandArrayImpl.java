import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MultiplyCommandArrayImpl implements CommandMatrix {

    static final Logger multiplyCommandImplLogger = LogManager.getLogger(MultiplyCommandArrayImpl.class.getName());

    /**
     * Fills two matrices from the file and multiplies them
     * @param request required command from user
     * @return result Matrix of multiplying
     */
    @Override
    public Matrix execute(String request) {
        Matrix firstM = null;
        Matrix secondM = null;
        Matrix result = null;
        try {
            firstM = new Matrix(3,3);
            secondM = new Matrix(3,3);
        } catch (MatrixException e) {
            multiplyCommandImplLogger.error("Error creating matrices");
        }
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixOperator matrixMul = serviceFactory.getMatrixMultiplicator();
        try {
            result = matrixMul.completeOperation(firstM, secondM);
            multiplyCommandImplLogger.info("Method completeOperation(Matrix p, Matrix q) has been invoked");
        } catch (ServiceException e) {
            multiplyCommandImplLogger.info("Error during multiplying matrices");
        }
        return result;
    }
}
