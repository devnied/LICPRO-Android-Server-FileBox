/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.rest;

import fr.devnied.filebox.dto.response.TokenDto;
import javax.validation.constraints.Size;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
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
@Path("/customer")
public interface ICustomerWs {

    /**
     * Methode used to get a token for and existing user
     *
     * @param login user login
     * @param password user password
     * @return user token
     */
    @POST
    @Path("/token")
    @Produces(MediaType.APPLICATION_JSON)
    TokenDto getToken(
            @NotEmpty
            @Size(max = 20)
            @QueryParam("login")
            final String login,
            @NotEmpty
            @Size(max = 20)
            @QueryParam("password")
            final String password);

    /**
     * Methos used to add user
     *
     * @param login login
     * @param password password to add
     * @return response
     */
    @PUT
    Response addUser(
            @NotEmpty
            @Size(max = 20)
            @QueryParam("login")
            final String login,
            @NotEmpty
            @Size(max = 20)
            @QueryParam("password")
            final String password);

}
