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
    @NamedQuery(name = "BusinessContact.findByBusinessContactId", query = "SELECT b FROM BusinessContact b WHERE b.businessContactId = :businessContactId"),
    @NamedQuery(name = "BusinessContact.findByFirstName", query = "SELECT b FROM BusinessContact b WHERE b.firstName = :firstName"),
    @NamedQuery(name = "BusinessContact.findByLastName", query = "SELECT b FROM BusinessContact b WHERE b.lastName = :lastName"),
    @NamedQuery(name = "BusinessContact.findByAddress", query = "SELECT b FROM BusinessContact b WHERE b.address = :address"),
    @NamedQuery(name = "BusinessContact.findByPhone", query = "SELECT b FROM BusinessContact b WHERE b.phone = :phone"),
    @NamedQuery(name = "BusinessContact.findByNationality", query = "SELECT b FROM BusinessContact b WHERE b.nationality = :nationality"),
    @NamedQuery(name = "BusinessContact.findByGender", query = "SELECT b FROM BusinessContact b WHERE b.gender = :gender"),
    @NamedQuery(name = "BusinessContact.findByMaritalStatus", query = "SELECT b FROM BusinessContact b WHERE b.maritalStatus = :maritalStatus"),
    @NamedQuery(name = "BusinessContact.findByContactEmail", query = "SELECT b FROM BusinessContact b WHERE b.contactEmail = :contactEmail")})
public class BusinessContact extends AbstractEntity implements EntityIdIdentifiable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "business_contact_id")
    private Integer businessContactId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nationality")
    private String nationality;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gender")
    private char gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "marital_status")
    private String maritalStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "contact_email")
    private String contactEmail;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "businessContact")
    private LoginInfo loginInfo;
    @JoinColumn(name = "business_id", referencedColumnName = "business_id")
    @ManyToOne(optional = false)
    private Business business;

    public BusinessContact() {
    }

    public BusinessContact(Integer businessContactId) {
        this.businessContactId = businessContactId;
    }

    public BusinessContact(Integer businessContactId, String firstName, String lastName, String address, String phone, String nationality, char gender, String maritalStatus, String contactEmail) {
        this.businessContactId = businessContactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.nationality = nationality;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.contactEmail = contactEmail;
    }

    public Integer getBusinessContactId() {
        return businessContactId;
    }

    public void setBusinessContactId(Integer businessContactId) {
        this.businessContactId = businessContactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
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
        hash += (businessContactId != null ? businessContactId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BusinessContact)) {
            return false;
        }
        BusinessContact other = (BusinessContact) object;
        if ((this.businessContactId == null && other.businessContactId != null) || (this.businessContactId != null && !this.businessContactId.equals(other.businessContactId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bgsystems.ireview.model.entities.BusinessContact[ businessContactId=" + businessContactId + " ]";
    }

    @Override
    public Long getId() {
        return this.getBusinessContactId().longValue();
    }
    
}
