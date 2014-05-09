/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.service;

import fr.devnied.filebox.dto.response.TokenDto;
import fr.devnied.filebox.model.Customer;

/**
 * Interface for user service
 *
 * @author julien
 */
public interface ICustomerService extends GenericService<Customer, Long> {

    /**
     * Method used to get a user with his logn password
     *
     * @param pLogin user login
     * @param pPassword user paswword
     * @return the token DTO
     */
    TokenDto getToken(final String pLogin, final String pPassword);

    /**
     * Method used to add Customer
     *
     * @param pLogin user login
     * @param pPassword user paswword
     */
    void add(final String pLogin, final String pPassword);

    /**
     * Find customer by token
     *
     * @param pToken token to find
     * @return the customer
     */
    Customer findByToken(String pToken);

}
