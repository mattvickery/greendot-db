package com.greendot.repository.impl;

import com.greendot.entity.Product;
import com.greendot.repository.AbstractDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.springframework.util.Assert.notNull;

/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.md', which is part of this source code package.
 *
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 10/25/16.
 */
public class ProductDao extends AbstractDao<Product,Long> {

    public ProductDao() {
        super(Product.class, Long.class);
    }
//
//    @Override
////    @PersistenceContext(unitName = "entitySamplesJpa")
//    public void setEntityManager(final EntityManager entityManager) {
//        notNull(entityManager, "Mandatory argument 'entityManager' is missing.");
//        super.setEntityManager(entityManager);
//    }
}