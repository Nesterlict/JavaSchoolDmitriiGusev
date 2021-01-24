package ecare.exceptions;


public class CustomDAOException extends RuntimeException {

    public CustomDAOException(String message) {
        super(message);
    }

    public CustomDAOException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
