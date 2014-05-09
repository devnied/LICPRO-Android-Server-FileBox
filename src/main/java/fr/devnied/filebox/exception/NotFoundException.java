/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.exception;

import fr.devnied.filebox.dto.error.CommonsErrorCodeEnum;

/**
 * Not found exception
 *
 * @author julien
 */
public class NotFoundException extends AbstractException {

    /**
     * Constructor using field
     *
     * @param pErrorEnum enum error
     */
    public NotFoundException(final CommonsErrorCodeEnum pErrorEnum) {
        super(pErrorEnum);
    }

}
