package com.greendot.configuration;

import com.greendot.repository.impl.ProductDao;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.md', which is part of this source code package.
 *
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 10/25/16.
 */
@Configuration
public class DatabaseConfiguration {

    @Bean
    public EntityManager entityManager() {
        return Persistence.createEntityManagerFactory("entitySamplesJpa").createEntityManager();
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