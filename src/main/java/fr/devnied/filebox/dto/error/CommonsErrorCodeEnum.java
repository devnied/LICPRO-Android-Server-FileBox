/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.dto.error;

/**
 * List of all error code
 *
 * @author julien
 */
public enum CommonsErrorCodeEnum {

    BAD_REQUEST("40000", "bad.request", null),
    USER_NOT_FOUND("40401", "user.not.found", "User not found"),
    TOKEN_INVALID("40402", "token.invalid", "Token invalid"),
    LOGIN_ALREADY_EXIST("60001", "login.exist", "Login exist"),
    UNKNOW_ERROR("50001", "unknown.error", "Unknown error");

    /**
     * Error code key
     */
    private final String errorMessageKey;

    /**
     * Default error message
     */
    private final String errorDefaultMessage;
    /**
     * Error code
     */
    private final String errorCode;

    /**
     * Default constructor
     *
     * @param pErrorCode error code
     * @param pErrorMessageKey message key
     * @param pErrorDefaultMessage default message
     */
    private CommonsErrorCodeEnum(final String pErrorCode, final String pErrorMessageKey, final String pErrorDefaultMessage) {
        this.errorMessageKey = pErrorMessageKey;
        this.errorCode = pErrorCode;
        this.errorDefaultMessage = pErrorDefaultMessage;
    }

    public String getErrorMessageKey() {
        return errorMessageKey;
    }

    public String getErrorDefaultMessage() {
        return errorDefaultMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

}
