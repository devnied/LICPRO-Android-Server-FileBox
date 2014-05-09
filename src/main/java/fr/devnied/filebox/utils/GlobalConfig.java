/*
 * Software property of MILLAU Julien. Copyright Copyright (c) 2014.
 */
package fr.devnied.filebox.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * Global configuration for vitrine project
 *
 * @author julien
 */
@Configuration
@PropertySources(value = {
    @PropertySource(
            value = {
                "classpath:config.properties",
                "file:${catalina.base}/conf/filebox/filebox.properties"
            }, ignoreResourceNotFound = true)})
public class GlobalConfig {

}
