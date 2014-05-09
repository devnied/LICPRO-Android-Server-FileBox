/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.exception.handler;

import fr.devnied.filebox.dto.error.HttpExceptionDto;
import fr.devnied.filebox.exception.BusinessException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mapper for Business exception
 *
 * @author julien
 */
@Provider
public class BusinessExceptionHandler implements ExceptionMapper<BusinessException> {

    /**
     * Class logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessExceptionHandler.class);

    @Override
    public Response toResponse(BusinessException exception) {
        LOGGER.error(exception.toString());
        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new HttpExceptionDto(exception.getErrorEnum()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

}
