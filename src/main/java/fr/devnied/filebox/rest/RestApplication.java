/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.rest;

import fr.devnied.filebox.utils.SpringContextHolder;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.ext.Provider;
import net.sf.corn.cps.CPScanner;
import net.sf.corn.cps.ClassFilter;
import org.springframework.beans.BeansException;

/**
 * Application
 *
 * @author julien
 */
@ApplicationPath("/rest")
public class RestApplication extends Application {

    /**
     * List of Rest webservice
     */
    private final Set<Object> singletons = new HashSet<>();

    /**
     * Default constructor
     */
    public RestApplication() {
        List<Class<?>> classes = CPScanner.scanClasses(new ClassFilter().packageName("fr.devnied.filebox.*").annotation(Provider.class));
        for (Class<?> clazz : classes) {
            try {
                Object obj = null;
                try {
                    obj = SpringContextHolder.getApplicationContext().getBean(clazz);
                } catch (BeansException e) {
                    // do nothing
                }
                if (obj == null) {
                    obj = clazz.newInstance();
                }
                singletons.add(obj);
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(RestApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
