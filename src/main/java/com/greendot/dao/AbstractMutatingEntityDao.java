/*
 *  This file is subject to the terms and conditions defined in file 'LICENSE.md',
 *  which is part of this source code package.
 */

package com.greendot.dao;

import org.slf4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaDelete;
import java.io.Serializable;

import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.util.Assert.notNull;

/**
 * @author matt.d.vickery@greendotsoftware.co.uk
 * @since 10/25/16.
 */
public abstract class AbstractMutatingEntityDao<E extends Serializable, I extends Serializable>
        extends AbstractSearchDao<E, I> implements MutatingEntityDao<E, I> {

    private static final Logger LOG = getLogger(AbstractMutatingEntityDao.class);

    protected AbstractMutatingEntityDao(final Class<E> entityType, final Class<I> idType) {
        super(entityType, idType);
    }

    @Transactional
    @Override
    public E create(final E entity, final I id) {

        notNull(entity, "Mandatory argument 'entity' is missing.");
        notNull(id, "Mandatory argument 'id' is missing.");
        try {
            getEntityManager().persist(entity);
            return entity;
        } catch (PersistenceException e) {
            LOG.error("FAILURE");
            throw e;
        }
    }

    @Transactional
    @Override
    public E upsert(final E entity, final I id) {

        notNull(entity, "Mandatory argument 'entity' is missing.");
        notNull(id, "Mandatory argument 'id' is missing.");
        try {
            return findById(id).map(e -> getEntityManager().merge(entity)).orElse(create(entity, id));
        } catch (PersistenceException e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public void delete(final E entity, final I id) {

        notNull(entity, "Mandatory argument 'entity' is missing.");
        notNull(id, "Mandatory argument 'id' is missing.");
        try {
            getEntityManager().remove(entity);
        } catch (PersistenceException e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public void deleteAll() {

        try {
            final CriteriaDelete<E> deleteAllCriteria
                    = getEntityManager().getCriteriaBuilder().createCriteriaDelete(getEntityType());
            deleteAllCriteria.from(getEntityType());
            stopWatchThread.get().start();
            int rowCount = getEntityManager().createQuery(deleteAllCriteria).executeUpdate();
            stopWatchThread.get().stop();
            LOG.info("Deleted: [{}] rows during deleteAll({}) in [{}ms]", rowCount, getEntityType().getSimpleName(),
                    stopWatchThread.get().getLastTaskTimeMillis());
        } finally {
            if (stopWatchThread.get().isRunning())
                stopWatchThread.get().stop();
        }
    }

    @Override
    public void detach(final E entity) {

        notNull(entity, "Mandatory argument 'entity' is missing.");
        getEntityManager().detach(entity);
    }

    @Transactional
    @Override
    public void flush() {

        getEntityManager().flush();
    }
}