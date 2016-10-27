/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */

package com.greendot.configuration;

import com.greendot.dao.ProductDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 10/25/16.
 */
@Configuration
public class DatabaseConfiguration {

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        return Persistence.createEntityManagerFactory("entitySamplesJpa");
    }

    @Bean
    public EntityManager entityManager() {
        return entityManagerFactory().createEntityManager();
    }

    @Bean
    public ProductDao productDao() {
        final ProductDao dao = new ProductDao();
        dao.setEntityManager(entityManager());
        return dao;
    }

    @Bean
    public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor(){
        return new PersistenceAnnotationBeanPostProcessor();
    }
}