import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MultiplyCommandImpl implements Command{

    static final Logger multiplyCommandImplLogger = LogManager.getLogger(MultiplyCommandImpl.class.getName());

    /**
     * Fills two matrices from the file and multiplies them
     * @param request required command from user
     * @return result Matrix of multiplying
     */
    @Override
    public String execute(String request) {
        Matrix firstM = null;
        Matrix secondM = null;
        try {
            firstM = new Matrix(3,3);
            secondM = new Matrix(3,3);
        } catch (MatrixException e) {
            multiplyCommandImplLogger.error("Error creating matrices");
        }
        String response = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixOperator matrixMul = serviceFactory.getMatrixMultiplicator();
        try {
            response = matrixMul.completeOperation(firstM, secondM).toString();
            multiplyCommandImplLogger.info("Method completeOperation(Matrix p, Matrix q) has been invoked");
        } catch (ServiceException e) {
            response = "Error during multiplying matrices";
        }
        return response;
    }
}
