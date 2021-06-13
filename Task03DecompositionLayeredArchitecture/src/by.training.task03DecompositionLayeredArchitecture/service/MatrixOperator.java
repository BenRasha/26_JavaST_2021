public interface MatrixOperator {

    /**
     * Common interface, which let's execution of simple math operation with matrices: multiplying, sum , subdivision
     * @param p first Matrix to operate with
     * @param q second Matrix to operate with
     * @return result Matrix after the operation
     * @throws ServiceException custom exception, which provides info to the other layers
     */
    public Matrix completeOperation(Matrix p, Matrix q) throws ServiceException;
}
