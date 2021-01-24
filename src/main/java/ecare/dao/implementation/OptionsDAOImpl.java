package ecare.dao.implementation;

import ecare.dao.api.OptionsDAO;
import ecare.MVC.entities.Options;
import ecare.exceptions.OptionsForEntityNotGotException;
import ecare.exceptions.UserNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;


/**
 * Access to tariff option functionality
 */
@Repository("TariffOption")
public class OptionsDAOImpl extends GenericDAOImpl<Options, Integer> implements OptionsDAO {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Getting tariff option list of adjusted tariff
     *
     * @param id entity for getting
     * @return list of all tariff option for tariff
     * @throws OptionsForEntityNotGotException if option not found
     */
    @Override
    public List<Options> getAllTariffOptionsForTariff(int id) throws OptionsForEntityNotGotException {
        try {
            Query query = entityManager.createQuery("select t.tariffId from Tariff t where t.tariffId=:id").setParameter("id", id);

            return (List<Options>) query.getResultList();
        } catch (PersistenceException ex) {
            throw new OptionsForEntityNotGotException("Options for tariff " + id + " not got", ex);
        }
    }

    /**
     * Getting tariff list for adjusted contract
     *
     * @param id entity for getting
     * @return list of all contracts for adjusted contract
     * @throws OptionsForEntityNotGotException if option not found
     */
    @Override
    public List<Options> getAllTariffOptionsForContract(int id) throws OptionsForEntityNotGotException {
        try {
            Query query = entityManager.createQuery("select c.usedOptions from Contract c where c.contractID=:id").setParameter("id", id);

            return (List<Options>) query.getResultList();
        } catch (PersistenceException ex) {
            throw new OptionsForEntityNotGotException("Options for contract " + id + " not got", ex);
        }
    }

    /**
     * Getting all joint tariffs
     *
     * @param id id for getting
     * @return list of joint option
     * @throws OptionsForEntityNotGotException if option not found
     */
    @Override
    public List<Options> getAllJointTariffOptions(int id) throws OptionsForEntityNotGotException {
        try {
            Query query = entityManager.createQuery("select opt.connectionPrice from Options opt");

            return (List<Options>) query.getResultList();
        } catch (PersistenceException ex) {
            throw new OptionsForEntityNotGotException("Options for tariff " + id + " not got", ex);
        }
    }

    /**
     * Getting all joint tariffs
     *
     * @param id if for getting
     * @return list of impossible option
     * @throws OptionsForEntityNotGotException if option not found
     */
    @Override
    public List<Options> getAllImpossibleTariffOptions(int id) throws OptionsForEntityNotGotException {
        try {
            Query query = entityManager.createQuery("select opt.exclusiveOptions from Options opt");

            return (List<Options>) query.getResultList();
        } catch (PersistenceException ex) {
            throw new OptionsForEntityNotGotException("Options for tariff " + id + " not got", ex);
        }
    }

    /**
     * Getting tariff option by title
     *
     * @param name entity for getting
     * @return title of tariff option
     */
    public Options getTariffOptionByTitle(String name) {
        try {
            Query query = entityManager.createQuery("select t from Options t where t.name=:name")
                    .setParameter("name", name);
            return (Options) query.getResultList().get(0);
        } catch (PersistenceException ex) {
            throw new UserNotFoundException("TariffOption with title " + name + " not found!", ex);
        }
    }
}
