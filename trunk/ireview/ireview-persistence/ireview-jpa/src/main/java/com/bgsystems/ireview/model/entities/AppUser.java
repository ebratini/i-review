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
import javax.persistence.OneToOne;
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
@Table(name = "app_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppUser.findAll", query = "SELECT a FROM AppUser a"),
    @NamedQuery(name = "AppUser.findByUsrId", query = "SELECT a FROM AppUser a WHERE a.usrId = :usrId"),
    @NamedQuery(name = "AppUser.findByUsrFirstName", query = "SELECT a FROM AppUser a WHERE a.usrFirstName = :usrFirstName"),
    @NamedQuery(name = "AppUser.findByUsrLastName", query = "SELECT a FROM AppUser a WHERE a.usrLastName = :usrLastName"),
    @NamedQuery(name = "AppUser.findByUsrAddress", query = "SELECT a FROM AppUser a WHERE a.usrAddress = :usrAddress"),
    @NamedQuery(name = "AppUser.findByUsrTelephone", query = "SELECT a FROM AppUser a WHERE a.usrTelephone = :usrTelephone"),
    @NamedQuery(name = "AppUser.findByUsrNationality", query = "SELECT a FROM AppUser a WHERE a.usrNationality = :usrNationality"),
    @NamedQuery(name = "AppUser.findByUsrGender", query = "SELECT a FROM AppUser a WHERE a.usrGender = :usrGender"),
    @NamedQuery(name = "AppUser.findByUsrMaritalStatus", query = "SELECT a FROM AppUser a WHERE a.usrMaritalStatus = :usrMaritalStatus"),
    @NamedQuery(name = "AppUser.findByUsrEmail", query = "SELECT a FROM AppUser a WHERE a.usrEmail = :usrEmail")})
public class AppUser extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_id")
    private Integer usrId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usr_first_name")
    private String usrFirstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usr_last_name")
    private String usrLastName;
    @Size(max = 45)
    @Column(name = "usr_address")
    private String usrAddress;
    @Size(max = 45)
    @Column(name = "usr_telephone")
    private String usrTelephone;
    @Size(max = 45)
    @Column(name = "usr_nationality")
    private String usrNationality;
    @Column(name = "usr_gender")
    private Character usrGender;
    @Size(max = 45)
    @Column(name = "usr_marital_status")
    private String usrMaritalStatus;
    @Size(max = 45)
    @Column(name = "usr_email")
    private String usrEmail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appUser")
    private Collection<Review> reviewCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "appUser")
    private FacebookInfo facebookInfo;

    public AppUser() {
    }

    public AppUser(Integer usrId) {
        this.usrId = usrId;
    }

    public AppUser(Integer usrId, String usrFirstName, String usrLastName) {
        this.usrId = usrId;
        this.usrFirstName = usrFirstName;
        this.usrLastName = usrLastName;
    }

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getUsrFirstName() {
        return usrFirstName;
    }

    public void setUsrFirstName(String usrFirstName) {
        this.usrFirstName = usrFirstName;
    }

    public String getUsrLastName() {
        return usrLastName;
    }

    public void setUsrLastName(String usrLastName) {
        this.usrLastName = usrLastName;
    }

    public String getUsrAddress() {
        return usrAddress;
    }

    public void setUsrAddress(String usrAddress) {
        this.usrAddress = usrAddress;
    }

    public String getUsrTelephone() {
        return usrTelephone;
    }

    public void setUsrTelephone(String usrTelephone) {
        this.usrTelephone = usrTelephone;
    }

    public String getUsrNationality() {
        return usrNationality;
    }

    public void setUsrNationality(String usrNationality) {
        this.usrNationality = usrNationality;
    }

    public Character getUsrGender() {
        return usrGender;
    }

    public void setUsrGender(Character usrGender) {
        this.usrGender = usrGender;
    }

    public String getUsrMaritalStatus() {
        return usrMaritalStatus;
    }

    public void setUsrMaritalStatus(String usrMaritalStatus) {
        this.usrMaritalStatus = usrMaritalStatus;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    @XmlTransient
    public Collection<Review> getReviewCollection() {
        return reviewCollection;
    }

    public void setReviewCollection(Collection<Review> reviewCollection) {
        this.reviewCollection = reviewCollection;
    }

    public FacebookInfo getFacebookInfo() {
        return facebookInfo;
    }

    public void setFacebookInfo(FacebookInfo facebookInfo) {
        this.facebookInfo = facebookInfo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usrId != null ? usrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppUser)) {
            return false;
        }
        AppUser other = (AppUser) object;
        if ((this.usrId == null && other.usrId != null) || (this.usrId != null && !this.usrId.equals(other.usrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bgsystems.ireview.model.entities.AppUser[ usrId=" + usrId + " ]";
    }
    
}
