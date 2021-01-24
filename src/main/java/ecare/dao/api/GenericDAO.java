package ecare.dao.api;

import ecare.exceptions.CustomDAOException;

import java.util.List;


public interface GenericDAO<E, K> {

    public void create(E entity) throws CustomDAOException;

    public E read(K id) throws CustomDAOException;

    public void update(E entity) throws CustomDAOException;

    public void delete(E entity) throws CustomDAOException;

    public List<E> getAll() throws CustomDAOException;

}