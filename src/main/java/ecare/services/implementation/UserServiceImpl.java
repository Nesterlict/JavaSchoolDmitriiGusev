package ecare.services.implementation;


import ecare.dao.api.UserDAO;
import ecare.MVC.entities.User;
import ecare.exceptions.CustomDAOException;
import ecare.exceptions.UserNotFoundException;
import ecare.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDAO userDAO;

    /**
     * Creating contract user in base
     *
     * @param user entity for creating
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public void createEntity(User user) throws CustomDAOException {
        if (!isUserExists(user)) {
            userDAO.create(user);
        }
    }

    /**
     * Get user entity by id
     *
     * @param id id for getting
     * @return user with adjusted id
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public User getEntityById(Integer id) throws CustomDAOException {
        return userDAO.read(id);
    }

    /**
     * Update user entity in base
     *
     * @param entity entity for updating
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public void updateEntity(User entity) throws CustomDAOException {
        userDAO.update(entity);
    }

    /**
     * Delete user entity from base
     *
     * @param entity entity for deleting
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public void deleteEntity(User entity) throws CustomDAOException {
        userDAO.delete(entity);
    }

    /**
     * Getting all user entities from base
     *
     * @return list of all users
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public List<User> getAll() throws CustomDAOException {
        return userDAO.getAll();

    }

    /**
     * Getting user entity by number
     *
     * @param number entity for getting
     * @return user with adjusted number
     * @throws UserNotFoundException if user not found
     */
    @Override
    @Transactional
    public User getUserByNumber(String number) throws UserNotFoundException {
        return userDAO.getUserByNumber(number);
    }

    /**
     * Getting user entity by email
     *
     * @param eMail entity for getting
     * @return user with adjusted email
     * @throws UserNotFoundException if user not found
     */
    @Override
    @Transactional
    public User getUserByEMAil(String eMail) throws UserNotFoundException {
        return userDAO.getUserByEMAil(eMail);
    }

    /**
     * Checking user existing in base
     *
     * @param user entity for checking
     * @return true - if user exists, false if doesn't
     */
    public boolean isUserExists(User user) {
        try {
            return getUserByEMAil(user.getEmail()) != null ? true : false;
        } catch (UserNotFoundException ex) {
            logger.error(ex);
            return false;
        }
    }

}
