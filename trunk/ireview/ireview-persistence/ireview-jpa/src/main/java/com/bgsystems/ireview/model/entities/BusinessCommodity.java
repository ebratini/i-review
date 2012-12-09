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

import com.bgsystems.ireview.model.common.AbstractEntity;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Edwin Bratini
 */
@Entity
@Table(name = "businesses_commodities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BusinessCommodity.findAll", query = "SELECT b FROM BusinessCommodity b"),
    @NamedQuery(name = "BusinessCommodity.findByBusinessId", query = "SELECT b FROM BusinessCommodity b WHERE b.businessCommodityPK.businessId = :businessId"),
    @NamedQuery(name = "BusinessCommodity.findByCommodityId", query = "SELECT b FROM BusinessCommodity b WHERE b.businessCommodityPK.commodityId = :commodityId"),
    @NamedQuery(name = "BusinessCommodity.findByBusinessCommodityRelation", query = "SELECT b FROM BusinessCommodity b WHERE b.businessCommodityRelation = :businessCommodityRelation")})
public class BusinessCommodity extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BusinessCommodityPK businessCommodityPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "business_commodity_relation")
    private String businessCommodityRelation;
    @JoinColumn(name = "commodity_id", referencedColumnName = "commodity_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Commodity commodity;
    @JoinColumn(name = "business_id", referencedColumnName = "business_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Business business;

    public BusinessCommodity() {
    }

    public BusinessCommodity(BusinessCommodityPK businessCommodityPK) {
        this.businessCommodityPK = businessCommodityPK;
    }

    public BusinessCommodity(BusinessCommodityPK businessCommodityPK, String businessCommodityRelation) {
        this.businessCommodityPK = businessCommodityPK;
        this.businessCommodityRelation = businessCommodityRelation;
    }

    public BusinessCommodity(int businessId, int commodityId) {
        this.businessCommodityPK = new BusinessCommodityPK(businessId, commodityId);
    }

    public BusinessCommodityPK getBusinessCommodityPK() {
        return businessCommodityPK;
    }

    public void setBusinessCommodityPK(BusinessCommodityPK businessCommodityPK) {
        this.businessCommodityPK = businessCommodityPK;
    }

    public String getBusinessCommodityRelation() {
        return businessCommodityRelation;
    }

    public void setBusinessCommodityRelation(String businessCommodityRelation) {
        this.businessCommodityRelation = businessCommodityRelation;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (businessCommodityPK != null ? businessCommodityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BusinessCommodity)) {
            return false;
        }
        BusinessCommodity other = (BusinessCommodity) object;
        if ((this.businessCommodityPK == null && other.businessCommodityPK != null) || (this.businessCommodityPK != null && !this.businessCommodityPK.equals(other.businessCommodityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bgsystems.ireview.model.entities.BusinessCommodity[ businessCommodityPK=" + businessCommodityPK + " ]";
    }
    
}
