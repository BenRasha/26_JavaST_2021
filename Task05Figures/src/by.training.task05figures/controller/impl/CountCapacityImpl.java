public class CountCapacityImpl implements Command{

    @Override
    public double execute(String request, Pyramid pyramid) {
        double result = 0;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        FigureAction pyramidAction = serviceFactory.getPyramidAction();
        result = pyramidAction.countCapacity(pyramid);
        return result;
    }
}
