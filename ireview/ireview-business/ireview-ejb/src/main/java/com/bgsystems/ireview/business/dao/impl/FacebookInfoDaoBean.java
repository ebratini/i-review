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

import com.bgsystems.ireview.business.dao.FacebookInfoDao;
import com.bgsystems.ireview.business.dao.common.AbstractDaoBean;
import com.bgsystems.ireview.model.entities.AppUser;
import com.bgsystems.ireview.model.entities.Business;
import com.bgsystems.ireview.model.entities.FacebookInfo;
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
public class FacebookInfoDaoBean extends AbstractDaoBean<FacebookInfo> implements FacebookInfoDao {

    @Inject
    private Logger log;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public FacebookInfo findByUser(AppUser user) {
        log.log(Level.INFO, "find facebook info for app user id {0}", user.getUserId());
        Query query = entityManager.createNamedQuery("FacebookInfo.findByUserId");
        query.setParameter("userId", user.getUserId());
        return (FacebookInfo) query.getSingleResult();
    }

    @Override
    public FacebookInfo findByEmail(String email) {
        log.log(Level.INFO, "find facebook info for app user email {0}", email);
        Query query = entityManager.createNamedQuery("FacebookInfo.findByEmail");
        query.setParameter("email", email);
        return (FacebookInfo) query.getSingleResult();
    }

    @Override
    public FacebookInfo findByPhone(String phone) {
        log.log(Level.INFO, "find facebook info for app user phone {0}", phone);
        Query query = entityManager.createNamedQuery("FacebookInfo.findByPhone");
        query.setParameter("phone", phone);
        return (FacebookInfo) query.getSingleResult();
    }
}
