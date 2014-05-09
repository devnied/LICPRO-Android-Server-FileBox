/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.exception;

import fr.devnied.filebox.dto.error.CommonsErrorCodeEnum;

/**
 * Abstract exception class
 *
 * @author julien
 */
public abstract class AbstractException extends RuntimeException {

    /**
     * Error enum
     */
    private final CommonsErrorCodeEnum errorEnum;

    /**
     * Constructor using field
     *
     * @param pErrorEnum enum error
     */
    protected AbstractException(final CommonsErrorCodeEnum pErrorEnum) {
        super();
        errorEnum = pErrorEnum;
    }

    public CommonsErrorCodeEnum getErrorEnum() {
        return errorEnum;
    }

    @Override
    public String toString() {
        return errorEnum.name();
    }

}
