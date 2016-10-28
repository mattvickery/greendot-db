/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */

/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */

package com.greendot.dao.custom;

import com.greendot.dao.MutatingEntityDao;
import com.greendot.dao.SearchDao;

import java.io.Serializable;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 10/27/16.
 */
public interface ProductDao<E extends Serializable, I extends Serializable>
        extends MutatingEntityDao<E, I>, SearchDao<E, I> {
}