public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();
    private final AutomobileCreator automobileCreator = new AutomobileCreatorImpl();
    private final GenerateToFileThenRead<Wheel> wheelGenerateThenReadGenerator = new WheelGenerateThenReadImpl();
    private final GenerateToFileThenRead<Engine> engineGenerateThenRead = new EngineGenerateThenReadImpl();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public AutomobileCreator getAutomobileCreator() {
        return automobileCreator;
    }

    public GenerateToFileThenRead<Wheel> getWheelGenerateThenReadGenerator() {
        return wheelGenerateThenReadGenerator;
    }

    public GenerateToFileThenRead<Engine> getEngineGenerateToFileThenRead() {
        return engineGenerateThenRead;
    }
}
