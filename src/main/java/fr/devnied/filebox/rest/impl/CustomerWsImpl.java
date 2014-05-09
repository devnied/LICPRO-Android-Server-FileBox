/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.rest.impl;

import fr.devnied.filebox.dto.response.TokenDto;
import fr.devnied.filebox.rest.ICustomerWs;
import fr.devnied.filebox.service.ICustomerService;
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
public class CustomerWsImpl implements ICustomerWs {

    /**
     * Customer Service
     */
    @Autowired
    private ICustomerService userService;

    @Override
    public TokenDto getToken(String login, String password) {
        return userService.getToken(login, password);
    }

    @Override
    public Response addUser(String login, String password) {
        userService.add(login, password);
        return Response.status(Response.Status.CREATED).build();
    }

}
