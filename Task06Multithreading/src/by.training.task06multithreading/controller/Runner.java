import java.io.File;
import java.util.concurrent.Semaphore;

public class Runner {
    public static void main(String[] args) throws DAOException{
        DAOFactory daoFactory = DAOFactory.getInstance();
        MatrixDAO matrixDAO = daoFactory.getMatrixDAOImpl();
        Matrix matrix = matrixDAO.createFromFile(new File("sizes.txt"), new File("matrixData.txt"));
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            Thread thread = new SemaphoreImpl(semaphore, i, matrix);
            thread.start();
        }
    }
}
