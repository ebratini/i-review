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
    @NamedQuery(name = "CommodityScreenshot.findByCmsId", query = "SELECT c FROM CommodityScreenshot c WHERE c.cmsId = :cmsId"),
    @NamedQuery(name = "CommodityScreenshot.findByCmsDescription", query = "SELECT c FROM CommodityScreenshot c WHERE c.cmsDescription = :cmsDescription"),
    @NamedQuery(name = "CommodityScreenshot.findByCmsScreenshotUri", query = "SELECT c FROM CommodityScreenshot c WHERE c.cmsScreenshotUri = :cmsScreenshotUri")})
public class CommodityScreenshot extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cms_id")
    private Integer cmsId;
    @Size(max = 45)
    @Column(name = "cms_description")
    private String cmsDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cms_screenshot_uri")
    private String cmsScreenshotUri;
    @JoinColumn(name = "cty_id", referencedColumnName = "cty_id")
    @ManyToOne(optional = false)
    private Commodity commodity;

    public CommodityScreenshot() {
    }

    public CommodityScreenshot(Integer cmsId) {
        this.cmsId = cmsId;
    }

    public CommodityScreenshot(Integer cmsId, String cmsScreenshotUri) {
        this.cmsId = cmsId;
        this.cmsScreenshotUri = cmsScreenshotUri;
    }

    public Integer getCmsId() {
        return cmsId;
    }

    public void setCmsId(Integer cmsId) {
        this.cmsId = cmsId;
    }

    public String getCmsDescription() {
        return cmsDescription;
    }

    public void setCmsDescription(String cmsDescription) {
        this.cmsDescription = cmsDescription;
    }

    public String getCmsScreenshotUri() {
        return cmsScreenshotUri;
    }

    public void setCmsScreenshotUri(String cmsScreenshotUri) {
        this.cmsScreenshotUri = cmsScreenshotUri;
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
        hash += (cmsId != null ? cmsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommodityScreenshot)) {
            return false;
        }
        CommodityScreenshot other = (CommodityScreenshot) object;
        if ((this.cmsId == null && other.cmsId != null) || (this.cmsId != null && !this.cmsId.equals(other.cmsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bgsystems.ireview.model.entities.CommodityScreenshot[ cmsId=" + cmsId + " ]";
    }
    
}
