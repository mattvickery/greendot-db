/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */

import com.greendot.configuration.DatabaseConfiguration;
import com.greendot.configuration.PropertiesConfiguration;
import com.greendot.entity.Product;
import com.greendot.dao.ProductDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 10/25/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        PropertiesConfiguration.class,
        DatabaseConfiguration.class
})
public class ProductDaoTest {

    @Autowired
    ProductDao productDao;

    @Test
    public void containerStartup() {

        final Long id = 12l;
        final Product product = new Product().setProductId(id).setProductName("Ball");
        productDao.create(product, product.getProductId());
        productDao.detach(product);

        product.setProductId(13l);
        final Product locatedEntity = productDao.findById(id);

        assertThat(locatedEntity.getProductId(), is(id));
    }
}
