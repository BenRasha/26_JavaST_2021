public class DAOFactory {

    private static DAOFactory instance = new DAOFactory();
    private final FigureDAO pyramidDAO = new PyramidDAOImpl();

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return instance;
    }

    public FigureDAO getPyramidDAO() {
        return pyramidDAO;
    }
}
