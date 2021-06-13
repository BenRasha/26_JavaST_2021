import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SelectionCommandImpl implements Command {

    static final Logger selectionCommandImplLogger = LogManager.getLogger(SelectionCommandImpl.class.getName());

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
        Sorting selectionSort = serviceFactory.getSelectionSort();
        try {
            if (increasing.equals("increasing")) {
                selectionSort.sort(array, true);
                selectionCommandImplLogger.info("Method sort(Array array, boolean isIncreasing has been invoked");
                response = array.toString();
            } else if(increasing.equals("decreasing")) {
                selectionSort.sort(array, false);
                selectionCommandImplLogger.info("Method sort(Array array, boolean isIncreasing has been invoked");
                response = array.toString();
            } else {
                selectionCommandImplLogger.info("No such type of sort");
                response = "No such type of sort";
            }
        } catch (ServiceException e) {
            selectionCommandImplLogger.info("Error during selection sort", e);
            response = "Error during selection sort";
        }
        return  response;
    }
}
