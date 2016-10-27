/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */

package com.greendot.dao;

import java.io.Serializable;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 10/27/16.
 */
public interface ProductTypeDao<E extends Serializable, I extends Serializable>
        extends MutatingEntityDao<E, I>, SearchDao<E, I> {
}