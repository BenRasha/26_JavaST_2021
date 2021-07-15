import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

    static final Logger runnerLogger = LogManager.getLogger(Runner.class.getName());

    public static void main(String[] args) {
        Matrix matrix = null;
        int numberOfThreads = 0;
        int matrixSize = 0;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixCreator matrixCreator = serviceFactory.getMatrixCreator();
        NumberOfThreadsCollector numberOfThreadsCollector = serviceFactory.getNumberOfThreadsCollector();
        try {
            matrix = matrixCreator.createMatrixFromFile(new File("sizes.txt"), new File("matrixData.txt"));
            matrixSize = matrix.getHorizontalSize();
            numberOfThreads = numberOfThreadsCollector.collectNumberOfThreads(new File("sizes.txt"));
        } catch (ServiceException exception) {
            runnerLogger.error(exception);
        }
        ReentrantLock lock = new ReentrantLock();
        Map<Integer, Integer> indexes = new ConcurrentHashMap<>();
        for (int i = 0; i < matrixSize; i++) {
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
