package ecare.dao.api;

import ecare.MVC.entities.Options;
import ecare.exceptions.OptionsForEntityNotGotException;

import java.util.List;



/**
 * Interface for OptionsDAO
 */

public interface OptionsDAO extends GenericDAO<Options, Integer> {

    /**
     * Getting options list of adjusted tariff
     *
     * @param id entity for getting
     * @return list of all tariff option for tariff
     * @throws OptionsForEntityNotGotException if option not found
     */
    public List<Options> getAllOptionsForTariff(int id) throws OptionsForEntityNotGotException;

    /**
     * Getting tariff list for adjusted contract
     *
     * @param id entity for getting
     * @return list of all contracts for adjusted contract
     * @throws OptionsForEntityNotGotException if option not found
     */
    public List<Options> getAllOptionsForContract(int id) throws OptionsForEntityNotGotException;

    /**
     * Getting all joint tariffs
     *
     * @param id id for getting
     * @return list of joint option
     * @throws OptionsForEntityNotGotException if option not found
     */
    public List<Options> getAllRequiredOptions(int id) throws OptionsForEntityNotGotException;

    /**
     * Getting all impossible options
     *
     * @param id if for getting
     * @return list of impossible option
     * @throws OptionsForEntityNotGotException if option not found
     */
    public List<Options> getAllExclusiveOptions(int id) throws OptionsForEntityNotGotException;

    /**
     * Getting tariff option by name
     *
     * @param name entity for getting
     * @return name of tariff option
     */
    public Options getOptionsByName(String name);


}
