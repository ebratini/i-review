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

import com.bgsystems.ireview.business.dao.LoginInfoDao;
import com.bgsystems.ireview.business.dao.common.AbstractDaoBean;
import com.bgsystems.ireview.model.entities.BusinessContact;
import com.bgsystems.ireview.model.entities.LoginInfo;
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
public class LoginInfoDaoBean extends AbstractDaoBean<LoginInfo> implements LoginInfoDao {

    @Inject
    private Logger log;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public LoginInfo findByUsername(String userName) {
        log.log(Level.INFO, "find login info for business contact with user name {0}", userName);
        Query query = entityManager.createNamedQuery("LoginInfo.findByUserName");
        query.setParameter("userName", userName);
        return (LoginInfo) query.getSingleResult();
    }

    @Override
    public LoginInfo findByBusinessContact(BusinessContact businessContact) {
        log.log(Level.INFO, "find login info for business contact with business contact id {0}",
                businessContact.getBusinessContactId());
        Query query = entityManager.createNamedQuery("LoginInfo.findByBusinessContactId");
        query.setParameter("businessContactId", businessContact.getBusinessContactId());
        return (LoginInfo) query.getSingleResult();
    }

    @Override
    public LoginInfo findByBusinessContactEmail(String businessContactEmail) {
        log.log(Level.INFO, "find login info for business contact with email {0}", businessContactEmail);
        Query query = entityManager.createNamedQuery("LoginInfo.findByEmail");
        query.setParameter("email", businessContactEmail);
        return (LoginInfo) query.getSingleResult();
    }
}
