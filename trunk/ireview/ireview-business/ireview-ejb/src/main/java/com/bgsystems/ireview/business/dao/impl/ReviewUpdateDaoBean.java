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
package com.bgsystems.ireview.business.dao.impl;

import com.bgsystems.ireview.business.dao.ReviewUpdateDao;
import com.bgsystems.ireview.business.dao.common.AbstractDaoBean;
import com.bgsystems.ireview.model.entities.AppUser;
import com.bgsystems.ireview.model.entities.Commodity;
import com.bgsystems.ireview.model.entities.Review;
import com.bgsystems.ireview.model.entities.ReviewUpdate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Edwin Bratini
 */
@Stateless
public class ReviewUpdateDaoBean extends AbstractDaoBean<ReviewUpdate> implements ReviewUpdateDao {

    @Inject
    private Logger log;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<ReviewUpdate> findByReview(Review review) {
        log.log(Level.INFO, "find review update made to review with review id {0}", review.getReviewId());
        String jpqlQueryString = "SELECT ru FROM ReviewUpdate ru WHERE ru.review = :review";
        Query query = entityManager.createQuery(jpqlQueryString);
        query.setParameter("review", review);
        return (List<ReviewUpdate>) query.getResultList();
    }

    @Override
    public List<ReviewUpdate> findByUser(AppUser user) {
        log.log(Level.INFO, "find review update made by user with user id {0}", user.getUserId());
        String jpqlQueryString = "SELECT ru FROM Review ru WHERE r.appUser = :appUser";
        Query query = entityManager.createQuery(jpqlQueryString);
        query.setParameter("appUser", user);
        return (List<ReviewUpdate>) query.getResultList();
    }

    @Override
    public List<ReviewUpdate> findByCommodity(Commodity commodity) {
        log.log(Level.INFO, "find review update made to commodity with commodity id {0}", commodity.getCommodityId());
        String jpqlQueryString = "SELECT ru FROM Review ru WHERE ru.commodity = :commodity";
        Query query = entityManager.createQuery(jpqlQueryString);
        query.setParameter("commodity", commodity);
        return (List<ReviewUpdate>) query.getResultList();
    }
}
