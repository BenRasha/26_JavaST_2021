import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SummatorCommandImpl implements Command{

    static final Logger summatorCommandImplLogger = LogManager.getLogger(SummatorCommandImpl.class.getName());

    /**
     * Fills two matrices from the file and multiplies them
     * @param request required command from user
     * @return result Matrix of sum two matrices
     */
    @Override
    public String execute(String request) {
        Matrix firstM = null;
        Matrix secondM = null;
        try {
            firstM = new Matrix(3,3);
            secondM = new Matrix(3,3);
        } catch (MatrixException e) {
            summatorCommandImplLogger.info("Error during creating matrices");
        }
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixOperator matrixSum = serviceFactory.getMatrixSummator();
        try {
            Matrix result = matrixSum.completeOperation(firstM, secondM);
            summatorCommandImplLogger.info("Method completeOperation(Matrix p, Matrix q) has been invoked");
            response = result.toString();
        } catch (ServiceException e) {
            response = "Error during finding sum matrices";
        }
        return response;
    }
}
