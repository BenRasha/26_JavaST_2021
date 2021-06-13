public class MatrixException extends Exception {
    public MatrixException() {
    }
    public MatrixException(String message) {
        super(message);
    }
    public MatrixException(String message, Exception e) {
        super(message, e);
    }
    public MatrixException(Exception e) {
        super(e);
    }
}
