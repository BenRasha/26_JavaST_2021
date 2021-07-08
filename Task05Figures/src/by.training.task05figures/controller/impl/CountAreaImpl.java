import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CountAreaImpl implements Command{

    static final Logger countAreaImplLogger = LogManager.getLogger(CountAreaImpl.class.getName());

    @Override
    public double execute(String request, Pyramid pyramid) {
        double result = 0;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        FigureAction pyramidAction = serviceFactory.getPyramidAction();
        try {
            result = pyramidAction.countArea(pyramid);
        } catch (ServiceException exception) {
            countAreaImplLogger.error("Error during counting area", exception);
        }
        return result;
    }
}
