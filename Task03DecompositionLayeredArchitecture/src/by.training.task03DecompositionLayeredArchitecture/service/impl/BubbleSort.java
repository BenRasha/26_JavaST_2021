import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class BubbleSort implements Sorting{

    static final Logger bubbleSortLogger = LogManager.getLogger(BubbleSort.class.getName());

    /**
     * Iterates through array and compares each element, and swaps them if condition suits
     * @param array Array, which is going to be sorted
     * @param isIncreasing identifies, whether sorting is going to be increasing or decreasing
     * @return sorted Array
     * @throws ServiceException custom exception, which provides info to the other layers
     */
    @Override
    public Array sort(Array array, boolean isIncreasing) throws ServiceException{
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            ArrayDAO arrayDAO = daoFactory.getArrayDAO();
            String source = "src/by.training.task03DecompositionLayeredArchitecture/resources/array.txt";
            arrayDAO.fillArrayFromFile(array, new File(source));
            bubbleSortLogger.info("Method fillArrayFromFile(Array array, File file) has been invoked");
        } catch (DAOException e) {
            bubbleSortLogger.error(new ServiceException("Error during filling array from file"));
            throw new ServiceException(e);
        }
        int length = array.getLength();
        for (int i = 0; i < length - 2; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (isIncreasing) {
                    if (array.getValue(j) > array.getValue(j + 1)) {
                        array.swap(j, j + 1);
                    }
                } else {
                    if (array.getValue(j) < array.getValue(j + 1)) {
                        array.swap(j , j + 1);
                    }
                }
            }
        }
        return array;
    }

}
