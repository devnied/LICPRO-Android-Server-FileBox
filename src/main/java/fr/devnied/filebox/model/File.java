/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.model;

import fr.devnied.filebox.dto.enums.FileTypeEnum;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * File content entity
 *
 * @author julien
 */
@Entity
@Table(name = "FILE")
public class File extends AbstractEntity {

    /**
     * File Id
     */
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    /**
     * File name
     */
    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    /**
     * File id Hash
     */
    @Column(name = "HASH_ID", length = 150)
    private String hashId;

    /**
     * File length
     */
    @Column(name = "CONTENT_LENGTH")
    private Long contentLength;

    /**
     * Is folder
     */
    @Column(name = "IS_FOLDER", nullable = false)
    private Boolean isFolder;

    /**
     * Last modification date
     */
    @Column(name = "LAST_MODIFIACTION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModification;

    /**
     * File Mime type
     */
    @Column(name = "FILE_TYPE")
    @Enumerated(EnumType.STRING)
    private FileTypeEnum mimeType;

    /**
     * File content
     */
    @OneToOne(fetch = FetchType.EAGER, optional = true, cascade = {CascadeType.ALL})
    @JoinColumn(name = "FILE_CONTENT", nullable = true)
    private FileContent fileContent;

    /**
     * List file
     */
    @OneToMany(mappedBy = "folder", cascade = CascadeType.REMOVE)
    private List<File> listFile;

    /**
     * Customer
     */
    @ManyToOne
    @JoinColumn(name = "FOLDER_ID")
    private File folder;

    /**
     * Customer
     */
    @ManyToOne
    @JoinColumn(name = "ID_CUSTOMER")
    private Customer customer;

    @PrePersist
    @PreUpdate
    public void updateDate() {
        lastModification = new Date();
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getContentLength() {
        return contentLength;
    }

    public void setContentLength(Long contentLength) {
        this.contentLength = contentLength;
    }

    public Boolean isIsFolder() {
        return isFolder;
    }

    public void setIsFolder(Boolean isFolder) {
        this.isFolder = isFolder;
    }

    public Date getLastModification() {
        return lastModification;
    }

    public void setLastModification(Date lastModification) {
        this.lastModification = lastModification;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public FileContent getFileContent() {
        return fileContent;
    }

    public void setFileContent(FileContent fileContent) {
        this.fileContent = fileContent;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<File> getListFile() {
        return listFile;
    }

    public void setListFile(List<File> listFile) {
        this.listFile = listFile;
    }

    public File getFolder() {
        return folder;
    }

    public void setFolder(File folder) {
        this.folder = folder;
    }

    public FileTypeEnum getMimeType() {
        return mimeType;
    }

    public void setMimeType(FileTypeEnum mimeType) {
        this.mimeType = mimeType;
    }

}
