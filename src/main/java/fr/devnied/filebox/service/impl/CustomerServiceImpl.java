/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.service.impl;

import fr.devnied.filebox.dao.CustomerDao;
import fr.devnied.filebox.dto.error.CommonsErrorCodeEnum;
import fr.devnied.filebox.dto.response.TokenDto;
import fr.devnied.filebox.exception.BusinessException;
import fr.devnied.filebox.exception.NotFoundException;
import fr.devnied.filebox.model.Customer;
import fr.devnied.filebox.service.ICustomerService;
import fr.devnied.filebox.service.IFileService;
import fr.devnied.filebox.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author julien
 */
@Service("customerService")
public class CustomerServiceImpl extends AbstractGenericService<Customer, Long, CustomerDao> implements ICustomerService {

    /**
     * Password encoder
     */
    @Autowired
    private StandardPasswordEncoder passwordEncoder;

    /**
     * File service
     */
    @Autowired
    private IFileService fileService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TokenDto getToken(String pLogin, String pPassword) {

        Customer customer = getDao().findCustomerLogin(pLogin);
        if (customer == null || !passwordEncoder.matches(pPassword, customer.getPassword())) {
            throw new NotFoundException(CommonsErrorCodeEnum.USER_NOT_FOUND);
        }

        String token = TokenUtils.getUniqueToken();
        customer.setToken(token);
        save(customer);

        return new TokenDto(token);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(String pLogin, String pPassword) {
        if (getDao().isLoginExist(pLogin)) {
            throw new BusinessException(CommonsErrorCodeEnum.LOGIN_ALREADY_EXIST);
        }

        Customer customer = new Customer();
        customer.setLogin(pLogin);
        customer.setPassword(passwordEncoder.encode(pPassword));
        save(customer);

        // init user files
        fileService.initFile(customer);
    }

    @Override
    public Customer findByToken(String pToken) {
        Customer cust = getDao().findCustomerByToken(pToken);
        if (cust == null) {
            throw new NotFoundException(CommonsErrorCodeEnum.USER_NOT_FOUND);
        }
        return cust;
    }

}
