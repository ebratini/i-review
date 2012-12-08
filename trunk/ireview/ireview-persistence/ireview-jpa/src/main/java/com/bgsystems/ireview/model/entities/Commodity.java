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
import com.bgsystems.ireview.model.common.EntityIdIdentifiable;
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
    @NamedQuery(name = "Commodity.findByCommodityId", query = "SELECT c FROM Commodity c WHERE c.commodityId = :commodityId"),
    @NamedQuery(name = "Commodity.findByName", query = "SELECT c FROM Commodity c WHERE c.name = :name"),
    @NamedQuery(name = "Commodity.findByDescription", query = "SELECT c FROM Commodity c WHERE c.description = :description"),
    @NamedQuery(name = "Commodity.findByPictureUri", query = "SELECT c FROM Commodity c WHERE c.pictureUri = :pictureUri")})
public class Commodity extends AbstractEntity implements EntityIdIdentifiable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "commodity_id")
    private Integer commodityId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "picture_uri")
    private String pictureUri;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commodity")
    private Collection<Review> reviewCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commodity")
    private Collection<CommodityScreenshot> commodityScreenshotCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commodity")
    private Collection<BusinessCommodity> businessCommodityCollection;

    public Commodity() {
    }

    public Commodity(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Commodity(Integer commodityId, String name, String description, String pictureUri) {
        this.commodityId = commodityId;
        this.name = name;
        this.description = description;
        this.pictureUri = pictureUri;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureUri() {
        return pictureUri;
    }

    public void setPictureUri(String pictureUri) {
        this.pictureUri = pictureUri;
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
        hash += (commodityId != null ? commodityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commodity)) {
            return false;
        }
        Commodity other = (Commodity) object;
        if ((this.commodityId == null && other.commodityId != null) || (this.commodityId != null && !this.commodityId.equals(other.commodityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bgsystems.ireview.model.entities.Commodity[ commodityId=" + commodityId + " ]";
    }

    @Override
    public Long getId() {
        return this.getCommodityId().longValue();
    }
    
}
