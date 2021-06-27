import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;

public class ChangeWheelImpl implements Command{

    static final Logger changeWheelImplLogger = LogManager.getLogger(ChangeWheelImpl.class.getName());
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("text", Locale.getDefault());

    @Override
    public String execute(String request, Automobile automobile) {
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        AutomobileCreator automobileCreator = serviceFactory.getAutomobileCreator();
        try {
            automobileCreator.changeWheel(automobile);
            response = resourceBundle.getString("controller.impl.wheelChange");
        } catch (ServiceException e) {
            changeWheelImplLogger.info("Error during changing wheels");
            response = "Error during changing wheels";
        }
        return response;
    }

}
