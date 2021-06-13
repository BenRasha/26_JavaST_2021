import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertionCommandImpl implements Command {

    static final Logger insertionCommandImplLogger = LogManager.getLogger(InsertionCommandImpl.class.getName());

    /**
     * Fills array from file and if user inputs increasing - sorts in increasing way, if decreasing - in decreasing way.
     * @param request required command from user
     * @return sorted numbers
     */

    @Override
    public String execute(String request) {
        Array array = new Array();
        String response = null;
        String increasing = request.substring(request.indexOf(' ')).trim();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Sorting insertionSort = serviceFactory.getInsertionSort();
        try {
            if (increasing.equals("increasing")) {
                insertionSort.sort(array, true);
                insertionCommandImplLogger.info("Method sort(Array array, boolean isIncreasing has been invoked");
                response = array.toString();
            } else if(increasing.equals("decreasing")) {
                insertionSort.sort(array, false);
                insertionCommandImplLogger.info("Method sort(Array array, boolean isIncreasing has been invoked");
                response = array.toString();
            } else {
                insertionCommandImplLogger.info("No such type of sort");
                response = "No such type of sort";
            }
        } catch (ServiceException e) {
            insertionCommandImplLogger.info("Error during executing insertion sort");
            response = "Error during executing insertion sort";
        }
        return response;
    }
}
