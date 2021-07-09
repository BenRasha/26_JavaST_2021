import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChangeWheelImpl implements Command{

    static final Logger changeWheelImplLogger = LogManager.getLogger(ChangeWheelImpl.class.getName());

    @Override
    public String execute(String request, Automobile automobile) {
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        AutomobileService automobileService = serviceFactory.getAutomobileCreator();
        try {
            automobileService.changeWheel(automobile);
            response = Runner.getMessageManager().getString("controller.impl.wheelChange");
        } catch (ServiceException e) {
            changeWheelImplLogger.info("Error during changing wheels");
            response = "Error during changing wheels";
        }
        return response;
    }

}
