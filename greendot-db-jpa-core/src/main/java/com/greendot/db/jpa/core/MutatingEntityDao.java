/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */
package com.greendot.db.jpa.core;

import java.io.Serializable;
import java.util.List;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 10/25/16.
 */
public interface MutatingEntityDao<E extends Serializable, I extends Serializable> {

    /**
     * Create a new entity object.
     * @param entity the entity that will undergo creation.
     * @param id the primary key.
     * @return
     * @throws RuntimeException when the entity already exists.
     */
    E create(final E entity, final I id);

    /**
     * Update or create the supplied entity.
     * @param entity the entity to be updated or created.
     * @param id the primary key.
     * @return the updated or created entity.
     */
    E upsert(final E entity, final I id);

    /**
     * Delete a single entity whose primary key is equal to the entity provided as an argument.
     * @param entity
     * @param id
     */
    void delete(final E entity, final I id);

    /**
     * Delete all of the entities managed by this DAO.
     */
    void deleteAll();

    void detach(final E entity);

    void flush();

    /**
     * Examine the attributes of the supplied entity (apart from the PK) and bulk update all entities
     * to the same value as each non-null attribute.
     *
     * @param entity that specifies bulk update values.
     * @return a list of all entities that have been altered.
     */
    List<E> updateAll(final E entity);
}
