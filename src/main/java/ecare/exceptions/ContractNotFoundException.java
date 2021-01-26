package ecare.exceptions;

/**
 * Exception for situation when contract is not available
 */
public class ContractNotFoundException extends CustomDAOException {
    /**
     * Exception with message for situation when contract is not available
     *
     * @param message message for exception
     */
    public ContractNotFoundException(String message) {
        super(message);
    }

    /**
     * Exception with message and throwable for situation when contract is not available
     *
     * @param message   message for exception
     * @param throwable object for message
     */
    public ContractNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
