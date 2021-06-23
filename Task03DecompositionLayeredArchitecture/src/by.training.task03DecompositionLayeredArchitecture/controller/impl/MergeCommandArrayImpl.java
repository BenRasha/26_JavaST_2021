import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MergeCommandArrayImpl implements CommandArray {

    static final Logger mergeCommandImplLogger = LogManager.getLogger(MergeCommandArrayImpl.class.getName());

    /**
     * Fills array from file and if user inputs increasing - sorts in increasing way, if decreasing - in decreasing way.
     * @param request required command from user
     * @return sorted numbers
     */

    @Override
    public Array execute(String request) {
        Array array = new Array();
        String increasing = request.substring(request.indexOf(' ')).trim();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Sorting mergeSort = serviceFactory.getMergeSort();
        try {
            if (increasing.equals("increasing")) {
                mergeSort.sort(array, true);
                mergeCommandImplLogger.info("Method sort(Array array, boolean isIncreasing has been invoked");
            } else if(increasing.equals("decreasing")) {
                mergeSort.sort(array, false);
                mergeCommandImplLogger.info("Method sort(Array array, boolean isIncreasing has been invoked");
            } else {
                mergeCommandImplLogger.info("No such type of sort");
            }
        } catch (ServiceException e) {
            mergeCommandImplLogger.info("Error during merge sorting", e);
        }
        return array;
    }
}
