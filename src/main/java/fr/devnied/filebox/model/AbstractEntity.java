/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.model;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;
import org.springframework.data.domain.Persistable;

/**
 * Abstract entity
 *
 * @author julien
 */
@MappedSuperclass
public abstract class AbstractEntity implements Persistable<Long>, Serializable {

    @Override
    public boolean isNew() {
        return getId() == null;
    }

}
