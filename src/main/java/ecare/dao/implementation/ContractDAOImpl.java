package ecare.dao.implementation;

import ecare.dao.api.ContractDAO;
import ecare.MVC.entities.Contract;
import ecare.exceptions.ContractNotFoundException;
import ecare.exceptions.ContractsForEntityNotGotException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;

/**
 * Contract operations
 */
@Repository("Contract")
public class ContractDAOImpl extends GenericDAOImpl<Contract, Integer> implements ContractDAO {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Contract getContractByNumber(String phoneNumber) throws ContractNotFoundException {
        try {
            return (Contract) entityManager.createQuery("select c from Contract c where c.phoneNumber=:phone_number")
                    .setParameter("phone_number", phoneNumber).getSingleResult();
        } catch (PersistenceException e) {
            throw new ContractNotFoundException("Contract " + phoneNumber + " wasn't gotten", e);
        }
    }

    /**
     * Get all contracts that user has
     *
     * @param id id for getting
     * @return list of all contracts for adjusted user
     * @throws ContractsForEntityNotGotException if contract not found
     */
    @Override
    public List<Contract> getAllUserContracts(int id) throws ContractsForEntityNotGotException {
        try {
            Query query = entityManager.createQuery("select u.contracts from User u where u.userId=:id")
                    .setParameter("id", id);
            return (List<Contract>) query.getResultList();
        } catch (PersistenceException ex) {
            throw new ContractsForEntityNotGotException("Contracts for user " + id + " wasn't gotten", ex);
        }
    }

}
