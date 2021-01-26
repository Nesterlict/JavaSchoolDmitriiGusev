package ecare.dao.api;

import ecare.MVC.entities.User;
import ecare.exceptions.UserNotFoundException;

/**
 * Interface for UserDAO
 */
public interface UserDAO extends GenericDAO<User, Integer> {

    /**
     * Getting user by phone number
     *
     * @param number phone number
     * @return user with selected number
     * @throws UserNotFoundException if user not found
     */
    public User getUserByNumber(String number) throws UserNotFoundException;

    /**
     * Getting user by email
     *
     * @param eMail user email
     * @return user with selected email
     * @throws UserNotFoundException is user not found
     */
    public User getUserByEMAil(String eMail) throws UserNotFoundException;

}
