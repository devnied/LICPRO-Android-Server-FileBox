/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.dto.error;

import fr.devnied.filebox.dto.GenericDto;
import java.util.List;

/**
 * Dto for exception error
 *
 * @author julien
 */
public class HttpExceptionDto extends GenericDto {

    /**
     * Error code key
     */
    private String errorMessageKey;

    /**
     * Default error message
     */
    private String errorDefaultMessage;

    /**
     * Error code
     */
    private String errorCode;

    /**
     * List error detail
     */
    private List<String> listErrorDetail;

    /**
     * Default constructor
     */
    public HttpExceptionDto() {
    }

    /**
     *
     * @param pErrorCode
     */
    public HttpExceptionDto(final CommonsErrorCodeEnum pErrorCode) {
        errorCode = pErrorCode.getErrorCode();
        errorDefaultMessage = pErrorCode.getErrorDefaultMessage();
        errorMessageKey = pErrorCode.getErrorMessageKey();
    }

    /**
     *
     * @param pErrorCode
     * @param pDetails
     */
    public HttpExceptionDto(final CommonsErrorCodeEnum pErrorCode, final List<String> pDetails) {
        this(pErrorCode);
        listErrorDetail = pDetails;
    }

    public String getErrorMessageKey() {
        return errorMessageKey;
    }

    public void setErrorMessageKey(String errorMessageKey) {
        this.errorMessageKey = errorMessageKey;
    }

    public String getErrorDefaultMessage() {
        return errorDefaultMessage;
    }

    public void setErrorDefaultMessage(String errorDefaultMessage) {
        this.errorDefaultMessage = errorDefaultMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public List<String> getListErrorDetail() {
        return listErrorDetail;
    }

    public void setListErrorDetail(List<String> listErrorDetail) {
        this.listErrorDetail = listErrorDetail;
    }

}
