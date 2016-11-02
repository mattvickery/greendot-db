/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */

package com.greendot.db.configuration;

import com.greendot.db.dao.ProductDao;
import com.greendot.db.dao.jpa.JpaProductDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 10/25/16.
 */
@Configuration
@EnableTransactionManagement
public class JpaDaoConfiguration {

    @Bean
    public ProductDao jpaProductDao() {
        return new JpaProductDao();
    }
}