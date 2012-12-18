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
import com.bgsystems.ireview.business.dao.ReviewDao;
import com.bgsystems.ireview.model.entities.AppUser;
import com.bgsystems.ireview.model.entities.Commodity;
import com.bgsystems.ireview.model.entities.Review;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 *
 * @author Edwin Bratini
 */
@WebService(serviceName = "ReviewService")
@Stateless()
public class ReviewService {

    @EJB
    private ReviewDao reviewDao;
    @EJB
    private CommodityDao commodityDao;

    @WebMethod(operationName = "findReviewByUser")
    public List<Review> findReviewByUser(@WebParam(name = "user") AppUser user) {
        return reviewDao.findReviewByUser(user);
    }

    @WebMethod(operationName = "findReviewByCommodity")
    public List<Review> findReviewByCommodity(@WebParam(name = "commodity") Commodity commodity) {
        return reviewDao.findReviewByCommodity(commodity);
    }

    @WebMethod(operationName = "findReviewByCommodityAndRange")
    @RequestWrapper(className = "findReviewByCommodityAndRange")
    @ResponseWrapper(className = "findReviewByCommodityAndRangeResponse")
    public List<Review> findReviewByCommodity(@WebParam(name = "commodity") Commodity commodity, @WebParam(name = "range") int[] range) {
        return reviewDao.findReviewByCommodity(commodity, range);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findCommodityReviews")
    public List<Review> findCommodityReviews(@WebParam(name = "commodityId") int commodityId) {
        return findReviewByCommodity(commodityDao.find(commodityId));
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "makeReview")
    @Oneway
    public void makeReview(@WebParam(name = "review") Review review) {
        reviewDao.persist(review);
    }
    
    
}
