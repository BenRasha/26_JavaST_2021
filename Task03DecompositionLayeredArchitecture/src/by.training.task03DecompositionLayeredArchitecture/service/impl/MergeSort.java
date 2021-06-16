import java.io.File;

public class MergeSort implements Sorting {

    /**
     * Calculates the delimiter - the position of the divisor. If the divisor can be divided into 2 parts,
     * then calls recursively sorting for the sections into which the divisor has split the array. Prepare an
     * additional buffer array in which places the sorted section.Places the cursor at the beginning of the section
     * to be sorted and begin to walk through each element of the empty array that we have prepared and fill it with
     * the smallest elements. If the element pointed to by the cursor is less than the element pointed to by the divisor,
     * places this element in the buffer array and shift the cursor. Otherwise, places the element pointed to by the
     * separator into the buffer array and shifts the separator. As soon as the separator goes beyond the boundaries
     * of the sorted area or we fill the entire array, the specified range is considered sorted.
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
            arrayDAO.fillArrayFromFile(array,new File(source));
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        int length = array.getLength();
        int[] source = new int[length];
        for (int i = 0; i < length; i++) {
            source[i] += array.getValue(i);
        }
        mergeSort(source, 0 , length - 1);
        if (!isIncreasing) {
            for (int i = 0; i < length; i++) {
                array.setValue(source[i], i);
            }
        } else {
            int counter = length - 1;
            for (int i = 0; i < length; i++) {
                array.setValue(source[counter], i);
                counter--;
            }
        }
        return array;
    }

    /**
     * Recursively sorts through two halves of the array
     * @param source resource array, which is split into two halves
     * @param left start of the sorting
     * @param right end of the sorting
     */
    private void mergeSort(int[] source, int left, int right) {
        int delimiter = left + ((right - left) / 2) + 1;
        if (delimiter > 0 && right > (left)) {
            mergeSort(source, left, delimiter - 1);
            mergeSort(source, delimiter, right);
        }
        int[] buffer = new int[right - left + 1];
        int cursor = left;
        for (int i = 0; i < buffer.length; i++) {
            if (delimiter > right || source[cursor] > source[delimiter]) {
                buffer[i] = source[cursor];
                cursor++;
            } else {
                buffer[i] = source[delimiter];
                delimiter++;
            }
        }
        System.arraycopy(buffer, 0, source, left, buffer.length);
    }

}
