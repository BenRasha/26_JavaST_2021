import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    public static void main(String[] args) throws DAOException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        MatrixDAO matrixDAO = daoFactory.getMatrixDAOImpl();
        Matrix matrix = matrixDAO.createFromFile(new File("sizes.txt"), new File("matrixData.txt"));
        int numberOfThreads = matrixDAO.getNumberOfThreads(new File("sizes.txt"));
        ReentrantLock lock = new ReentrantLock();
        Map<Integer, Integer> indexes = new ConcurrentHashMap<>();
        for (int i = 0; i < matrix.getHorizontalSize(); i++) {
            indexes.put(i,i);
        }
        do {
            for (int i = 0; i < numberOfThreads; i++) {
                Thread thread = new Thread(new LockerImpl(lock, matrix, indexes));
                thread.setName("Thread " + i);
                thread.start();
            }
        } while (!indexes.isEmpty());
        System.out.println(matrix);
    }
}
