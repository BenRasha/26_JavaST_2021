import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChangeWheelImpl implements Command{

    static final Logger changeWheelImplLogger = LogManager.getLogger(ChangeWheelImpl.class.getName());

    @Override
    public String execute(String request) {
        String response = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        AutomobileCreator automobileCreator = serviceFactory.getAutomobileCreator();
        try {
            automobileCreator.changeWheel(CreateAutomobile.automobile);
            response = "Wheels have been changed";
            System.out.println(CreateAutomobile.automobile.getWheels().toString());
        } catch (ServiceException e) {
            changeWheelImplLogger.info("Error during changing wheels");
            response = "Error during changing wheels";
        }
        return response;
    }

}
