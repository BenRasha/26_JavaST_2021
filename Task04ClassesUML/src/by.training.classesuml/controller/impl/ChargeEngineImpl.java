import java.util.Locale;
import java.util.ResourceBundle;

public class ChargeEngineImpl implements Command{

    private ResourceBundle resourceBundle = ResourceBundle.getBundle("text", Locale.getDefault());

    @Override
    public String execute(String request, Automobile automobile) {
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        AutomobileCreator automobileCreator = serviceFactory.getAutomobileCreator();
        automobileCreator.chargeEngine(automobile);
        response = resourceBundle.getString("controller.impl.chargeEngine");
        return response;
    }

}
