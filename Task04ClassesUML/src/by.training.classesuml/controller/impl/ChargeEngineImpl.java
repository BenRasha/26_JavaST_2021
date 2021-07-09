public class ChargeEngineImpl implements Command{

    @Override
    public String execute(String request, Automobile automobile) {
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        AutomobileService automobileService = serviceFactory.getAutomobileCreator();
        automobileService.chargeEngine(automobile);
        response = Runner.getMessageManager().getString("controller.impl.chargeEngine");
        return response;
    }

}
