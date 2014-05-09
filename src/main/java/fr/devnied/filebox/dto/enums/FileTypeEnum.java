/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.dto.enums;

/**
 * Enum of file type
 *
 * @author julien
 */
public enum FileTypeEnum {

    PDF("application/pdf"),
    MP3("audio/mpeg"),
    PNG("image/png"),
    HTML("text/html"),
    TEXT("text/plain"),
    VCARD("text/vcard");

    /**
     * File mime-type
     */
    private final String mimeType;

    /**
     * Default constructor
     *
     * @param pMimeType
     */
    private FileTypeEnum(String pMimeType) {
        mimeType = pMimeType;
    }

    public String getMimeType() {
        return mimeType;
    }

}
