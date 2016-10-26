import com.greendot.configuration.DatabaseConfiguration;
import com.greendot.configuration.PropertiesConfiguration;
import com.greendot.entity.Product;
import com.greendot.repository.impl.ProductDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.md', which is part of this source code package.
 *
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
       productDao.create(new Product().setProductId(1l).setProductName("Ball"), 1l);
    }
}
