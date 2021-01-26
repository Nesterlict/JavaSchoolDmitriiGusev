package ecare.services.api;


import ecare.MVC.entities.Options;
import ecare.exceptions.OptionsForEntityNotGotException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;


/**
 * Interface for OptionsService
 */
public interface OptionsService extends GenericService<Options, Integer> {

    /**
     * Getting options for current tariff
     *
     * @param id id for getting
     * @return list of all option for tariff
     * @throws OptionsForEntityNotGotException if option not found
     */
    public List<Options> getAllOptions(int id) throws OptionsForEntityNotGotException;

    /**
     * Getting option for current contract
     *
     * @param id if for getting
     * @return list of all options for contract
     * @throws OptionsForEntityNotGotException if option not found
     */
    public List<Options> getAllOptionsForContract(int id) throws OptionsForEntityNotGotException;

    /**
     * Getting required tariff options
     *
     * @param id id for getting
     * @return list of all joint options
     * @throws OptionsForEntityNotGotException if option not found
     */
    public List<Options> getAllRequiredOptions(int id) throws OptionsForEntityNotGotException;

    /**
     * Getting exclusive tariff options
     *
     * @param id id for getting
     * @return list of all impossible options
     * @throws OptionsForEntityNotGotException if option not found
     */
    public List<Options> getAllExclusiveOptions(int id) throws OptionsForEntityNotGotException;
}
