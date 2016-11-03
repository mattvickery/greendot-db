/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */

/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */

/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */

package com.greendot.db.jpa.core;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 10/25/16.
 */
public interface SearchDao<E extends Serializable, I extends Serializable> {

    /**
     * Locate an entity using a primary key value of the supplied id.
     * @param id a primary key value used for entity location.
     * @return if found, an entity, an optional null otherwise.
     */
    Optional<E> findById(I id);

    /**
     * Locate all entities of the type managed by the DAO.
     * @return a list of entities located in the repository.
     */
    List<E> findAll();

    /**
     * Locate all entities of the type managed by the DAO using the pagination criteria supplied.
     * @return a list of entities located in the repository.
     */
    List<E> findAll(final long offset, final long size);
}