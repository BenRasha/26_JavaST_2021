import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShellCommandImpl implements Command {

    static final Logger shellCommandImplLogger = LogManager.getLogger(ShellCommandImpl.class.getName());

    /**
     * Fills array from file and if user inputs increasing - sorts in increasing way, if decreasing - in decreasing way.
     * @param request required command from user
     * @return sorted array
     */

    @Override
    public String execute(String request) {
        Array array = new Array();
        String response = null;
        String increasing = request.substring(request.indexOf(' ')).trim();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Sorting shellSort = serviceFactory.getShellSort();
        try {
            if (increasing.equals("increasing")) {
                shellSort.sort(array, true);
                shellCommandImplLogger.info("Method sort(Array array, boolean isIncreasing has been invoked");
                response = array.toString();
            } else if (increasing.equals("decreasing")) {
                shellSort.sort(array, false);
                shellCommandImplLogger.info("Method sort(Array array, boolean isIncreasing has been invoked");
                response = array.toString();
            } else {
                shellCommandImplLogger.info("No such type of sort");
                response = "No such type of sort";
            }
        } catch (ServiceException e) {
            shellCommandImplLogger.info("Error during shell sorting", e);
            response = "Error during shell sorting";
        }
        return response;
    }
}
