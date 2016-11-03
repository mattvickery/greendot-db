/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */

package com.greendot.db.dao.jdbc;

import com.greendot.db.dao.ProductDao;
import com.greendot.entity.product.Product;

import java.util.List;
import java.util.Optional;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 11/2/16.
 */
public class JdbcProductDao implements ProductDao<Product, Long> {

    @Override
    public Product create(Product entity, Long id) {

        return null;
    }

    @Override
    public Product upsert(Product entity, Long id) {

        return null;
    }

    @Override
    public void delete(Product entity, Long id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void detach(Product entity) {

    }

    @Override
    public void flush() {

    }

    @Override
    public Optional<Product> findById(Long id) {

        return null;
    }

    @Override
    public List<Product> findAll() {

        return null;
    }
}
