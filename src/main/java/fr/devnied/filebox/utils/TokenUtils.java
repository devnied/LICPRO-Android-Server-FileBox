/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.utils;

import java.util.UUID;

/**
 * Utils class used to manipulate token
 *
 * @author julien
 */
public final class TokenUtils {

    /**
     * Method used to get unique token
     *
     * @return an unique token
     */
    public static String getUniqueToken() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * Private constructor
     */
    private TokenUtils() {
    }

}
