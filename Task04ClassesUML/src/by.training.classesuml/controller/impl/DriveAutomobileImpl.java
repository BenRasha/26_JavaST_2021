public class DriveAutomobileImpl implements Command{

    @Override
    public String execute(String request, Automobile automobile) {
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        AutomobileService automobileService = serviceFactory.getAutomobileCreator();
        if (automobileService.isDrivable(automobile)) {
            response = Runner.getMessageManager().getString("controller.impl.drivePositive");
        } else {
            response = Runner.getMessageManager().getString("controller.impl.driveNegative");
        }
        return response;
    }

}
