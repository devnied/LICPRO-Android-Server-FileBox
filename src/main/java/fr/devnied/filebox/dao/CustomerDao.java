/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.dao;

import fr.devnied.filebox.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Customer Dao
 *
 * @author julien
 */
@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {

    /**
     * Find customer with login
     *
     * @param login customer login
     * @return
     */
    @Query("SELECT cus"
            + " FROM Customer cus"
            + " WHERE cus.login = :login")
    Customer findCustomerLogin(@Param("login") String login);

    /**
     * Check if login existing
     *
     * @param login customer login to find
     * @return true if the login exist false otherwise
     */
    @Query("SELECT case when (count(cus.id) > 0) then true else false end"
            + " FROM Customer cus"
            + " WHERE cus.login = :login")
    boolean isLoginExist(@Param("login") String login);

    /**
     * Find customer with token
     *
     * @param pToken customer token
     * @return
     */
    @Query("SELECT cus"
            + " FROM Customer cus"
            + " WHERE cus.token = :token")
    Customer findCustomerByToken(@Param("token") String pToken);

}
