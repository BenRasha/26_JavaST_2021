import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class InsertionSort implements Sorting{

    static final Logger insertionSortLogger = LogManager.getLogger(InsertionSort.class.getName());

    /**
     * Pulls out the value of the element in the start. Iterates through elements, which are located before the pulled out value.
     * If pulled out value is lower - moves the larger element further, if bigger - stops iterating. Inserts pulled out value into
     * vacant place.
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
            insertionSortLogger.info("Method fillArrayFromFile(Array array, File file) has been invoked");
        }catch (DAOException e) {
            insertionSortLogger.error(new ServiceException("Error during array filling from file"));
            throw new ServiceException(e);
        }
        int length = array.getLength();
        for (int left = 0; left < length; left++) {
            int value = array.getValue(left);
            int i = left - 1;
            for (; i >= 0; i--) {
                if (isIncreasing) {
                    if (value < array.getValue(i)) {
                        array.setValue(array.getValue(i), i + 1);
                    } else {
                        break;
                    }
                } else {
                    if (value < array.getValue(i)) {
                        break;
                    } else {
                        array.setValue(array.getValue(i), i + 1);
                    }
                }
            }
            array.setValue(value, i + 1);
        }
        return array;
    }

}
