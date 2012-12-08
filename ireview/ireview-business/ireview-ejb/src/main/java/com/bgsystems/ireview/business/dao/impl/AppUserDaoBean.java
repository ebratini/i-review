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

import com.bgsystems.ireview.business.dao.AppUserDao;
import com.bgsystems.ireview.business.dao.common.AbstractDaoBean;
import com.bgsystems.ireview.model.entities.AppUser;
import com.bgsystems.ireview.model.entities.AppUser_;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Edwin Bratini
 */
@Stateless
public class AppUserDaoBean extends AbstractDaoBean<AppUser> implements AppUserDao {

    @Inject
    private Logger log;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<AppUser> findByName(String name) {
        String[] fullName = name.trim().split(" ");
        if (fullName.length != 2) {
            String exceptionMessage = "the full name must be provided as [firstName lastName]";
            log.log(Level.SEVERE, exceptionMessage);
            throw new IllegalArgumentException(exceptionMessage);
        }
        log.log(Level.INFO, "find app user with full name {0}", name);
        CriteriaBuilder builder = getCriteriaBuilder();
        CriteriaQuery<AppUser> query = builder.createQuery(AppUser.class);
        Root<AppUser> appUser = query.from(AppUser.class);
        query.where(builder.equal(appUser.get(AppUser_.firstName), fullName[0]),
                builder.equal(appUser.get(AppUser_.lastName), fullName[1]));
        return getResultList(query);
    }

    @Override
    public List<AppUser> findByUserFirstName(String firstName) {
        log.log(Level.INFO, "find app user with first name {0}", firstName);
        Query query = entityManager.createNamedQuery("AppUser.findByFirstName");
        query.setParameter("firstName", firstName);
        return (List<AppUser>) query.getResultList();
    }

    @Override
    public List<AppUser> findByUserLastName(String lastName) {
        log.log(Level.INFO, "find app user with last name {0}", lastName);
        Query query = entityManager.createNamedQuery("AppUser.findByLastName");
        query.setParameter("lastName", lastName);
        return (List<AppUser>) query.getResultList();
    }
}
