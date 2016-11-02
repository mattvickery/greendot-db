/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */

package com.greendot.db.dao;

import com.greendot.db.jpa.core.MutatingEntityDao;
import com.greendot.db.jpa.core.SearchDao;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 10/27/16.
 */
@Repository
public interface ProductDao<E extends Serializable, I extends Serializable>
        extends MutatingEntityDao<E, I>, SearchDao<E, I> {
}
