/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.exception;

import fr.devnied.filebox.dto.error.CommonsErrorCodeEnum;

/**
 * Bad request exception
 *
 * @author julien
 */
public class BusinessException extends AbstractException {

    /**
     * Constructor using field
     *
     * @param pErrorEnum enum error
     */
    public BusinessException(final CommonsErrorCodeEnum pErrorEnum) {
        super(pErrorEnum);
    }

}
