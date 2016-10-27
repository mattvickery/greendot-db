/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */

package com.greendot.dao;

import com.greendot.entity.Product;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 10/25/16.
 */
public class ProductDao extends AbstractDao<Product,Long> {

    public ProductDao() {
        super(Product.class, Long.class);
    }
}