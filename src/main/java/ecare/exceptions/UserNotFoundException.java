package ecare.exceptions;

public class UserNotFoundException extends CustomDAOException {

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
