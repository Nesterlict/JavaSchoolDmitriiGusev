package ecare.dao.api;

import ecare.MVC.entities.Contract;
import ecare.exceptions.ContractNotFoundException;
import ecare.exceptions.ContractsForEntityNotGotException;

import java.util.List;


/**
 * Interface for ContractDAO
 */
public interface ContractDAO extends GenericDAO<Contract, Integer> {

    /**
     * Get contract by number
     *
     * @param number entity for getting
     * @return contract with adjusted number
     * @throws ContractNotFoundException if contract not found
     */
    public Contract getContractByNumber(String number) throws ContractNotFoundException;

    /**
     * Get all contracts that user has
     *
     * @param id id for getting
     * @return list of all contracts for adjusted user
     * @throws ContractsForEntityNotGotException if contract not found
     */
    public List<Contract> getAllUserContracts(int id) throws ContractsForEntityNotGotException;

}
