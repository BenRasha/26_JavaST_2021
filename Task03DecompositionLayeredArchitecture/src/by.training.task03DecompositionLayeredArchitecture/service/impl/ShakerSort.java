import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class ShakerSort implements Sorting{

    static final Logger shakerSortLogger = LogManager.getLogger(ShakerSort.class.getName());

    /**
     * Each iteration of the algorithm is broken up into 2 stages:
     * The first stage loops through the array from left to right. During the loop, adjacent items are compared and if
     * value on the left is greater than the value on the right, then values are swapped. At the end of first iteration,
     * largest number will reside at the end of the array.
     * The second stage loops through the array in opposite direction- starting from the item just before the most
     * recently sorted item, and moving back to the start of the array. Here also, adjacent items are compared and are
     * swapped if required.
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
            shakerSortLogger.info("Method fillArrayFromFile(Array array, File file) has been invoked");
        } catch (DAOException e) {
            shakerSortLogger.error(new ServiceException("Error during filling array from file"));
            throw new ServiceException(e);
        }
        int length = array.getLength();
        int leftSide = 0;
        int rightSide = length - 1;
            do {
                if (isIncreasing) {
                    for (int i = leftSide; i < rightSide; i++) {
                        if (array.getValue(i) > array.getValue(i + 1)) {
                            array.swap(i, i + 1);
                        }
                    }
                    rightSide--;
                    for (int i = rightSide; i > leftSide; i--) {
                        if (array.getValue(i) < array.getValue(i - 1)) {
                            array.swap(i, i - 1);
                        }
                    }
                    leftSide++;
                } else {
                    for (int i = leftSide; i < rightSide; i++) {
                        if (array.getValue(i) < array.getValue(i + 1)) {
                            array.swap(i, i + 1);
                        }
                    }
                    rightSide--;
                    for (int i = rightSide; i > leftSide; i--) {
                        if (array.getValue(i) > array.getValue(i - 1)) {
                            array.swap(i, i - 1);
                        }
                    }
                    leftSide++;
                }
            } while (leftSide < rightSide);
            return array;
    }

}
