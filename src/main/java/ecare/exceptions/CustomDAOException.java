package ecare.exceptions;

/**
 * Exception for situation when operation with entities couldn't be executed
 */
public class CustomDAOException extends RuntimeException {

    /**
     * Exception with message for situation when something goes wrong on DAO
     *
     * @param message message for exception
     */
    public CustomDAOException(String message) {
        super(message);
    }

    /**
     * Exception with message and throwable for situation when something goes wrong on DAO
     *
     * @param message   message for exception
     * @param throwable object for exception
     */
    public CustomDAOException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
