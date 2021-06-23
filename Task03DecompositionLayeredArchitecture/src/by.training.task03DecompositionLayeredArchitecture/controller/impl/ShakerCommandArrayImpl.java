import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShakerCommandArrayImpl implements CommandArray {

    static final Logger shakerCommandImplLogger = LogManager.getLogger(ShakerCommandArrayImpl.class.getName());

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
        Sorting shakerSort = serviceFactory.getShakerSorting();
        try {
            if (increasing.equals("increasing")) {
                shakerSort.sort(array, true);
                shakerCommandImplLogger.info("Method sort(Array array, boolean isIncreasing has been invoked");
            } else if(increasing.equals("decreasing")) {
                shakerSort.sort(array, false);
                shakerCommandImplLogger.info("Method sort(Array array, boolean isIncreasing has been invoked");
            } else {
                shakerCommandImplLogger.info("No such type of sort");
            }
        } catch (ServiceException e) {
            shakerCommandImplLogger.info("Error during shaker sorting", e);
        }
        return array;
    }
}
