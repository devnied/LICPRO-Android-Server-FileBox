/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.service;

import fr.devnied.filebox.dto.response.FilesDto;
import fr.devnied.filebox.model.Customer;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

/**
 * Customer webservice interface
 *
 * @author julien
 */
public interface IFileService {

    /**
     * Method used to get files from user token
     *
     * @param pToken customer token
     * @param pDate lastupdate date
     * @return
     */
    FilesDto getFile(final String pToken, final long pDate);

    /**
     * Method used to get content of file
     *
     * @param request request header
     * @param pToken customer token
     * @param pId file id
     * @param pDate lastupdate date
     * @return
     */
    Response getFile(final Request request, final String pToken, final String pId, final long pDate);

    /**
     * Method used to init file
     *
     * @param customer Customer
     */
    void initFile(final Customer customer);

}
