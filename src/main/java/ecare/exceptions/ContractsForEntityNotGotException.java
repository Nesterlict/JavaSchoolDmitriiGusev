package ecare.exceptions;


/**
 * Exception for situation when contract for user is not available
 */
public class ContractsForEntityNotGotException extends CustomDAOException {
    /**
     * Exception with message for situation when user's contract is not available
     *
     * @param message message for exception
     */
    public ContractsForEntityNotGotException(String message) {
        super(message);
    }

    /**
     * Exception with message and throwable for situation when user's contract is not available
     *
     * @param message   for exception
     * @param throwable object for exception
     */
    public ContractsForEntityNotGotException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
