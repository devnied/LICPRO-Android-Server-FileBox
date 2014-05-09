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
     * List all file for a customer
     *
     * @param id customer id
     * @param date last request date
     * @return
     */
    @Query("SELECT new fr.devnied.filebox.dto.commons.FileDto(file.name, file.hashId, file.isFolder, file.mimeType, file.lastModification)"
            + " FROM Customer cus"
            + " INNER JOIN cus.listFile file"
            + " WHERE cus.id = :id"
            + " AND file.lastModification > :date")
    List<FileDto> getListFile(@Param("id") Long id, @Param("date") Date date);

}
