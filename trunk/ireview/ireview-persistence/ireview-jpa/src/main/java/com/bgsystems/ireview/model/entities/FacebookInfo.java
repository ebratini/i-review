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
@Table(name = "facebook_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacebookInfo.findAll", query = "SELECT f FROM FacebookInfo f"),
    @NamedQuery(name = "FacebookInfo.findByUsrId", query = "SELECT f FROM FacebookInfo f WHERE f.usrId = :usrId"),
    @NamedQuery(name = "FacebookInfo.findByFbiEmail", query = "SELECT f FROM FacebookInfo f WHERE f.fbiEmail = :fbiEmail"),
    @NamedQuery(name = "FacebookInfo.findByFbiPhone", query = "SELECT f FROM FacebookInfo f WHERE f.fbiPhone = :fbiPhone"),
    @NamedQuery(name = "FacebookInfo.findByFbiPassword", query = "SELECT f FROM FacebookInfo f WHERE f.fbiPassword = :fbiPassword")})
public class FacebookInfo extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_id")
    private Integer usrId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fbi_email")
    private String fbiEmail;
    @Size(max = 45)
    @Column(name = "fbi_phone")
    private String fbiPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fbi_password")
    private String fbiPassword;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private AppUser appUser;

    public FacebookInfo() {
    }

    public FacebookInfo(Integer usrId) {
        this.usrId = usrId;
    }

    public FacebookInfo(Integer usrId, String fbiEmail, String fbiPassword) {
        this.usrId = usrId;
        this.fbiEmail = fbiEmail;
        this.fbiPassword = fbiPassword;
    }

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getFbiEmail() {
        return fbiEmail;
    }

    public void setFbiEmail(String fbiEmail) {
        this.fbiEmail = fbiEmail;
    }

    public String getFbiPhone() {
        return fbiPhone;
    }

    public void setFbiPhone(String fbiPhone) {
        this.fbiPhone = fbiPhone;
    }

    public String getFbiPassword() {
        return fbiPassword;
    }

    public void setFbiPassword(String fbiPassword) {
        this.fbiPassword = fbiPassword;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
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
        if (!(object instanceof FacebookInfo)) {
            return false;
        }
        FacebookInfo other = (FacebookInfo) object;
        if ((this.usrId == null && other.usrId != null) || (this.usrId != null && !this.usrId.equals(other.usrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bgsystems.ireview.model.entities.FacebookInfo[ usrId=" + usrId + " ]";
    }
    
}
