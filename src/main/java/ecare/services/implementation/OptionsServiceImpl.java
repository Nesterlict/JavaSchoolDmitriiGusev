package ecare.services.implementation;


import ecare.dao.api.OptionsDAO;
import ecare.MVC.entities.Options;
import ecare.exceptions.CustomDAOException;
import ecare.exceptions.OptionsForEntityNotGotException;
import ecare.services.api.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


@Service("optionsService")
public class OptionsServiceImpl implements OptionsService {

    private final static Logger logger = LogManager.getLogger(OptionsServiceImpl.class);

    @Autowired
    private OptionsDAO optionDAO;

    /**
     * Creating option entity in base
     *
     * @param option entity for creating
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public void createEntity(Options option) throws CustomDAOException {
        if (!isOptionsExists(option))
            optionDAO.create(option);
    }

    /**
     * Getting option entity by id
     *
     * @param id id for getting
     * @return tariff option with adjusted id
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public Options getEntityById(Integer id) throws CustomDAOException {
        return optionDAO.read(id);
    }

    /**
     * Update option entity in base
     *
     * @param option entity for updating
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public void updateEntity(Options option) throws CustomDAOException {
        optionDAO.update(option);
    }

    /**
     * Deleting option entity from base
     *
     * @param option entity for deleting
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Override
    @Transactional
    public void deleteEntity(Options option) throws CustomDAOException {
        optionDAO.delete(option);
    }

    /**
     * getting all options entity from base
     *
     * @return list of all tariff option
     * @throws CustomDAOException if connect with DAO goes wrong
     */
    @Transactional
    public List<Options> getAll() throws CustomDAOException {
        return optionDAO.getAll();
    }

    /**
     * Getting tariff option for current tariff
     *
     * @param id id for getting
     * @return list of all option for tariff
     * @throws OptionsForEntityNotGotException if option not found
     */
    @Override
    @Transactional
    public List<Options> getAllOptions(int id) throws OptionsForEntityNotGotException {
        return optionDAO.getAllOptionsForTariff(id);
    }

    /**
     * Getting options for current contract
     *
     * @param id if for getting
     * @return list of all options for contract
     * @throws OptionsForEntityNotGotException if option not found
     */
    @Override
    @Transactional
    public List<Options> getAllOptionsForContract(int id) throws OptionsForEntityNotGotException {
        return optionDAO.getAllOptionsForContract(id);
    }

    /**
     * Getting required options
     *
     * @param id for getting
     * @return list of all required options
     * @throws OptionsForEntityNotGotException if option not found
     */
    @Override
    @Transactional
    public List<Options> getAllRequiredOptions(int id) throws OptionsForEntityNotGotException {
        return optionDAO.getAllRequiredOptions(id);
    }

    /**
     * Getting exclusive tariff options
     *
     * @param id for getting
     * @return list of all impossible options
     * @throws OptionsForEntityNotGotException if option not found
     */
    @Override
    @Transactional
    public List<Options> getAllExclusiveOptions(int id) throws OptionsForEntityNotGotException {
        return optionDAO.getAllExclusiveOptions(id);
    }

    /**
     * Checking tariff existing in base
     *
     * @param tariffOption entity for checking
     * @return true - if option exists, false - if doesn't
     */
    public boolean isOptionsExists(Options tariffOption) {
        try {
            return optionDAO.getOptionsByName(tariffOption.getName()) != null ? true : false;
        } catch (IndexOutOfBoundsException e) {
            logger.error(e);
            return false;
        }
    }

}
