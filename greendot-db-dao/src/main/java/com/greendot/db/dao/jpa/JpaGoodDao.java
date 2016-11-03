/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */

package com.greendot.db.dao.jpa;

import com.greendot.db.dao.GoodDao;
import com.greendot.db.jpa.core.AbstractMutatingEntityDao;
import com.greendot.entity.product.Good;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 10/25/16.
 */
public class JpaGoodDao extends AbstractMutatingEntityDao<Good, Long>
        implements GoodDao<Good, Long> {

    public JpaGoodDao() {

        super(Good.class, Long.class);
    }

    @PersistenceContext(name = "greendot-jpa-db-test")
    @Override
    public void setEntityManager(final EntityManager entityManager) {

        Assert.notNull(entityManager, "Mandatory argument 'entityManager' is missing.");
        super.setEntityManager(entityManager);
    }
}
