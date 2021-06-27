import java.util.Locale;
import java.util.ResourceBundle;

public class DriveAutomobileImpl implements Command{

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
