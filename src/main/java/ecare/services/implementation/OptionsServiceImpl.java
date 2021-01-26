package ecare.services.implementation;


import ecare.dao.api.OptionsDAO;
import ecare.MVC.entities.Options;
import ecare.exceptions.CustomDAOException;
import ecare.exceptions.OptionsForEntityNotGotException;
import ecare.services.api.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("tariffOptionService")
public class OptionsServiceImpl implements OptionsService {

    @Autowired
    private OptionsDAO optionDAO;

    /**
     * Creating tariff option entity in base
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
     * Getting tariff option entity by id
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
     * Update tariff option entity in base
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
     * Deleting tariff option entity from base
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
     * getting all tariff option entity from base
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
     * Getting tariff option for current contract
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
     * Getting joint tariff options
     *
     * @param id id for getting
     * @return list of all joint options
     * @throws OptionsForEntityNotGotException if option not found
     */
    @Override
    @Transactional
    public List<Options> getAllRequiredOptions(int id) throws OptionsForEntityNotGotException {
        return optionDAO.getAllRequiredOptions(id);
    }

    /**
     * Getting impossible tariff options
     *
     * @param id id for getting
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
            return false;
        }
    }

}
