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
package com.bgsystems.ireview.business.services;

import com.bgsystems.ireview.business.dao.CommodityDao;
import com.bgsystems.ireview.model.entities.Business;
import com.bgsystems.ireview.model.entities.Commodity;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 *
 * @author Edwin Bratini
 */
@WebService(serviceName = "CommodityService")
@Stateless()
public class CommodityService {

    @EJB
    private CommodityDao commodityDao;

    @WebMethod(operationName = "findByCommodityName")
    public List<Commodity> findByCommodityName(@WebParam(name = "commodityName") String commodityName) {
        return commodityDao.findByCommodityName(commodityName);
    }

    @WebMethod(operationName = "findByExactCommodityName")
    @RequestWrapper(className = "findByExactCommodityName")
    @ResponseWrapper(className = "findByExactCommodityNameResponse")
    public List<Commodity> findByCommodityName(@WebParam(name = "commodityName") String commodityName, @WebParam(name = "exactMatch") boolean exactMatch) {
        return commodityDao.findByCommodityName(commodityName, exactMatch);
    }

    @WebMethod(operationName = "searchCommodity")
    public List<Commodity> searchCommodity(@WebParam(name = "searchKeyword") String searchKeyword) {
        return commodityDao.searchCommodity(searchKeyword);
    }

    @WebMethod(operationName = "findByBusiness")
    public List<Commodity> findByBusiness(@WebParam(name = "business") Business business) {
        return commodityDao.findByBusiness(business);
    }

    @WebMethod(operationName = "findVendors")
    public List<Business> findVendors(@WebParam(name = "commodity") Commodity commodity) {
        return commodityDao.findVendors(commodity);
    }

    @WebMethod(operationName = "findOwner")
    public Business findOwner(@WebParam(name = "commodity") Commodity commodity) {
        return commodityDao.findOwner(commodity);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findCommodityById")
    public Commodity findCommodityById(@WebParam(name = "commodityId") int commodityId) {
        return commodityDao.find(commodityId);
    }
}
