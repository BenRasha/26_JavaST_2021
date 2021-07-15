public class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();
    private final MatrixDAO matrixDAOImpl = new MatrixDAOImpl();

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return instance;
    }

    public MatrixDAO getMatrixDAOImpl() {
        return matrixDAOImpl;
    }
}
