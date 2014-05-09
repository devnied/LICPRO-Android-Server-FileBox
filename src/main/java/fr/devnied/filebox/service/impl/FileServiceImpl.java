/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.service.impl;

import fr.devnied.filebox.dao.FileDao;
import fr.devnied.filebox.dto.commons.FileDto;
import fr.devnied.filebox.dto.response.FilesDto;
import fr.devnied.filebox.model.Customer;
import fr.devnied.filebox.model.File;
import fr.devnied.filebox.service.ICustomerService;
import fr.devnied.filebox.service.IFileService;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;

/**
 *
 * @author julien
 */
@Service("FileService")
public class FileServiceImpl extends AbstractGenericService<File, Long, FileDao> implements IFileService {

    /**
     * TextEncoder encryptor
     */
    @Autowired
    private TextEncryptor textEncryptor;

    @Autowired
    private ICustomerService customerService;

    @Override
    public FilesDto getFile(String pToken, long pDate) {
        Customer cust = customerService.findByToken(pToken);

        Date date = new Date(pDate);
        List<FileDto> list = getDao().getListFile(cust.getId(), date);
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
    public Response getFile(String pToken, String pId, long pDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
