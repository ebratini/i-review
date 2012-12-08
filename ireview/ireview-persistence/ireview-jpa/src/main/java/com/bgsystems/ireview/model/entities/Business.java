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
@Table(name = "businesses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Business.findAll", query = "SELECT b FROM Business b"),
    @NamedQuery(name = "Business.findByBusinessId", query = "SELECT b FROM Business b WHERE b.businessId = :businessId"),
    @NamedQuery(name = "Business.findByName", query = "SELECT b FROM Business b WHERE b.name = :name"),
    @NamedQuery(name = "Business.findByIndustry", query = "SELECT b FROM Business b WHERE b.industry = :industry"),
    @NamedQuery(name = "Business.findBySummary", query = "SELECT b FROM Business b WHERE b.summary = :summary"),
    @NamedQuery(name = "Business.findByPhone", query = "SELECT b FROM Business b WHERE b.phone = :phone"),
    @NamedQuery(name = "Business.findByAddress", query = "SELECT b FROM Business b WHERE b.address = :address"),
    @NamedQuery(name = "Business.findByCity", query = "SELECT b FROM Business b WHERE b.city = :city"),
    @NamedQuery(name = "Business.findByRegion", query = "SELECT b FROM Business b WHERE b.region = :region"),
    @NamedQuery(name = "Business.findByCountry", query = "SELECT b FROM Business b WHERE b.country = :country"),
    @NamedQuery(name = "Business.findByZipCode", query = "SELECT b FROM Business b WHERE b.zipCode = :zipCode"),
    @NamedQuery(name = "Business.findByEmail", query = "SELECT b FROM Business b WHERE b.email = :email"),
    @NamedQuery(name = "Business.findByWeb", query = "SELECT b FROM Business b WHERE b.web = :web")})
public class Business extends AbstractEntity implements EntityIdIdentifiable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "business_id")
    private Integer businessId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "industry")
    private String industry;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "summary")
    private String summary;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "region")
    private String region;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "country")
    private String country;
    @Size(max = 45)
    @Column(name = "zip_code")
    private String zipCode;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "web")
    private String web;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "business")
    private Collection<BusinessCommodity> businessCommodityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "business")
    private Collection<BusinessContact> businessContactCollection;

    public Business() {
    }

    public Business(Integer businessId) {
        this.businessId = businessId;
    }

    public Business(Integer businessId, String name, String industry, String summary, String phone, String address, String city, String region, String country, String email, String web) {
        this.businessId = businessId;
        this.name = name;
        this.industry = industry;
        this.summary = summary;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.region = region;
        this.country = country;
        this.email = email;
        this.web = web;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
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
        hash += (businessId != null ? businessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Business)) {
            return false;
        }
        Business other = (Business) object;
        if ((this.businessId == null && other.businessId != null) || (this.businessId != null && !this.businessId.equals(other.businessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bgsystems.ireview.model.entities.Business[ businessId=" + businessId + " ]";
    }

    @Override
    public Long getId() {
        return this.getBusinessId().longValue();
    }
    
}
