import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;

public class DriveAutomobileImpl implements Command{

    static final Logger driveAutomobileImplLogger = LogManager.getLogger(DriveAutomobileImpl.class.getName());
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("text", Locale.getDefault());

    @Override
    public String execute(String request, Automobile automobile) {
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        AutomobileCreator automobileCreator = serviceFactory.getAutomobileCreator();
        if (automobileCreator.drive(automobile)) {
            response = resourceBundle.getString("controller.impl.drivePositive");
        } else {
            response = resourceBundle.getString("controller.impl.driveNegative");
        }
        return response;
    }

}
