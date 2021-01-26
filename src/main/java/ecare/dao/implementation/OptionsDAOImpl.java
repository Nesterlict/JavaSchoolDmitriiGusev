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
 * Access to options functionality
 */
@Repository("Options")
public class OptionsDAOImpl extends GenericDAOImpl<Options, Integer> implements OptionsDAO {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Getting options list of selected tariff
     *
     * @param id entity for getting options
     * @return list of all options for tariff
     * @throws OptionsForEntityNotGotException if option not found
     */
    @Override
    public List<Options> getAllOptionsForTariff(int id) throws OptionsForEntityNotGotException {
        try {
            Query query = entityManager.createQuery("select t.tariffId from Tariff t where t.tariffId=:id").setParameter("id", id);

            return (List<Options>) query.getResultList();
        } catch (PersistenceException ex) {
            throw new OptionsForEntityNotGotException("Options for tariff " + id + " not got", ex);
        }
    }

    /**
     * Getting tariff list for selected contract
     *
     * @param id entity for getting options
     * @return list of all contracts for selected contract
     * @throws OptionsForEntityNotGotException if option not found
     */
    @Override
    public List<Options> getAllOptionsForContract(int id) throws OptionsForEntityNotGotException {
        try {
            Query query = entityManager.createQuery("select c.usedOptions from Contract c where c.contractID=:id").setParameter("id", id);

            return (List<Options>) query.getResultList();
        } catch (PersistenceException ex) {
            throw new OptionsForEntityNotGotException("Options for contract " + id + " not got", ex);
        }
    }

    /**
     * Getting all required options
     *
     * @param id id for getting options
     * @return list of required options
     * @throws OptionsForEntityNotGotException if option not found
     */
    @Override
    public List<Options> getAllRequiredOptions(int id) throws OptionsForEntityNotGotException {
        try {
            Query query = entityManager.createQuery("select opt.connectionPrice from Options opt");

            return (List<Options>) query.getResultList();
        } catch (PersistenceException ex) {
            throw new OptionsForEntityNotGotException("Options for tariff " + id + " not got", ex);
        }
    }

    /**
     * Getting all exclusive options
     *
     * @param id if for getting options
     * @return list of impossible options
     * @throws OptionsForEntityNotGotException if option not found
     */
    @Override
    public List<Options> getAllExclusiveOptions(int id) throws OptionsForEntityNotGotException {
        try {
            Query query = entityManager.createQuery("select opt.exclusiveOptions from Options opt");

            return (List<Options>) query.getResultList();
        } catch (PersistenceException ex) {
            throw new OptionsForEntityNotGotException("Options for tariff " + id + " not got", ex);
        }
    }

    /**
     * Getting tariff option by name
     *
     * @param name entity for getting option
     * @return name of option
     */
    public Options getOptionsByName(String name) {
        try {
            Query query = entityManager.createQuery("select t from Options t where t.name=:name")
                    .setParameter("name", name);
            return (Options) query.getResultList().get(0);
        } catch (PersistenceException ex) {
            throw new UserNotFoundException("TariffOption with title " + name + " not found!", ex);
        }
    }
}
