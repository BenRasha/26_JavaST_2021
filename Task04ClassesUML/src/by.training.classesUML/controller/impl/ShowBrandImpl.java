public class ShowBrandImpl implements Command{

    @Override
    public String execute(String request) {
        String response = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        AutomobileCreator automobileCreator = serviceFactory.getAutomobileCreator();
        response = automobileCreator.printAutomobileBrand(CreateAutomobile.automobile);
        System.out.println("Brand of the automobile is " + CreateAutomobile.automobile.getBrand());
        return response;
    }

}
