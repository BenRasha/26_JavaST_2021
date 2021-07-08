import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CountCapacityImpl implements Command{

    static final Logger countCapacityImplLogger = LogManager.getLogger(CountCapacityImpl.class.getName());

    @Override
    public double execute(String request, Pyramid pyramid) {
        double result = 0;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        FigureAction pyramidAction = serviceFactory.getPyramidAction();
        try {
            result = pyramidAction.countCapacity(pyramid);
        } catch (ServiceException exception) {
            countCapacityImplLogger.error("Error during counting capacity", exception);
        }
        return result;
    }
}
