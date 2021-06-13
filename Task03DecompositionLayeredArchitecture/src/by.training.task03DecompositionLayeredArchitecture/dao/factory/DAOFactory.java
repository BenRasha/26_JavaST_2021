public final class DAOFactory {

    /**
     * Class which implements singletone and let's next layer access to it's classes without creating everytime new object
     */

    private static final  DAOFactory instance = new DAOFactory();
    private final ArrayDAO arrayDAOImpl = new ArrayDAOImpl();
    private final MatrixDAO matrixDAOImpl = new MatrixDAOImpl();

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return instance;
    }

    public ArrayDAO getArrayDAO() {
        return arrayDAOImpl;
    }

    public MatrixDAO getMatrixDAOImpl() {
        return matrixDAOImpl;
    }

}
