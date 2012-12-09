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

import com.bgsystems.ireview.business.dao.BusinessContactDao;
import com.bgsystems.ireview.business.dao.common.AbstractDaoBean;
import com.bgsystems.ireview.model.entities.BusinessContact;
import com.bgsystems.ireview.model.entities.BusinessContact_;
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
public class BusinessContactDaoBean extends AbstractDaoBean<BusinessContact> implements BusinessContactDao {

    @Inject
    private Logger log;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<BusinessContact> findByBusinessContactName(String businessContactName) {
        String[] fullName = businessContactName.trim().split(" ");
        if (fullName.length != 2) {
            String exceptionMessage = "the full name must be provided as [firstName lastName]";
            log.log(Level.SEVERE, exceptionMessage);
            throw new IllegalArgumentException(exceptionMessage);
        }
        log.log(Level.INFO, "find business contact with full name {0}", businessContactName);
        CriteriaBuilder builder = getCriteriaBuilder();
        CriteriaQuery<BusinessContact> query = builder.createQuery(BusinessContact.class);
        Root<BusinessContact> businessContact = query.from(BusinessContact.class);
        query.where(builder.equal(businessContact.get(BusinessContact_.firstName), fullName[0]),
                builder.equal(businessContact.get(BusinessContact_.lastName), fullName[1]));
        return getResultList(query);
    }

    @Override
    public List<BusinessContact> findByBusinessContactFirstName(String firstName) {
        log.log(Level.INFO, "find business contact with first name {0}", firstName);
        Query query = entityManager.createNamedQuery("BusinessContact.findByFirstName");
        query.setParameter("firstName", firstName);
        return (List<BusinessContact>) query.getResultList();
    }

    @Override
    public List<BusinessContact> findByBusinessContactLastName(String lastName) {
        log.log(Level.INFO, "find business contact with last name {0}", lastName);
        Query query = entityManager.createNamedQuery("BusinessContact.findByLastName");
        query.setParameter("lastName", lastName);
        return (List<BusinessContact>) query.getResultList();
    }
}
