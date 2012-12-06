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
@Table(name = "businesses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Business.findAll", query = "SELECT b FROM Business b"),
    @NamedQuery(name = "Business.findByBsnId", query = "SELECT b FROM Business b WHERE b.bsnId = :bsnId"),
    @NamedQuery(name = "Business.findByBsnName", query = "SELECT b FROM Business b WHERE b.bsnName = :bsnName"),
    @NamedQuery(name = "Business.findByBsnTelephone", query = "SELECT b FROM Business b WHERE b.bsnTelephone = :bsnTelephone"),
    @NamedQuery(name = "Business.findByBsnAddress", query = "SELECT b FROM Business b WHERE b.bsnAddress = :bsnAddress"),
    @NamedQuery(name = "Business.findByBsnEmail", query = "SELECT b FROM Business b WHERE b.bsnEmail = :bsnEmail"),
    @NamedQuery(name = "Business.findByBsnWeb", query = "SELECT b FROM Business b WHERE b.bsnWeb = :bsnWeb")})
public class Business extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "bsn_id")
    private Integer bsnId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "bsn_name")
    private String bsnName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "bsn_telephone")
    private String bsnTelephone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "bsn_address")
    private String bsnAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "bsn_email")
    private String bsnEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "bsn_web")
    private String bsnWeb;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "business")
    private Collection<BusinessCommodity> businessCommodityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "business")
    private Collection<BusinessContact> businessContactCollection;

    public Business() {
    }

    public Business(Integer bsnId) {
        this.bsnId = bsnId;
    }

    public Business(Integer bsnId, String bsnName, String bsnTelephone, String bsnAddress, String bsnEmail, String bsnWeb) {
        this.bsnId = bsnId;
        this.bsnName = bsnName;
        this.bsnTelephone = bsnTelephone;
        this.bsnAddress = bsnAddress;
        this.bsnEmail = bsnEmail;
        this.bsnWeb = bsnWeb;
    }

    public Integer getBsnId() {
        return bsnId;
    }

    public void setBsnId(Integer bsnId) {
        this.bsnId = bsnId;
    }

    public String getBsnName() {
        return bsnName;
    }

    public void setBsnName(String bsnName) {
        this.bsnName = bsnName;
    }

    public String getBsnTelephone() {
        return bsnTelephone;
    }

    public void setBsnTelephone(String bsnTelephone) {
        this.bsnTelephone = bsnTelephone;
    }

    public String getBsnAddress() {
        return bsnAddress;
    }

    public void setBsnAddress(String bsnAddress) {
        this.bsnAddress = bsnAddress;
    }

    public String getBsnEmail() {
        return bsnEmail;
    }

    public void setBsnEmail(String bsnEmail) {
        this.bsnEmail = bsnEmail;
    }

    public String getBsnWeb() {
        return bsnWeb;
    }

    public void setBsnWeb(String bsnWeb) {
        this.bsnWeb = bsnWeb;
    }

    @XmlTransient
    public Collection<BusinessCommodity> getBusinessCommodityCollection() {
        return businessCommodityCollection;
    }

    public void setBusinessCommodityCollection(Collection<BusinessCommodity> businessCommodityCollection) {
        this.businessCommodityCollection = businessCommodityCollection;
    }

    @XmlTransient
    public Collection<BusinessContact> getBusinessContactCollection() {
        return businessContactCollection;
    }

    public void setBusinessContactCollection(Collection<BusinessContact> businessContactCollection) {
        this.businessContactCollection = businessContactCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bsnId != null ? bsnId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Business)) {
            return false;
        }
        Business other = (Business) object;
        if ((this.bsnId == null && other.bsnId != null) || (this.bsnId != null && !this.bsnId.equals(other.bsnId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bgsystems.ireview.model.entities.Business[ bsnId=" + bsnId + " ]";
    }
    
}
