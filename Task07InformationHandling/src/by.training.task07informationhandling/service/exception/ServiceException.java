public class ServiceException extends Exception {

    ServiceException() {}

    ServiceException(String message) {
        super(message);
    }

    ServiceException(Exception exception) {
        super(exception);
    }

    ServiceException(String message, Exception exception) {
        super(message, exception);
    }
}
