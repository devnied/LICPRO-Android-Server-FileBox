/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.exception.handler;

import fr.devnied.filebox.dto.error.CommonsErrorCodeEnum;
import fr.devnied.filebox.dto.error.HttpExceptionDto;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.jboss.resteasy.api.validation.ResteasyConstraintViolation;
import org.jboss.resteasy.api.validation.ResteasyViolationException;

/**
 *
 * @author julien
 */
@Provider
public class ValidationExceptionHandler implements ExceptionMapper<ResteasyViolationException> {

    @Override
    public Response toResponse(ResteasyViolationException exception) {

        List<String> listViolations = new ArrayList<>();
        StringBuilder violations = new StringBuilder();

        // Get violations
        for (ResteasyConstraintViolation violation : exception.getViolations()) {
            violations.append(" value:'").append(violation.getValue()).append("' - ").append(violation.getMessage());
            listViolations.add(violations.toString());
            violations.setLength(0);
        }

        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(new HttpExceptionDto(CommonsErrorCodeEnum.BAD_REQUEST, listViolations))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

}
