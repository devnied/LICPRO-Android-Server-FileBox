/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Customer entity
 *
 * @author julien
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer extends AbstractEntity {

    /**
     * User Id
     */
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    /**
     * user login
     */
    @Column(name = "LOGIN", length = 50, nullable = false)
    private String login;

    /**
     * User password
     */
    @Column(name = "PASSWORD", length = 150, nullable = false)
    private String password;

    /**
     * User token
     */
    @Column(name = "TOKEN", length = 50)
    private String token;

    /**
     * List of file
     */
    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private List<File> listFile;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<File> getListFile() {
        return listFile;
    }

    public void setListFile(List<File> listFile) {
        this.listFile = listFile;
    }

}
