package ecare.dao.api;

import ecare.MVC.entities.User;
import ecare.exceptions.UserNotFoundException;

public interface UserDAO extends GenericDAO<User, Integer> {

    public User getUserByNumber(String number) throws UserNotFoundException;

    public User getUserByEMAil(String eMail) throws UserNotFoundException;

}
