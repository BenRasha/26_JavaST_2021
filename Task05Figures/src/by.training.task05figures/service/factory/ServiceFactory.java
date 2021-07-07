public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();
    private final FigureAction pyramidAction = new PyramidActionImpl();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public FigureAction getPyramidAction() {
        return pyramidAction;
    }
}
