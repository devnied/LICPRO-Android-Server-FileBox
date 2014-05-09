/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.dto.commons;

import fr.devnied.filebox.dto.GenericDto;
import fr.devnied.filebox.dto.enums.FileTypeEnum;
import java.util.Date;

/**
 * File DTO
 *
 * @author julien
 */
public class FileDto extends GenericDto {

    /**
     * File name
     */
    private String name;

    /**
     * File id Hash
     */
    private String hashId;

    /**
     * Is folder
     */
    private Boolean isFolder;

    /**
     * File type
     */
    private FileTypeEnum fileType;

    /**
     * Last modification date
     */
    private Date lastModification;

    /**
     * Consctructor using field
     *
     * @param name
     * @param hashId
     * @param isFolder
     * @param mimeType
     * @param pDate
     */
    public FileDto(String name, String hashId, Boolean isFolder, FileTypeEnum mimeType, Date pDate) {
        this.name = name;
        this.hashId = hashId;
        this.isFolder = isFolder;
        this.fileType = mimeType;
        this.lastModification = pDate;
    }

    /**
     * Default constructor
     */
    public FileDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public Boolean isIsFolder() {
        return isFolder;
    }

    public void setIsFolder(Boolean isFolder) {
        this.isFolder = isFolder;
    }

    public FileTypeEnum getFileType() {
        return fileType;
    }

    public void setFileType(FileTypeEnum fileType) {
        this.fileType = fileType;
    }

    public Date getLastModification() {
        return lastModification;
    }

    public void setLastModification(Date lastModification) {
        this.lastModification = lastModification;
    }

}
