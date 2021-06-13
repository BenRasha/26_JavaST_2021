import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SubdividerCommandImpl implements Command{

    static final Logger subdividerCommandImplLogger = LogManager.getLogger(SubdividerCommandImpl.class.getName());

    /**
     * Fills two matrices from the file and multiplies them
     * @param request required command from user
     * @return result Matrix of subdivision
     */
    @Override
    public String execute(String request) {
        Matrix firstM = new Matrix();
        Matrix secondM = new Matrix();
        String response = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixOperator matrixSubdivider = serviceFactory.getMatrixSubdivider();
        try {
            Matrix result = matrixSubdivider.completeOperation(firstM, secondM);
            subdividerCommandImplLogger.info("Method completeOperation(Matrix p, Matrix q) has been invoked");
            response = result.toString();
        } catch (ServiceException e) {
            response = "Error during find the residual of matrices";
        }
        return response;
    }
}
