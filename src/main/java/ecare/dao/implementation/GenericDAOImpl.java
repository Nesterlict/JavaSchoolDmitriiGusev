package ecare.dao.implementation;

import ecare.dao.api.GenericDAO;
import ecare.exceptions.CustomDAOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Generic Operations
 *
 * @param <E> entity type
 * @param <K> entity id type
 */
public abstract class GenericDAOImpl<E, K> implements GenericDAO<E, K> {
    protected Class<E> daoType;

    @PersistenceContext
    private EntityManager entityManager;

    public GenericDAOImpl() {
        daoType = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @Override
    public void create(E entity) throws CustomDAOException {
        try {
            entityManager.persist(entity);
        } catch (PersistenceException e) {
            throw new CustomDAOException("Entity wasn't created: " + entity, e);
        }
    }

    @Override
    public E read(K id) throws CustomDAOException {
        try {
            return (E) this.entityManager.find(daoType, id);
        } catch (PersistenceException e) {
            throw new CustomDAOException("Entity " + id + " wasn't found", e);
        }
    }

    @Override
    public void update(E entity) throws CustomDAOException {
        try {
            entityManager.merge(entity);
        } catch (PersistenceException e) {
            throw new CustomDAOException("Entity wasn't updated: " + entity, e);
        } catch (IllegalStateException e) {
            throw new CustomDAOException("Entity wasn't updated: " + entity, e);
        }

    }

    @Override
    public void delete(E entity) throws CustomDAOException {
        try {
            entityManager.remove(entityManager.merge(entity));
        } catch (PersistenceException e) {
            throw new CustomDAOException("Entity wasn't deleted: " + entity, e);
        }

    }

    @Override
    public List<E> getAll() throws CustomDAOException {
        try {
            return entityManager.createNamedQuery(daoType.getSimpleName() + ".getAll", daoType).getResultList();
        } catch (PersistenceException ex) {
            throw new CustomDAOException("Unable to get all entities of class " + daoType.getSimpleName(), ex);
        }
    }

}

