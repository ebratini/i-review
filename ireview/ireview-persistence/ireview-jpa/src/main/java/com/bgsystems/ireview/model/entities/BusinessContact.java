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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Edwin Bratini
 */
@Entity
@Table(name = "business_contacts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BusinessContact.findAll", query = "SELECT b FROM BusinessContact b"),
    @NamedQuery(name = "BusinessContact.findByBcoId", query = "SELECT b FROM BusinessContact b WHERE b.bcoId = :bcoId"),
    @NamedQuery(name = "BusinessContact.findByBcoFirstName", query = "SELECT b FROM BusinessContact b WHERE b.bcoFirstName = :bcoFirstName"),
    @NamedQuery(name = "BusinessContact.findByBcoLastName", query = "SELECT b FROM BusinessContact b WHERE b.bcoLastName = :bcoLastName"),
    @NamedQuery(name = "BusinessContact.findByBcoAddress", query = "SELECT b FROM BusinessContact b WHERE b.bcoAddress = :bcoAddress"),
    @NamedQuery(name = "BusinessContact.findByBcoTelephone", query = "SELECT b FROM BusinessContact b WHERE b.bcoTelephone = :bcoTelephone"),
    @NamedQuery(name = "BusinessContact.findByBcoNationality", query = "SELECT b FROM BusinessContact b WHERE b.bcoNationality = :bcoNationality"),
    @NamedQuery(name = "BusinessContact.findByBcoGender", query = "SELECT b FROM BusinessContact b WHERE b.bcoGender = :bcoGender"),
    @NamedQuery(name = "BusinessContact.findByBcoMaritalStatus", query = "SELECT b FROM BusinessContact b WHERE b.bcoMaritalStatus = :bcoMaritalStatus"),
    @NamedQuery(name = "BusinessContact.findByBcoEmail", query = "SELECT b FROM BusinessContact b WHERE b.bcoEmail = :bcoEmail")})
public class BusinessContact extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "bco_id")
    private String bcoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "bco_first_name")
    private String bcoFirstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "bco_last_name")
    private String bcoLastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "bco_address")
    private String bcoAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "bco_telephone")
    private String bcoTelephone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "bco_nationality")
    private String bcoNationality;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bco_gender")
    private char bcoGender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "bco_marital_status")
    private String bcoMaritalStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "bco_email")
    private String bcoEmail;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "businessContact")
    private LoginInfo loginInfo;
    @JoinColumn(name = "bsn_id", referencedColumnName = "bsn_id")
    @ManyToOne(optional = false)
    private Business business;

    public BusinessContact() {
    }

    public BusinessContact(String bcoId) {
        this.bcoId = bcoId;
    }

    public BusinessContact(String bcoId, String bcoFirstName, String bcoLastName, String bcoAddress, String bcoTelephone, String bcoNationality, char bcoGender, String bcoMaritalStatus, String bcoEmail) {
        this.bcoId = bcoId;
        this.bcoFirstName = bcoFirstName;
        this.bcoLastName = bcoLastName;
        this.bcoAddress = bcoAddress;
        this.bcoTelephone = bcoTelephone;
        this.bcoNationality = bcoNationality;
        this.bcoGender = bcoGender;
        this.bcoMaritalStatus = bcoMaritalStatus;
        this.bcoEmail = bcoEmail;
    }

    public String getBcoId() {
        return bcoId;
    }

    public void setBcoId(String bcoId) {
        this.bcoId = bcoId;
    }

    public String getBcoFirstName() {
        return bcoFirstName;
    }

    public void setBcoFirstName(String bcoFirstName) {
        this.bcoFirstName = bcoFirstName;
    }

    public String getBcoLastName() {
        return bcoLastName;
    }

    public void setBcoLastName(String bcoLastName) {
        this.bcoLastName = bcoLastName;
    }

    public String getBcoAddress() {
        return bcoAddress;
    }

    public void setBcoAddress(String bcoAddress) {
        this.bcoAddress = bcoAddress;
    }

    public String getBcoTelephone() {
        return bcoTelephone;
    }

    public void setBcoTelephone(String bcoTelephone) {
        this.bcoTelephone = bcoTelephone;
    }

    public String getBcoNationality() {
        return bcoNationality;
    }

    public void setBcoNationality(String bcoNationality) {
        this.bcoNationality = bcoNationality;
    }

    public char getBcoGender() {
        return bcoGender;
    }

    public void setBcoGender(char bcoGender) {
        this.bcoGender = bcoGender;
    }

    public String getBcoMaritalStatus() {
        return bcoMaritalStatus;
    }

    public void setBcoMaritalStatus(String bcoMaritalStatus) {
        this.bcoMaritalStatus = bcoMaritalStatus;
    }

    public String getBcoEmail() {
        return bcoEmail;
    }

    public void setBcoEmail(String bcoEmail) {
        this.bcoEmail = bcoEmail;
    }

    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
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
        hash += (bcoId != null ? bcoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BusinessContact)) {
            return false;
        }
        BusinessContact other = (BusinessContact) object;
        if ((this.bcoId == null && other.bcoId != null) || (this.bcoId != null && !this.bcoId.equals(other.bcoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bgsystems.ireview.model.entities.BusinessContact[ bcoId=" + bcoId + " ]";
    }
    
}
