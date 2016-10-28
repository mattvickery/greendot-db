/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */

/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */

/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */

package com.greendot.dao.custom.jpa;

import com.greendot.dao.base.AbstractMutatingEntityDao;
import com.greendot.dao.custom.ProductDao;
import com.greendot.entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.springframework.util.Assert.notNull;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 10/25/16.
 */
@Repository
public class JpaProductDao extends AbstractMutatingEntityDao<Product, Long>
        implements ProductDao<Product, Long> {

    public JpaProductDao() {

        super(Product.class, Long.class);
    }

    @PersistenceContext(name = "jpaTesting")
    @Override
    public void setEntityManager(final EntityManager entityManager) {

        notNull(entityManager, "Mandatory argument 'entityManager' is missing.");
        super.setEntityManager(entityManager);
    }
}