/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.dto.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * Enum of file type
 *
 * @author julien
 */
public enum FileTypeEnum {

    PDF("application/pdf", "pdf"),
    MP3("audio/mpeg", "mp3"),
    JPEG("image/jpeg", "jpg"),
    PNG("image/png", "png"),
    HTML("text/html", "html"),
    TEXT("text/plain", "txt"),
    VCARD("text/vcard", "vcf");

    /**
     * File mime-type
     */
    private final String mimeType;

    /**
     * Extention
     */
    private final String ext;

    /**
     * Default constructor
     *
     * @param pMimeType
     */
    private FileTypeEnum(String pMimeType, String pExt) {
        mimeType = pMimeType;
        ext = pExt;
    }

    public String getMimeType() {
        return mimeType;
    }

    public static FileTypeEnum getType(String name) {
        FileTypeEnum ret = null;
        if (StringUtils.isNotBlank(name)) {
            for (FileTypeEnum type : FileTypeEnum.values()) {
                if (name.endsWith(type.ext)) {
                    ret = type;
                }
            }
        }
        return ret;
    }

}
