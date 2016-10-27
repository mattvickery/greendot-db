/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */

package com.greendot.dao;

import org.slf4j.Logger;
import org.springframework.util.StopWatch;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.util.Assert.notNull;

/**
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

    private ThreadLocal<StopWatch> stopWatchThread = new ThreadLocal<StopWatch>() {
        @Override
        protected StopWatch initialValue() {
            return new StopWatch();
        }
    };

    // Transactional?
    public List<E> findAll() {

        try {

            final CriteriaQuery<E> query = getEntityManager().getCriteriaBuilder().createQuery(entityType);
            final Root<E> root = query.from(entityType);
            final CriteriaQuery<E> rootQuery = query.select(root);
            final TypedQuery<E> allQuery = getEntityManager().createQuery(rootQuery);
            stopWatchThread.get().start();
            final List<E> rows = allQuery.getResultList();
            stopWatchThread.get().stop();
            LOG.info("Located: [{} rows] during findAll({}) in [{}ms]", rows.size(), entityType.getSimpleName(),
                    stopWatchThread.get().getLastTaskTimeMillis());
            return rows;
        } finally {
            if (stopWatchThread.get().isRunning())
                stopWatchThread.get().stop();
        }
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

    public void detach(final E entity) {
        notNull(entity, "Mandatory argument 'entity' is missing.");
        entityManager.detach(entity);
    }
}