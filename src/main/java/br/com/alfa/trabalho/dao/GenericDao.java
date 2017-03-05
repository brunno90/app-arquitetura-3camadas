package br.com.alfa.trabalho.dao;

import br.com.alfa.trabalho.dao.exception.DAOException;
import br.com.alfa.trabalho.model.comum.AbstractModel;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericDao<T extends AbstractModel> implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    protected EntityManager manager;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(T entity) throws DAOException {
        try {
            manager.persist(entity);
        } catch (Exception ex) {
            throw new DAOException(ex);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void update(T entity) throws DAOException {
        try {
            manager.merge(entity);
        } catch (Exception ex) {
            throw new DAOException(ex);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(T entity) throws DAOException {
        try {
            manager.remove(getById(entity.getId()));
        } catch (Exception ex) {
            throw new DAOException(ex);
        }
    }

    public T getById(Long id) throws DAOException {
        T result = (T) manager.find(getTypeClass(), id);
        if (result == null) {
            throw new DAOException();
        }
        return result;
    }

    public List<T>  findAll() throws DAOException {
        List<T> resultList = manager.createQuery(("From " + getTypeClass().getName())).getResultList();
        if (resultList == null || resultList.size() < 1) {
            throw new DAOException();
        }
        return resultList;
    }

    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
        return clazz;
    }
}
