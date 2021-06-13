import java.io.File;

public interface ArrayDAO {

    /**
     * Reads integers from the provided file and fills them into the values field of the Array
     * @param array is a provided Array, which is gonna be filled from file.
     * @param file resource File, from which we're reading
     * @return filled with integers Array
     * @throws DAOException custom exception, which provides info to the other layers
     */
    public Array fillArrayFromFile(Array array, File file) throws DAOException;

    /**
     * Adds provided element to the end of the List of Integer values of an Array
     * @param array adds element to it's list of Integer values
     * @param element value, which we add
     * @throws DAOException custom exception, which provides info to the other layers
     */
    public void addElement(Array array, int element) throws DAOException;

    /**
     * Deletes value from List of Integer values of an Array by provided index
     * @param array deletes element from it's list
     * @param index index of element, which is going to be deleted
     * @throws DAOException custom exception, which provides info to the other layers
     */
    public void deleteElement(Array array, int index) throws DAOException;
}