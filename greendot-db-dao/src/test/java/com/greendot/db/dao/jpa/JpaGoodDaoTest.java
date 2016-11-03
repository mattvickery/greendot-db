/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */

package com.greendot.db.dao.jpa;

import com.greendot.db.configuration.JpaDaoConfiguration;
import com.greendot.db.dao.GoodDao;
import com.greendot.db.jpa.configuration.JpaDatabaseConfiguration;
import com.greendot.db.jpa.configuration.PropertiesConfiguration;
import com.greendot.entity.product.Good;
import com.greendot.entity.product.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 10/28/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        PropertiesConfiguration.class,
        JpaDatabaseConfiguration.class,
        JpaDaoConfiguration.class
})
public class JpaGoodDaoTest {

    @Resource(name = "jpaGoodDao")
    private GoodDao<Good, Long> goodDao;

    @Test
    @Transactional
    public void detachedUpdateVerification() {

        final Long id = 12l;
        final Good good = new Good();
        good.setProductId(id).setProductName("Trumpet");
        goodDao.create(good, good.getProductId());
        goodDao.flush();
        goodDao.detach(good);

        good.setProductId(13l);
        final Product locatedEntity = goodDao.findById(id).get();

        assertThat(locatedEntity.getProductId(), is(id));
    }
}