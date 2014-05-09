/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.dto.response;

import fr.devnied.filebox.dto.error.HttpExceptionDto;

/**
 * Dto for user token
 *
 * @author julien
 */
public class TokenDto extends HttpExceptionDto {

    /**
     * User token
     */
    private String token;

    public TokenDto() {
    }

    public TokenDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
