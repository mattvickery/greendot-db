/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */

package com.greendot.db.dao.jpa;

import com.greendot.db.dao.ServiceDao;
import com.greendot.db.jpa.core.AbstractMutatingEntityDao;
import com.greendot.entity.product.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.springframework.util.Assert.notNull;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 10/25/16.
 */
public class JpaServiceDao extends AbstractMutatingEntityDao<Service, Long>
        implements ServiceDao<Service, Long> {

    public JpaServiceDao() {
        super(Service.class, Long.class);
    }

    @PersistenceContext(name = "greendot-jpa-db-test")
    @Override
    public void setEntityManager(final EntityManager entityManager) {

        notNull(entityManager, "Mandatory argument 'entityManager' is missing.");
        super.setEntityManager(entityManager);
    }
}
