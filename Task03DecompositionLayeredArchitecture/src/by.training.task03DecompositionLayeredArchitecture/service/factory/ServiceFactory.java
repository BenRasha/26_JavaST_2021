public final class ServiceFactory {

    /**
     * Class which implements singletone and let's next layer access to it's classes without creating everytime new object
     */

    private static final ServiceFactory instance = new ServiceFactory();
    private final Sorting bubbleSorting = new BubbleSort();
    private final Sorting insertionSort = new InsertionSort();
    private final Sorting mergeSort = new MergeSort();
    private final Sorting selectionSort = new SelectionSort();
    private final Sorting shakerSorting = new ShakerSort();
    private final Sorting shellSort = new ShellSort();
    private final MatrixOperator matrixMultiplicator = new MatrixMultiplicator();
    private final MatrixOperator matrixSummator = new MatrixSummator();
    private final MatrixOperator matrixSubdivider = new MatrixSubdivider();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public Sorting getBubbleSorting() {
        return bubbleSorting;
    }

    public Sorting getInsertionSort() {
        return insertionSort;
    }

    public Sorting getMergeSort() {
        return mergeSort;
    }

    public Sorting getShakerSorting() {
        return shakerSorting;
    }

    public Sorting getSelectionSort() {
        return selectionSort;
    }

    public Sorting getShellSort() {
        return shellSort;
    }

    public MatrixOperator getMatrixMultiplicator() {
        return matrixMultiplicator;
    }

    public MatrixOperator getMatrixSummator() {
        return matrixSummator;
    }

    public MatrixOperator getMatrixSubdivider() {
        return matrixSubdivider;
    }
}
