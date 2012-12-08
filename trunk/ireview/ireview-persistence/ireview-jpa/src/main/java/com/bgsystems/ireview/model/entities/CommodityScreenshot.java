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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "commodity_screenshots")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommodityScreenshot.findAll", query = "SELECT c FROM CommodityScreenshot c"),
    @NamedQuery(name = "CommodityScreenshot.findByCommodityScreenshotId", query = "SELECT c FROM CommodityScreenshot c WHERE c.commodityScreenshotId = :commodityScreenshotId"),
    @NamedQuery(name = "CommodityScreenshot.findByDescription", query = "SELECT c FROM CommodityScreenshot c WHERE c.description = :description"),
    @NamedQuery(name = "CommodityScreenshot.findByScreenshotUri", query = "SELECT c FROM CommodityScreenshot c WHERE c.screenshotUri = :screenshotUri")})
public class CommodityScreenshot extends AbstractEntity implements EntityIdIdentifiable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "commodity_screenshot_id")
    private Integer commodityScreenshotId;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "screenshot_uri")
    private String screenshotUri;
    @JoinColumn(name = "commodity_id", referencedColumnName = "commodity_id")
    @ManyToOne(optional = false)
    private Commodity commodity;

    public CommodityScreenshot() {
    }

    public CommodityScreenshot(Integer commodityScreenshotId) {
        this.commodityScreenshotId = commodityScreenshotId;
    }

    public CommodityScreenshot(Integer commodityScreenshotId, String screenshotUri) {
        this.commodityScreenshotId = commodityScreenshotId;
        this.screenshotUri = screenshotUri;
    }

    public Integer getCommodityScreenshotId() {
        return commodityScreenshotId;
    }

    public void setCommodityScreenshotId(Integer commodityScreenshotId) {
        this.commodityScreenshotId = commodityScreenshotId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScreenshotUri() {
        return screenshotUri;
    }

    public void setScreenshotUri(String screenshotUri) {
        this.screenshotUri = screenshotUri;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commodityScreenshotId != null ? commodityScreenshotId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommodityScreenshot)) {
            return false;
        }
        CommodityScreenshot other = (CommodityScreenshot) object;
        if ((this.commodityScreenshotId == null && other.commodityScreenshotId != null) || (this.commodityScreenshotId != null && !this.commodityScreenshotId.equals(other.commodityScreenshotId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bgsystems.ireview.model.entities.CommodityScreenshot[ commodityScreenshotId=" + commodityScreenshotId + " ]";
    }

    @Override
    public Long getId() {
        return this.getCommodityScreenshotId().longValue();
    }
    
}
