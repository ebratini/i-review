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
package com.bgsystems.ireview.business.service;

import com.bgsystems.ireview.business.dao.CommodityDao;
import com.bgsystems.ireview.business.dao.CommodityScreenshotDao;
import com.bgsystems.ireview.model.entities.Commodity;
import com.bgsystems.ireview.model.entities.CommodityScreenshot;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Edwin Bratini
 */
@WebService(serviceName = "CommodityScreenshotService")
@Stateless()
public class CommodityScreenshotService {

    @EJB
    private CommodityDao commodityDaoBean;
    @EJB
    private CommodityScreenshotDao commodityScreenshotDao;
    
    @WebMethod(operationName = "findByCommodity")
    public List<CommodityScreenshot> findByCommodity(@WebParam(name = "commodity") Commodity commodity) {
        return commodityScreenshotDao.findByCommodity(commodity);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findCommodityScreenshots")
    public List<CommodityScreenshot> findCommodityScreenshots(@WebParam(name = "commodityId") int commodityId) {
        return findByCommodity(commodityDaoBean.find(commodityId));
    }
}
