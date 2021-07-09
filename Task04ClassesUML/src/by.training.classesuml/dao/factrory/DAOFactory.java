public class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();
    private final WheelDAO wheelDAO = new WheelDAOImpl();
    private final EngineDAO engineDAO = new EngineDAOImpl();
    private final DataGenerator dataGenerator = new DataGeneratorDAOImpl();
    private final AutomobileDAO automobileDAO = new AutomobileDAOImpl();

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return instance;
    }

    public WheelDAO getWheelDAO() {
        return wheelDAO;
    }

    public EngineDAO getEngineDAO() {
        return engineDAO;
    }

    public DataGenerator getDataGenerator() {
        return dataGenerator;
    }

    public AutomobileDAO getAutomobileDAO() {
        return automobileDAO;
    }
}
