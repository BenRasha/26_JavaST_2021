import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class SelectionSort implements Sorting{

    static final Logger selectionSortLogger = LogManager.getLogger(SelectionSort.class.getName());

    /**
     * Each pass selects the smallest element and moves it to the beginning. In this case, starts each new pass by moving
     * to the right, that is, the first pass - from the first element, the second pass - from the second.
     * @param array Array, which is going to be sorted
     * @param isIncreasing identifies, whether sorting is going to be increasing or decreasing
     * @return sorted Array
     * @throws ServiceException custom exception, which provides info to the other layers
     */
    @Override
    public Array sort(Array array, boolean isIncreasing) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            ArrayDAO arrayDAO = daoFactory.getArrayDAO();
            String source = "src/by.training.task03DecompositionLayeredArchitecture/resources/array.txt";
            arrayDAO.fillArrayFromFile(array, new File(source));
            selectionSortLogger.info("Method fillArrayFromFile(Array array, File file) has been invoked");
        } catch (DAOException e) {
            selectionSortLogger.error(new ServiceException("Error during array filling from file"));
            throw new ServiceException(e);
        }
        int length = array.getLength();
        for (int left = 0; left < length; left++) {
            if (isIncreasing) {
                int minInd = left;
                for (int i = left; i < length; i++) {
                    if (array.getValue(i) < array.getValue(minInd)) {
                        minInd = i;
                    }
                }
                array.swap(left, minInd);
            } else {
                int maxInd = left;
                for (int i = left; i < length; i++) {
                    if (array.getValue(i) > array.getValue(maxInd)) {
                        maxInd = i;
                    }
                }
                array.swap(left, maxInd);
            }
        }
        return array;
    }

}
