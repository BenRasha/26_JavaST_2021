import java.io.File;

public class NumberOfThreadsCollector {

    public int collectNumberOfThreads(File sizes) throws ServiceException {
        int numberOfThreads;
        DAOFactory daoFactory = DAOFactory.getInstance();
        MatrixDAO matrixDAO = daoFactory.getMatrixDAOImpl();
        try {
            numberOfThreads = matrixDAO.getNumberOfThreads(sizes);
        } catch (DAOException exception) {
            throw new ServiceException();
        }
        return numberOfThreads;
    }

}
