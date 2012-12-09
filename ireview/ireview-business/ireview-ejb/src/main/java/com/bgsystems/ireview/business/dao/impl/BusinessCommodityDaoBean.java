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

import com.bgsystems.ireview.business.dao.BusinessCommodityDao;
import com.bgsystems.ireview.business.dao.common.AbstractDaoBean;
import com.bgsystems.ireview.model.entities.Business;
import com.bgsystems.ireview.model.entities.BusinessCommodity;
import com.bgsystems.ireview.model.entities.Commodity;
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
public class BusinessCommodityDaoBean extends AbstractDaoBean<BusinessCommodity> implements BusinessCommodityDao {

    @Inject
    private Logger log;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<BusinessCommodity> findByBusiness(Business business) {
        log.log(Level.INFO, "find business-commodity with business id {0}", business.getBusinessId());
        Query query = entityManager.createNamedQuery("BusinessCommodity.findByBusinessId");
        query.setParameter("businessId", business.getBusinessId());
        return (List<BusinessCommodity>) query.getResultList();
    }

    @Override
    public List<BusinessCommodity> findByCommodity(Commodity commodity) {
        log.log(Level.INFO, "find business-commodity with commodity id {0}", commodity.getCommodityId());
        Query query = entityManager.createNamedQuery("BusinessCommodity.findByBusinessId");
        query.setParameter("commodityId", commodity.getCommodityId());
        return (List<BusinessCommodity>) query.getResultList();
    }

    @Override
    public List<BusinessCommodity> findByBusinessCommodityRelation(String businessRelation) {
        log.log(Level.INFO, "find business-commodity with business-commodity relation id {0}", businessRelation);
        Query query = entityManager.createNamedQuery("BusinessCommodity.findByBusinessCommodityRelation");
        query.setParameter("businessCommodityRelation", businessRelation);
        return (List<BusinessCommodity>) query.getResultList();
    }
}
