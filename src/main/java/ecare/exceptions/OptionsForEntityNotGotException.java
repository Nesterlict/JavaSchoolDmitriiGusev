package ecare.exceptions;



/**
 * Exception for situation when option for entity  couldn't be found
 */
public class OptionsForEntityNotGotException extends CustomDAOException {
    /**
     * Exception with message for situation when entity has incorrect state
     *
     * @param message message for exception
     */
    public OptionsForEntityNotGotException(String message) {
        super(message);
    }

    /**
     * exception with message and throwable for situation when entity has incorrect state
     *
     * @param message   message for exception
     * @param throwable object for exception
     */
    public OptionsForEntityNotGotException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
