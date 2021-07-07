public class DAOException extends Exception{

    DAOException() {}

    DAOException(String message) {
        super(message);
    }

    DAOException(Exception exception) {
        super(exception);
    }

    DAOException(String message, Exception exception) {
        super(message, exception);
    }
}
