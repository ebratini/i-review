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
import org.jasypt.util.password.BasicPasswordEncryptor;

/**
 *
 * @author Edwin Bratini
 */
@Entity
@Table(name = "login_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoginInfo.findAll", query = "SELECT l FROM LoginInfo l"),
    @NamedQuery(name = "LoginInfo.findByBusinessContactId", query = "SELECT l FROM LoginInfo l WHERE l.businessContactId = :businessContactId"),
    @NamedQuery(name = "LoginInfo.findByUserName", query = "SELECT l FROM LoginInfo l WHERE l.userName = :userName"),
    @NamedQuery(name = "LoginInfo.findByPassword", query = "SELECT l FROM LoginInfo l WHERE l.password = :password"),
    @NamedQuery(name = "LoginInfo.findBySecurityQuestion", query = "SELECT l FROM LoginInfo l WHERE l.securityQuestion = :securityQuestion"),
    @NamedQuery(name = "LoginInfo.findBySecQuestionAnswer", query = "SELECT l FROM LoginInfo l WHERE l.secQuestionAnswer = :secQuestionAnswer"),
    @NamedQuery(name = "LoginInfo.findByLastLoginDate", query = "SELECT l FROM LoginInfo l WHERE l.lastLoginDate = :lastLoginDate"),
    @NamedQuery(name = "LoginInfo.findByLoginStatus", query = "SELECT l FROM LoginInfo l WHERE l.loginStatus = :loginStatus"),
    @NamedQuery(name = "LoginInfo.findByEmail", query = "SELECT l FROM LoginInfo l WHERE l.email = :email")})
public class LoginInfo extends AbstractEntity implements EntityIdIdentifiable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "business_contact_id")
    private Integer businessContactId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "security_question")
    private String securityQuestion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sec_question_answer")
    private String secQuestionAnswer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_login_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "login_status")
    private char loginStatus;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @JoinColumn(name = "business_contact_id", referencedColumnName = "business_contact_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private BusinessContact businessContact;

    public LoginInfo() {
    }

    public LoginInfo(Integer businessContactId) {
        this.businessContactId = businessContactId;
    }

    public LoginInfo(Integer businessContactId, String userName, String password, String securityQuestion, String secQuestionAnswer, Date lastLoginDate, char loginStatus, String email) {
        this.businessContactId = businessContactId;
        this.userName = userName;
        this.password = password;
        this.securityQuestion = securityQuestion;
        this.secQuestionAnswer = secQuestionAnswer;
        this.lastLoginDate = lastLoginDate;
        this.loginStatus = loginStatus;
        this.email = email;
    }

    public Integer getBusinessContactId() {
        return businessContactId;
    }

    public void setBusinessContactId(Integer businessContactId) {
        this.businessContactId = businessContactId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = new BasicPasswordEncryptor().encryptPassword(password);
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecQuestionAnswer() {
        return secQuestionAnswer;
    }

    public void setSecQuestionAnswer(String secQuestionAnswer) {
        this.secQuestionAnswer = secQuestionAnswer;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public char getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(char loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        hash += (businessContactId != null ? businessContactId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginInfo)) {
            return false;
        }
        LoginInfo other = (LoginInfo) object;
        if ((this.businessContactId == null && other.businessContactId != null) || (this.businessContactId != null && !this.businessContactId.equals(other.businessContactId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bgsystems.ireview.model.entities.LoginInfo[ businessContactId=" + businessContactId + " ]";
    }

    @Override
    public Long getId() {
        return this.getBusinessContactId().longValue();
    }

    public boolean verifyPassword(String password) {
        return new BasicPasswordEncryptor().checkPassword(password, this.password);
    }
}
