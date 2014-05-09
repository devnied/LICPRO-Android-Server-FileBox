/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.service.impl;

import fr.devnied.filebox.service.GenericService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Abstract class for all services
 *
 * @author julien
 * @param <T>
 * @param <ID>
 * @param <D>
 */
public abstract class AbstractGenericService<T, ID extends Serializable, D extends JpaRepository<T, ID>> implements
        GenericService<T, ID> {

    /**
     * Dao
     */
    private D dao;

    /**
     * Autowired dao at runtime
     *
     * @param dao the dao
     */
    @Autowired
    public void setDao(final D dao) {
        this.dao = dao;
    }

    /**
     * Get the Dao
     *
     * @return
     */
    protected D getDao() {
        return dao;
    }

    @Override
    public T findOne(final ID id) {
        return getDao().findOne(id);
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    public void delete(final T object) {
        getDao().delete(object);
    }

    @Override
    public void delete(final ID id) {
        getDao().delete(id);
    }

    @Override
    public T save(final T object) {
        return getDao().save(object);
    }

    @Override
    public Long count() {
        return getDao().count();
    }

    @Override
    public T saveAndFlush(final T pObject) {
        return getDao().saveAndFlush(pObject);
    }

}
