package ecare.dao.implementation;

import ecare.dao.api.TariffDAO;
import ecare.MVC.entities.Tariff;
import ecare.exceptions.UserNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 * Access to tariff functionality
 */
@Repository("Tariff")
public class TariffDAOImpl extends GenericDAOImpl<Tariff, Integer> implements TariffDAO {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Getting tariff entity by number
     *
     * @param name entity for getting
     * @return tariff with adjusted number
     */
    public Tariff getTariffByName(String name) {
        try {
            Query query = entityManager.createQuery("select t from Tariff t where t.name=:name")
                    .setParameter("name", name);
            return (Tariff) query.getResultList().get(0);
        } catch (PersistenceException ex) {
            throw new UserNotFoundException("Tariff with title " + name + " not found!", ex);
        }
    }
}

