/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.rest.impl;

import fr.devnied.filebox.dto.response.FilesDto;
import fr.devnied.filebox.rest.IFileWs;
import fr.devnied.filebox.service.IFileService;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Customer webservice implementation
 *
 * @author julien
 */
@Component
@Provider
public class FileWsImpl implements IFileWs {

    /**
     * File Service
     */
    @Autowired
    private IFileService fileService;

    @Override
    public FilesDto getFile(String pToken, long pDate) {
        return fileService.getFile(pToken, pDate);
    }

    @Override
    public Response getFile(String pToken, String pId, long pDate) {
        return fileService.getFile(pToken, pId, pDate);
    }

}
