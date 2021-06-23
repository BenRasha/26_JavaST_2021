import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BubbleCommandArrayImpl implements CommandArray {

    static final Logger bubbleControllerImplLogger = LogManager.getLogger(BubbleCommandArrayImpl.class.getName());

    /**
     * Fills array from file and if user inputs increasing - sorts in increasing way, if decreasing - in decreasing way.
     * @param request required command from user
     * @return sorted numbers or an error if something went wrong
     */

    @Override
    public Array execute(String request) {
        Array array = new Array();
        String increasing = request.substring(request.indexOf(' ')).trim();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Sorting bubbleSort = serviceFactory.getBubbleSorting();
        try {
            if (increasing.equals("increasing")) {
                bubbleSort.sort(array, true);
                bubbleControllerImplLogger.info("Method sort(Array array, boolean isIncreasing has been invoked");
            } else if(increasing.equals("decreasing")) {
                bubbleSort.sort(array, false);
                bubbleControllerImplLogger.info("Method sort(Array array, boolean isIncreasing has been invoked");
            } else {
                bubbleControllerImplLogger.info("No such type of sort");
            }
        } catch (ServiceException e) {
            bubbleControllerImplLogger.info("Error during executing bubble sort");
        }
        return array;
    }
}
