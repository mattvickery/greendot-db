/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */

package com.greendot.dao.custom.jpa;

import com.greendot.configuration.DatabaseConfiguration;
import com.greendot.configuration.PropertiesConfiguration;
import com.greendot.dao.custom.ProductDao;
import com.greendot.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 10/28/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        PropertiesConfiguration.class,
        DatabaseConfiguration.class
})
public class JpaProductDaoTest {

    @Autowired
    private ProductDao<Product, Long> productDao;

    @Test
    @Transactional
    public void containerStartup() {

        final Long id = 12l;
        final Product product = new Product().setProductId(id).setProductName("Ball");
        productDao.create(product, product.getProductId());
        productDao.flush();
        productDao.detach(product);

        product.setProductId(13l);
        final Product locatedEntity = productDao.findById(id).get();

        assertThat(locatedEntity.getProductId(), is(id));
    }
}