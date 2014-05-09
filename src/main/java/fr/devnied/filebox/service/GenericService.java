/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.service;

import java.io.Serializable;
import java.util.List;

/**
 * Interface for generic service
 *
 * @author julien
 * @param <T>
 * @param <ID>
 */
public interface GenericService<T, ID extends Serializable> {

    /**
     * Find object with id
     *
     * @param id object id
     * @return
     */
    T findOne(ID id);

    /**
     * Delete object
     *
     * @param object object to delete
     */
    void delete(T object);

    /**
     * Delete object with id
     *
     * @param id ID of object to delete
     */
    void delete(ID id);

    /**
     * Persist object
     *
     * @param object the object to persist
     * @return the persisted object
     */
    T save(T object);

    /**
     * Persist object and flush
     *
     * @param object the object to persist
     * @return the persisted object
     */
    T saveAndFlush(T object);

    /**
     * Count the number of record
     *
     * @return the number of records
     */
    Long count();

    /**
     * Find all records
     *
     * @return list of objects
     */
    List<T> findAll();

}
