/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Spring Context holder
 *
 * @author julien
 */
@Lazy(false)
@Component
public class SpringContextHolder implements ApplicationContextAware {

    /**
     * Application context
     */
    private static ApplicationContext applicationContext = null;

    /**
     * Get application context
     *
     * @return Application context
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.context.ApplicationContextAware#setApplicationContext
     * (org.springframework.context.ApplicationContext)
     */
    @Override
    public void setApplicationContext(final ApplicationContext pContext) throws BeansException {
        applicationContext = pContext;
    }

}
