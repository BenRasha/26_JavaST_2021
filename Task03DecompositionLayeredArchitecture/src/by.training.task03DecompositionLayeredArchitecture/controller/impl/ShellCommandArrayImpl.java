import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShellCommandArrayImpl implements CommandArray {

    static final Logger shellCommandImplLogger = LogManager.getLogger(ShellCommandArrayImpl.class.getName());

    /**
     * Fills array from file and if user inputs increasing - sorts in increasing way, if decreasing - in decreasing way.
     * @param request required command from user
     * @return sorted array
     */

    @Override
    public Array execute(String request) {
        Array array = new Array();
        String increasing = request.substring(request.indexOf(' ')).trim();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Sorting shellSort = serviceFactory.getShellSort();
        try {
            if (increasing.equals("increasing")) {
                shellSort.sort(array, true);
                shellCommandImplLogger.info("Method sort(Array array, boolean isIncreasing has been invoked");
            } else if (increasing.equals("decreasing")) {
                shellSort.sort(array, false);
                shellCommandImplLogger.info("Method sort(Array array, boolean isIncreasing has been invoked");
            } else {
                shellCommandImplLogger.info("No such type of sort");
            }
        } catch (ServiceException e) {
            shellCommandImplLogger.info("Error during shell sorting", e);
        }
        return array;
    }
}
