public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();
    private final MatrixCreator matrixCreator = new MatrixCreator();
    private final NumberOfThreadsCollector numberOfThreadsCollector = new NumberOfThreadsCollector();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public MatrixCreator getMatrixCreator() {
        return matrixCreator;
    }

    public NumberOfThreadsCollector getNumberOfThreadsCollector() {
        return numberOfThreadsCollector;
    }
}
