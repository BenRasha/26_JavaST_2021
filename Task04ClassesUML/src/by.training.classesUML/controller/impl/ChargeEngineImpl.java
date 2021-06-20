public class ChargeEngineImpl implements Command{

    @Override
    public String execute(String request) {
        String response = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        AutomobileCreator automobileCreator = serviceFactory.getAutomobileCreator();
        automobileCreator.chargeEngine(CreateAutomobile.automobile);
        response = "Engine has been charged";
        System.out.println(CreateAutomobile.automobile.getEngine().toString());
        return response;
    }

}
