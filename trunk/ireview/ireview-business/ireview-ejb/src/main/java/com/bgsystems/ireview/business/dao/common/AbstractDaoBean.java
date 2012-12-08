/*
 * The MIT License
 *
 * Copyright 2012 Edwin Bratini.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.bgsystems.ireview.business.dao.common;

import com.bgsystems.ireview.model.common.AbstractEntity;
import com.bgsystems.ireview.model.common.EntityIdIdentifiable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Edwin Bratini
 */
public abstract class AbstractDaoBean<E extends AbstractEntity> implements Dao<E> {

    protected final Class<E> entityClass;

    @SuppressWarnings("unchecked")
    protected AbstractDaoBean() {
        super();
        entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected abstract EntityManager getEntityManager();

    protected E getSingleResult(final CriteriaQuery<E> query) {
        return this.<E>getTypedSingleResult(query);
    }

    protected <T> T getTypedSingleResult(final CriteriaQuery<T> query) {
        try {
            return getEntityManager().createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    protected List<E> getResultList(final CriteriaQuery<E> query) {
        return getEntityManager().createQuery(query).getResultList();
    }

    protected List<E> getResultList(final CriteriaQuery<E> query,
            int maxresults, int firstresult) {
        return getEntityManager().createQuery(query).setMaxResults(maxresults)
                .setFirstResult(firstresult).getResultList();
    }

    protected List<E> getResultList(final Query query) {
        return query.getResultList();
    }

    protected CriteriaBuilder getCriteriaBuilder() {
        return getEntityManager().getCriteriaBuilder();
    }

    @Override
    public void persist(final E instance) {
        getEntityManager().persist(instance);
    }

    @Override
    public E find(final long id) {
        return getEntityManager().find(entityClass, id);
    }

    @Override
    public void remove(final E instance) {
        boolean contains = getEntityManager().contains(instance);
        E remove = instance;
        if (!contains && (instance instanceof EntityIdIdentifiable)) {
            remove = find(((EntityIdIdentifiable) instance).getId());
        } else {
            remove = merge(instance);
        }
        getEntityManager().remove(remove);
    }

    @Override
    public E merge(final E instance) {
        E merge = getEntityManager().merge(instance);
        getEntityManager().flush();
        return merge;
    }

    @Override
    public List<E> findAll() {
        CriteriaBuilder builder = getCriteriaBuilder();
        CriteriaQuery<E> query = builder.createQuery(entityClass);
        query.from(entityClass);

        return getResultList(query);
    }
}
