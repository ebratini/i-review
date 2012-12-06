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
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edwin Bratini
 */
@Entity
@Table(name = "commodities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commodity.findAll", query = "SELECT c FROM Commodity c"),
    @NamedQuery(name = "Commodity.findByCtyId", query = "SELECT c FROM Commodity c WHERE c.ctyId = :ctyId"),
    @NamedQuery(name = "Commodity.findByCtyName", query = "SELECT c FROM Commodity c WHERE c.ctyName = :ctyName"),
    @NamedQuery(name = "Commodity.findByCtyDescription", query = "SELECT c FROM Commodity c WHERE c.ctyDescription = :ctyDescription"),
    @NamedQuery(name = "Commodity.findByCtyPictureUri", query = "SELECT c FROM Commodity c WHERE c.ctyPictureUri = :ctyPictureUri")})
public class Commodity extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cty_id")
    private Integer ctyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cty_name")
    private String ctyName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cty_description")
    private String ctyDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cty_picture_uri")
    private String ctyPictureUri;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commodity")
    private Collection<Review> reviewCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commodity")
    private Collection<CommodityScreenshot> commodityScreenshotCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commodity")
    private Collection<BusinessCommodity> businessCommodityCollection;

    public Commodity() {
    }

    public Commodity(Integer ctyId) {
        this.ctyId = ctyId;
    }

    public Commodity(Integer ctyId, String ctyName, String ctyDescription, String ctyPictureUri) {
        this.ctyId = ctyId;
        this.ctyName = ctyName;
        this.ctyDescription = ctyDescription;
        this.ctyPictureUri = ctyPictureUri;
    }

    public Integer getCtyId() {
        return ctyId;
    }

    public void setCtyId(Integer ctyId) {
        this.ctyId = ctyId;
    }

    public String getCtyName() {
        return ctyName;
    }

    public void setCtyName(String ctyName) {
        this.ctyName = ctyName;
    }

    public String getCtyDescription() {
        return ctyDescription;
    }

    public void setCtyDescription(String ctyDescription) {
        this.ctyDescription = ctyDescription;
    }

    public String getCtyPictureUri() {
        return ctyPictureUri;
    }

    public void setCtyPictureUri(String ctyPictureUri) {
        this.ctyPictureUri = ctyPictureUri;
    }

    @XmlTransient
    public Collection<Review> getReviewCollection() {
        return reviewCollection;
    }

    public void setReviewCollection(Collection<Review> reviewCollection) {
        this.reviewCollection = reviewCollection;
    }

    @XmlTransient
    public Collection<CommodityScreenshot> getCommodityScreenshotCollection() {
        return commodityScreenshotCollection;
    }

    public void setCommodityScreenshotCollection(Collection<CommodityScreenshot> commodityScreenshotCollection) {
        this.commodityScreenshotCollection = commodityScreenshotCollection;
    }

    @XmlTransient
    public Collection<BusinessCommodity> getBusinessCommodityCollection() {
        return businessCommodityCollection;
    }

    public void setBusinessCommodityCollection(Collection<BusinessCommodity> businessCommodityCollection) {
        this.businessCommodityCollection = businessCommodityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctyId != null ? ctyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commodity)) {
            return false;
        }
        Commodity other = (Commodity) object;
        if ((this.ctyId == null && other.ctyId != null) || (this.ctyId != null && !this.ctyId.equals(other.ctyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bgsystems.ireview.model.entities.Commodity[ ctyId=" + ctyId + " ]";
    }
    
}
