/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.rest;

import fr.devnied.filebox.dto.response.FilesDto;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Customer webservice interface
 *
 * @author julien
 */
@Path("/file")
public interface IFileWs {

    /**
     * Method used to get files from user token
     *
     * @param pToken
     * @param pTime timestap for the date
     * @return
     */
    @GET
    @Path("/{token}")
    @Produces(MediaType.APPLICATION_JSON)
    FilesDto getFile(@NotEmpty @PathParam("token") final String pToken,
            @QueryParam("date") final long pTime);

    /**
     * Method used to get content of file
     *
     * @param pToken
     * @param pId
     * @param pTime timestamp for the date
     * @return
     */
    @GET
    @Path("/{token}/{id}")
    Response getFile(@NotEmpty @PathParam("token") final String pToken,
            @NotEmpty @PathParam("id") final String pId,
            @QueryParam("date") final long pTime);

}
