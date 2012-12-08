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
package com.bgsystems.ireview.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Edwin Bratini
 */
@Embeddable
public class BusinessCommodityPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "business_id")
    private int businessId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "commodity_id")
    private int commodityId;

    public BusinessCommodityPK() {
    }

    public BusinessCommodityPK(int businessId, int commodityId) {
        this.businessId = businessId;
        this.commodityId = commodityId;
    }

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) businessId;
        hash += (int) commodityId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BusinessCommodityPK)) {
            return false;
        }
        BusinessCommodityPK other = (BusinessCommodityPK) object;
        if (this.businessId != other.businessId) {
            return false;
        }
        if (this.commodityId != other.commodityId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bgsystems.ireview.model.entities.BusinessCommodityPK[ businessId=" + businessId + ", commodityId=" + commodityId + " ]";
    }
    
}
