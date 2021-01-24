package ecare.dao.implementation;

import ecare.dao.api.UserDAO;
import ecare.MVC.entities.User;
import ecare.dao.implementation.GenericDAOImpl;
import ecare.exceptions.UserNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Repository("userDAO")
public class UserDAOImpl extends GenericDAOImpl<User, Integer> implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Getting user entity by number
     *
     * @param number entity for getting
     * @return user with adjusted number
     * @throws UserNotFoundException if user not found
     */

    @Override
    public User getUserByNumber(String number) throws UserNotFoundException {
        try {
            Query query = entityManager.createQuery("select c.user from Contract c where c.phoneNumber=:phoneNumber")
                    .setParameter("phoneNumber", number);
            return (User) query.getSingleResult();
        } catch (PersistenceException e) {
            throw new UserNotFoundException("User " + number + " wasn't found", e);
        }

    }

    /**
     * Getting user entity by email
     *
     * @param email entity for getting
     * @return user with adjusted number
     * @throws UserNotFoundException if user not found
     */
    @Override
    public User getUserByEMAil(String email) throws UserNotFoundException {
        try {
            Query query = entityManager.createQuery("select u from User u where u.email=:email")
                    .setParameter("email", email);
            return (User) query.getSingleResult();
        } catch (PersistenceException ex) {
            throw new UserNotFoundException("User with email " + email + " not found!", ex);
        }

    }


}
