/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.service;

import fr.devnied.filebox.dto.response.FilesDto;
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
     * @param pToken
     * @return
     */
    FilesDto getFile(final String pToken, final long pDate);

    /**
     * Method used to get content of file
     *
     * @param pToken
     * @param pId
     * @return
     */
    Response getFile(final String pToken, final String pId, final long pDate);

}
