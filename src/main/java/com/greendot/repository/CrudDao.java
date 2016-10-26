package com.greendot.repository;

import java.io.Serializable;

/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.md', which is part of this source code package.
 *
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 10/25/16.
 */
public interface CrudDao<E extends Serializable, I extends Serializable> extends SearchDao<E,I> {
    E create(final E entity, final I id);
    E update(final E entity, final I id);
    void delete(final E entity, final I id);
}