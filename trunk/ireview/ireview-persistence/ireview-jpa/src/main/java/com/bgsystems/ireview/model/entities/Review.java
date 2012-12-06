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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edwin Bratini
 */
@Entity
@Table(name = "reviews")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Review.findAll", query = "SELECT r FROM Review r"),
    @NamedQuery(name = "Review.findByRvwId", query = "SELECT r FROM Review r WHERE r.rvwId = :rvwId"),
    @NamedQuery(name = "Review.findByRvwDate", query = "SELECT r FROM Review r WHERE r.rvwDate = :rvwDate"),
    @NamedQuery(name = "Review.findByRvwRate", query = "SELECT r FROM Review r WHERE r.rvwRate = :rvwRate"),
    @NamedQuery(name = "Review.findByRvwComment", query = "SELECT r FROM Review r WHERE r.rvwComment = :rvwComment")})
public class Review extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "rvw_id")
    private Integer rvwId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rvw_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rvwDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rvw_rate")
    private short rvwRate;
    @Size(max = 45)
    @Column(name = "rvw_comment")
    private String rvwComment;
    @JoinColumn(name = "cty_id", referencedColumnName = "cty_id")
    @ManyToOne(optional = false)
    private Commodity commodity;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
    private AppUser appUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "review")
    private Collection<ReviewUpdate> reviewUpdateCollection;

    public Review() {
    }

    public Review(Integer rvwId) {
        this.rvwId = rvwId;
    }

    public Review(Integer rvwId, Date rvwDate, short rvwRate) {
        this.rvwId = rvwId;
        this.rvwDate = rvwDate;
        this.rvwRate = rvwRate;
    }

    public Integer getRvwId() {
        return rvwId;
    }

    public void setRvwId(Integer rvwId) {
        this.rvwId = rvwId;
    }

    public Date getRvwDate() {
        return rvwDate;
    }

    public void setRvwDate(Date rvwDate) {
        this.rvwDate = rvwDate;
    }

    public short getRvwRate() {
        return rvwRate;
    }

    public void setRvwRate(short rvwRate) {
        this.rvwRate = rvwRate;
    }

    public String getRvwComment() {
        return rvwComment;
    }

    public void setRvwComment(String rvwComment) {
        this.rvwComment = rvwComment;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    @XmlTransient
    public Collection<ReviewUpdate> getReviewUpdateCollection() {
        return reviewUpdateCollection;
    }

    public void setReviewUpdateCollection(Collection<ReviewUpdate> reviewUpdateCollection) {
        this.reviewUpdateCollection = reviewUpdateCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rvwId != null ? rvwId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Review)) {
            return false;
        }
        Review other = (Review) object;
        if ((this.rvwId == null && other.rvwId != null) || (this.rvwId != null && !this.rvwId.equals(other.rvwId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bgsystems.ireview.model.entities.Review[ rvwId=" + rvwId + " ]";
    }
    
}
