public interface Sorting {

    /**
     * Common interface for different types of sorting
     * @param array Array, which is going to be sorted
     * @param isIncreasing identifies, whether sorting is going to be increasing or decreasing
     * @return sorted Array
     * @throws ServiceException custom exception, which provides info to the other layers
     */
    public Array sort(Array array, boolean isIncreasing) throws ServiceException;

}
