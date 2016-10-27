/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */

package com.greendot.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 10/25/16.
 */
@Configuration
@PropertySource(value = {
        "classpath:properties/app.properties",
        "classpath:properties/app-${spring.profiles.active:default}.properties"
})
public class PropertiesConfiguration {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Bean
    public static PropertySourcesPlaceholderConfigurer getProperties() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
