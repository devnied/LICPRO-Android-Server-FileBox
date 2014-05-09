/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.exception.handler;

import fr.devnied.filebox.dto.error.CommonsErrorCodeEnum;
import fr.devnied.filebox.dto.error.HttpExceptionDto;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mapper for bad request exception
 *
 * @author julien
 */
@Provider
public class DefaultExceptionHandler implements ExceptionMapper<Throwable> {

    /**
     * Class logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @Override
    public Response toResponse(Throwable exception) {
        LOGGER.error(exception.getLocalizedMessage(), exception);
        return Response
                .serverError()
                .entity(new HttpExceptionDto(CommonsErrorCodeEnum.UNKNOW_ERROR))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

}
