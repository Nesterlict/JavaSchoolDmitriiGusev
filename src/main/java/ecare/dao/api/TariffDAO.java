package ecare.dao.api;

import ecare.MVC.entities.Tariff;


/**
 * Interface for TariffDAO
 */
public interface TariffDAO extends GenericDAO<Tariff, Integer> {
    /**
     * Getting tariff entity by number
     *
     * @param title entity for getting
     * @return tariff with adjusted number
     */
    public Tariff getTariffByTitle(String title);
}
