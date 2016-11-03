/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */

package com.greendot.db.dao;

import com.greendot.db.jpa.core.MutatingEntityDao;
import com.greendot.db.jpa.core.SearchDao;
import com.greendot.entity.product.Good;
import org.springframework.stereotype.Repository;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 10/27/16.
 */
@Repository
public interface GoodDao<E extends Good, I extends Long>
        extends MutatingEntityDao<E, I>, SearchDao<E, I> {
}
