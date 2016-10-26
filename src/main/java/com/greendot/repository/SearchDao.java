package com.greendot.repository;

import com.greendot.entity.Product;

import java.io.Serializable;

/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.md', which is part of this source code package.
 *
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 10/25/16.
 */
public interface SearchDao<E extends Serializable, I extends Serializable> {
    E findById(I id);
}