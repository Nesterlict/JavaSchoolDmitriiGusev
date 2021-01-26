package ecare.services.api;

import ecare.MVC.entities.User;
import ecare.exceptions.UserNotFoundException;


/**
 * Interface for UserService
 */
public interface UserService extends GenericService<User, Integer> {

    /**
     * Getting user entity by number
     *
     * @param number entity for getting
     * @return user with adjusted number
     * @throws UserNotFoundException if user not found
     */
    public User getUserByNumber(String number) throws UserNotFoundException;

    /**
     * Getting user entity by email
     *
     * @param eMail entity for getting
     * @return user with adjusted email
     * @throws UserNotFoundException if user not found
     */
    public User getUserByEMAil(String eMail) throws UserNotFoundException;

}
