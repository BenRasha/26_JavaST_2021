import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class ShellSort implements Sorting{

    static final Logger shellSortLogger = LogManager.getLogger(ShellSort.class.getName());

    /**
     * Is very similar to bubble sort, but after each iteration gap for iteration is halved.
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
            shellSortLogger.info("Method fillArrayFromFile(Array array, File file) has been invoked");
        } catch (DAOException e) {
            shellSortLogger.error(new ServiceException("Error during filling array from file"));
            throw new ServiceException(e);
        }
        int length = array.getLength();
        int gap = length / 2;
        while (gap >= 1) {
            for (int right = 0; right < length; right++) {
                for (int c = right - gap; c >= 0; c-=gap) {
                    if (isIncreasing) {
                        if (array.getValue(c) > array.getValue(c + gap)) {
                            array.swap(c, c + gap);
                        }
                    } else {
                        if (array.getValue(c) < array.getValue(c + gap)) {
                            array.swap(c, c + gap);
                        }
                    }
                }
            }
            gap = gap / 2;
        }
        return array;
    }

}
