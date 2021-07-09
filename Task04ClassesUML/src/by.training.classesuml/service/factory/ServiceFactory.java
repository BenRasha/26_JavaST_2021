public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();
    private final AutomobileService automobileService = new AutomobileServiceImpl();
    private final GenerateToFileThenRead<Wheel> wheelGenerateThenReadGenerator = new WheelGenerateThenReadImpl();
    private final GenerateToFileThenRead<Engine> engineGenerateThenRead = new EngineGenerateThenReadImpl();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public AutomobileService getAutomobileCreator() {
        return automobileService;
    }

    public GenerateToFileThenRead<Wheel> getWheelGenerateThenReadGenerator() {
        return wheelGenerateThenReadGenerator;
    }

    public GenerateToFileThenRead<Engine> getEngineGenerateToFileThenRead() {
        return engineGenerateThenRead;
    }
}
