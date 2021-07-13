public class CountAreaImpl implements Command{

    @Override
    public double execute(String request, Pyramid pyramid) {
        double result = 0;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        FigureAction pyramidAction = serviceFactory.getPyramidAction();
        result = pyramidAction.countArea(pyramid);
        return result;
    }
}
