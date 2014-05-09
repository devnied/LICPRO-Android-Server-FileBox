/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.exception.handler;

import fr.devnied.filebox.dto.error.HttpExceptionDto;
import fr.devnied.filebox.exception.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mapper for Not Found exception
 *
 * @author julien
 */
@Provider
public class NotFoundExceptionHandler implements ExceptionMapper<NotFoundException> {

    /**
     * Class logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(NotFoundExceptionHandler.class);

    @Override
    public Response toResponse(NotFoundException exception) {
        LOGGER.error(exception.toString());
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(new HttpExceptionDto(exception.getErrorEnum()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

}
