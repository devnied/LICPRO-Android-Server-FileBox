/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.service.impl;

import fr.devnied.filebox.dao.FileDao;
import fr.devnied.filebox.dto.commons.FileDto;
import fr.devnied.filebox.dto.enums.FileTypeEnum;
import fr.devnied.filebox.dto.error.CommonsErrorCodeEnum;
import fr.devnied.filebox.dto.response.FilesDto;
import fr.devnied.filebox.exception.NotFoundException;
import fr.devnied.filebox.model.Customer;
import fr.devnied.filebox.model.File;
import fr.devnied.filebox.model.FileContent;
import fr.devnied.filebox.service.ICustomerService;
import fr.devnied.filebox.service.IFileService;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author julien
 */
@Service("FileService")
public class FileServiceImpl extends AbstractGenericService<File, Long, FileDao> implements IFileService {

    /**
     * TextEncoder encryptor
     */
    @Qualifier("textEncryptor")
    @Autowired
    private TextEncryptor textEncryptor;

    @Autowired
    private ICustomerService customerService;

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public FilesDto getFile(String pToken, long pDate) {
        Customer cust = customerService.findByToken(pToken);
        return listFiles(pDate, cust.getId(), null);
    }

    private FilesDto listFiles(long pDate, Long customerId, File folder) {
        Date date = new Date(pDate);
        List<FileDto> list = getDao().getListFile(customerId, date, folder);
        FilesDto dto = new FilesDto(list);
        // update last modification date
        if (list != null) {
            for (FileDto file : list) {
                if (date.before(file.getLastModification())) {
                    date = file.getLastModification();
                }
            }
        }
        dto.setpLastUpdate(date);
        return dto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public Response getFile(Request request, String pToken, String pId, long pDate) {
        Customer cust = customerService.findByToken(pToken);
        Long fileId = null;
        try {
            fileId = Long.parseLong(textEncryptor.decrypt(pId));
        } catch (Exception e) {
            throw new NotFoundException(CommonsErrorCodeEnum.FILE_NOT_FOUND);
        }

        // check is the file is a folder
        if (getDao().isFolder(cust.getId(), fileId)) {
            File f = new File();
            f.setId(fileId);
            return Response.ok(listFiles(pDate, cust.getId(), f)).type(MediaType.APPLICATION_JSON).build();
        }

        File file = getDao().getOne(fileId);
        if (file == null) {
            throw new NotFoundException(CommonsErrorCodeEnum.FILE_NOT_FOUND);
        }

        CacheControl cc = new CacheControl();
        cc.setMaxAge(172_800);

        EntityTag etag = new EntityTag(String.valueOf(file.getLastModification().getTime()));

        Response.ResponseBuilder rb = request.evaluatePreconditions(etag);

        if (rb != null) {
            return rb.cacheControl(cc).tag(etag).build();
        }

        final byte[] data = file.getFileContent().getContent();

        rb = Response.ok(new StreamingOutput() {
            /**
             * {@inheritDoc}
             */
            @Override
            public void write(final OutputStream pOutputStream) throws IOException {
                pOutputStream.write(data);
            }
        }, file.getMimeType().getMimeType()).cacheControl(cc).tag(etag).lastModified(file.getLastModification());
        return rb.build();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void initFile(Customer customer) {
        java.io.File[] files = new java.io.File(FileServiceImpl.class.getResource("/documents").getFile()).listFiles();

        for (java.io.File file : files) {

            File f = new File();
            f.setCustomer(customer);
            f.setName(file.getName());
            if (file.isDirectory()) {
                f.setIsFolder(true);
            } else {
                f.setIsFolder(false);
                f.setContentLength(file.length());
                f.setMimeType(FileTypeEnum.getType(file.getName()));
                try {
                    FileContent content = new FileContent();
                    content.setContent(FileUtils.readFileToByteArray(file));
                    f.setFileContent(content);
                } catch (IOException ex) {
                    Logger.getLogger(FileServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            save(f);
            f.setHashId(textEncryptor.encrypt(String.valueOf(f.getId())));
            save(f);

        }
    }

}
