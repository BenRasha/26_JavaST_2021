import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SubdividerCommandMatrixImpl implements CommandMatrix {

    static final Logger subdividerCommandImplLogger = LogManager.getLogger(SubdividerCommandMatrixImpl.class.getName());

    /**
     * Fills two matrices from the file and multiplies them
     * @param request required command from user
     * @return result Matrix of subdivision
     */
    @Override
    public Matrix execute(String request) {
        Matrix firstM = null;
        Matrix secondM = null;
        try {
            firstM = new Matrix(3,3);
            secondM = new Matrix(3,3);
        } catch (MatrixException e) {
            subdividerCommandImplLogger.info("Error during matrix creation");
        }
        Matrix result = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixOperator matrixSubdivider = serviceFactory.getMatrixSubdivider();
        try {
            result = matrixSubdivider.completeOperation(firstM, secondM);
            subdividerCommandImplLogger.info("Method completeOperation(Matrix p, Matrix q) has been invoked");
        } catch (ServiceException e) {
            subdividerCommandImplLogger.info("Error during find the residual of matrices");
        }
        return result;
    }
}
