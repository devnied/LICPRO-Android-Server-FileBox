/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.dao;

import fr.devnied.filebox.dto.commons.FileDto;
import fr.devnied.filebox.model.File;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Customer Dao
 *
 * @author julien
 */
@Repository
public interface FileDao extends JpaRepository<File, Long> {

    /**
     * List all root files for a customer
     *
     * @param id customer id
     * @param date last request date
     * @param file
     * @return
     */
    @Query("SELECT new fr.devnied.filebox.dto.commons.FileDto(file.name, file.hashId, file.isFolder, file.mimeType, file.lastModification)"
            + " FROM Customer cus"
            + " INNER JOIN cus.listFile file"
            + " WHERE cus.id = :id"
            + " AND file.lastModification > :date"
            + " AND ( file.folder = :folder OR (:folder IS NULL AND file.folder IS NULL))")
    List<FileDto> getListFile(@Param("id") Long id, @Param("date") Date date, @Param("folder") File file);

    /**
     *
     * @param customerId
     * @param fileId
     * @return
     */
    @Query("SELECT case when (count(cus.id) > 0) then true else false end"
            + " FROM Customer cus"
            + " INNER JOIN cus.listFile file"
            + " WHERE cus.id = :customerId"
            + " AND file.id = :id"
            + " AND file.isFolder IS TRUE")
    boolean isFolder(@Param("customerId") Long customerId, @Param("id") Long fileId);

}
