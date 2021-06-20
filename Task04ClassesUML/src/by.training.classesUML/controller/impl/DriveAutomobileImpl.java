public class DriveAutomobileImpl implements Command{

    @Override
    public String execute(String request) {
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        AutomobileCreator automobileCreator = serviceFactory.getAutomobileCreator();
        if (automobileCreator.drive(CreateAutomobile.automobile)) {
            response = "You can drive safely";
        } else {
            response = "You should change your wheels or charge engine";
            System.out.println(CreateAutomobile.automobile.toString());
        }
        return response;
    }

}
