public class ServiceException extends Exception{
    ServiceException() {}

    public ServiceException(String message) {
        super(message);
    }
    public ServiceException(Exception e) {
        super(e);
    }
    public ServiceException(String message, Exception exception) {
        super(message, exception);
    }
}
