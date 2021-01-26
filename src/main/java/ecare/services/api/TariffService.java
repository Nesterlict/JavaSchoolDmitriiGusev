package ecare.services.api;

import ecare.MVC.entities.Tariff;


/**
 * Interface for TariffService
 */
public interface TariffService extends GenericService<Tariff, Integer> {

    /**
     * Getting tariff entity by title
     *
     * @param title entity for getting
     * @return tariff entity
     */
    public Tariff getTariffByName(String title);

    /**
     * Checking contract existing in base
     *
     * @param tariff entity for checking
     * @return true - if tariff exists, false if doesn't
     */
    public boolean isTariffExists(Tariff tariff);
}
