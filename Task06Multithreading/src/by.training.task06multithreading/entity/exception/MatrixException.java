public class MatrixException extends Exception {

    public MatrixException() {}

    public MatrixException(String message) {
        super(message);
    }

    public MatrixException(Exception exception) {
        super(exception);
    }

    public MatrixException(String message, Exception exception) {
        super(exception);
    }

}
