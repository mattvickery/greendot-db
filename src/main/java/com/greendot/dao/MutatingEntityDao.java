/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */

package com.greendot.dao;

import java.io.Serializable;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 10/25/16.
 */
public interface MutatingEntityDao<E extends Serializable, I extends Serializable> {

    E create(final E entity, final I id);

    E upsert(final E entity, final I id);

    void delete(final E entity, final I id);

    void detach(final E entity);

    void flush();
}