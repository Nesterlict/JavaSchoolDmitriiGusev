package ecare.dao.api;

import ecare.MVC.entities.Options;
import ecare.exceptions.OptionsForEntityNotGotException;

import java.util.List;



/**
 * Interface for TariffOptionDAO
 */
public interface OptionsDAO extends GenericDAO<Options, Integer> {

    /**
     * Getting tariff option list of adjusted tariff
     *
     * @param id entity for getting
     * @return list of all tariff option for tariff
     * @throws OptionsForEntityNotGotException if option not found
     */
    public List<Options> getAllTariffOptionsForTariff(int id) throws OptionsForEntityNotGotException;

    /**
     * Getting tariff list for adjusted contract
     *
     * @param id entity for getting
     * @return list of all contracts for adjusted contract
     * @throws OptionsForEntityNotGotException if option not found
     */
    public List<Options> getAllTariffOptionsForContract(int id) throws OptionsForEntityNotGotException;

    /**
     * Getting all joint tariffs
     *
     * @param id id for getting
     * @return list of joint option
     * @throws OptionsForEntityNotGotException if option not found
     */
    public List<Options> getAllJointTariffOptions(int id) throws OptionsForEntityNotGotException;

    /**
     * Getting all joint tariffs
     *
     * @param id if for getting
     * @return list of impossible option
     * @throws OptionsForEntityNotGotException if option not found
     */
    public List<Options> getAllImpossibleTariffOptions(int id) throws OptionsForEntityNotGotException;

    /**
     * Getting tariff option by title
     *
     * @param title entity for getting
     * @return title of tariff option
     */
    public Options getTariffOptionByTitle(String title);


}
