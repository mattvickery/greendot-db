package com.greendot.repository;

import org.slf4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.io.Serializable;

import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.util.Assert.notNull;

/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.md', which is part of this source code package.
 *
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 10/25/16.
 */
public abstract class AbstractDao<E extends Serializable, I extends Serializable>
        implements CrudDao<E, I> {

    private static final Logger LOG = getLogger(AbstractDao.class);

    private EntityManager entityManager;
    private final Class<E> entityType;
    private final Class<I> idType;

    protected AbstractDao(final Class<E> entityType, final Class<I> idType) {
        notNull(entityType, "Mandatory argument 'entityType' is missing.");
        notNull(idType, "Mandatory argument 'idType' is missing.");
        this.entityType = entityType;
        this.idType = idType;
    }

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    public void setEntityManager(final EntityManager entityManager) {
        notNull(entityManager, "Mandatory argument 'entityManager' is missing.");
        this.entityManager = entityManager;
    }

    public E findById(final I id) {
        return entityManager.find((Class<E>) entityType, id);
    }

    public E create(final E entity, final I id) {

        notNull(entity, "Mandatory argument 'entity' is missing.");
        notNull(id, "Mandatory argument 'id' is missing.");
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            return entity;
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            LOG.error("FAILURE");
            throw e;
        }
    }

    public E update(final E entity, final I id) {

        notNull(entity, "Mandatory argument 'entity' is missing.");
        notNull(id, "Mandatory argument 'id' is missing.");
        try {
            final E locatedEntity = findById(id);
            if (locatedEntity == null)
                create(entity, id);
            else {
                entityManager.merge(entity);
            }
            return entity;
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void delete(final E entity, final I id) {

        notNull(entity, "Mandatory argument 'entity' is missing.");
        notNull(id, "Mandatory argument 'id' is missing.");
        try {
            entityManager.remove(entity);
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}