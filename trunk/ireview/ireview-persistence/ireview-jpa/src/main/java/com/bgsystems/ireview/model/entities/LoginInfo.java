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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Edwin Bratini
 */
@Entity
@Table(name = "login_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoginInfo.findAll", query = "SELECT l FROM LoginInfo l"),
    @NamedQuery(name = "LoginInfo.findByBcoId", query = "SELECT l FROM LoginInfo l WHERE l.bcoId = :bcoId"),
    @NamedQuery(name = "LoginInfo.findByLgiUserName", query = "SELECT l FROM LoginInfo l WHERE l.lgiUserName = :lgiUserName"),
    @NamedQuery(name = "LoginInfo.findByLgiPassword", query = "SELECT l FROM LoginInfo l WHERE l.lgiPassword = :lgiPassword"),
    @NamedQuery(name = "LoginInfo.findByLgiSecurityQuestion", query = "SELECT l FROM LoginInfo l WHERE l.lgiSecurityQuestion = :lgiSecurityQuestion"),
    @NamedQuery(name = "LoginInfo.findByLgiSecQuestionAnswer", query = "SELECT l FROM LoginInfo l WHERE l.lgiSecQuestionAnswer = :lgiSecQuestionAnswer"),
    @NamedQuery(name = "LoginInfo.findByLgiLastLoginDate", query = "SELECT l FROM LoginInfo l WHERE l.lgiLastLoginDate = :lgiLastLoginDate"),
    @NamedQuery(name = "LoginInfo.findByLgiLoginStatus", query = "SELECT l FROM LoginInfo l WHERE l.lgiLoginStatus = :lgiLoginStatus")})
public class LoginInfo extends AbstractEntity {
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
    @Column(name = "lgi_user_name")
    private String lgiUserName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lgi_password")
    private String lgiPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lgi_security_question")
    private String lgiSecurityQuestion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lgi_sec_question_answer")
    private String lgiSecQuestionAnswer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lgi_last_login_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lgiLastLoginDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lgi_login_status")
    private char lgiLoginStatus;
    @JoinColumn(name = "bco_id", referencedColumnName = "bco_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private BusinessContact businessContact;

    public LoginInfo() {
    }

    public LoginInfo(String bcoId) {
        this.bcoId = bcoId;
    }

    public LoginInfo(String bcoId, String lgiUserName, String lgiPassword, String lgiSecurityQuestion, String lgiSecQuestionAnswer, Date lgiLastLoginDate, char lgiLoginStatus) {
        this.bcoId = bcoId;
        this.lgiUserName = lgiUserName;
        this.lgiPassword = lgiPassword;
        this.lgiSecurityQuestion = lgiSecurityQuestion;
        this.lgiSecQuestionAnswer = lgiSecQuestionAnswer;
        this.lgiLastLoginDate = lgiLastLoginDate;
        this.lgiLoginStatus = lgiLoginStatus;
    }

    public String getBcoId() {
        return bcoId;
    }

    public void setBcoId(String bcoId) {
        this.bcoId = bcoId;
    }

    public String getLgiUserName() {
        return lgiUserName;
    }

    public void setLgiUserName(String lgiUserName) {
        this.lgiUserName = lgiUserName;
    }

    public String getLgiPassword() {
        return lgiPassword;
    }

    public void setLgiPassword(String lgiPassword) {
        this.lgiPassword = lgiPassword;
    }

    public String getLgiSecurityQuestion() {
        return lgiSecurityQuestion;
    }

    public void setLgiSecurityQuestion(String lgiSecurityQuestion) {
        this.lgiSecurityQuestion = lgiSecurityQuestion;
    }

    public String getLgiSecQuestionAnswer() {
        return lgiSecQuestionAnswer;
    }

    public void setLgiSecQuestionAnswer(String lgiSecQuestionAnswer) {
        this.lgiSecQuestionAnswer = lgiSecQuestionAnswer;
    }

    public Date getLgiLastLoginDate() {
        return lgiLastLoginDate;
    }

    public void setLgiLastLoginDate(Date lgiLastLoginDate) {
        this.lgiLastLoginDate = lgiLastLoginDate;
    }

    public char getLgiLoginStatus() {
        return lgiLoginStatus;
    }

    public void setLgiLoginStatus(char lgiLoginStatus) {
        this.lgiLoginStatus = lgiLoginStatus;
    }

    public BusinessContact getBusinessContact() {
        return businessContact;
    }

    public void setBusinessContact(BusinessContact businessContact) {
        this.businessContact = businessContact;
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
        if (!(object instanceof LoginInfo)) {
            return false;
        }
        LoginInfo other = (LoginInfo) object;
        if ((this.bcoId == null && other.bcoId != null) || (this.bcoId != null && !this.bcoId.equals(other.bcoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bgsystems.ireview.model.entities.LoginInfo[ bcoId=" + bcoId + " ]";
    }
    
}
