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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "review_updates")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReviewUpdate.findAll", query = "SELECT r FROM ReviewUpdate r"),
    @NamedQuery(name = "ReviewUpdate.findByRvuId", query = "SELECT r FROM ReviewUpdate r WHERE r.rvuId = :rvuId"),
    @NamedQuery(name = "ReviewUpdate.findByRvuDate", query = "SELECT r FROM ReviewUpdate r WHERE r.rvuDate = :rvuDate"),
    @NamedQuery(name = "ReviewUpdate.findByRvuRate", query = "SELECT r FROM ReviewUpdate r WHERE r.rvuRate = :rvuRate"),
    @NamedQuery(name = "ReviewUpdate.findByRvuComment", query = "SELECT r FROM ReviewUpdate r WHERE r.rvuComment = :rvuComment")})
public class ReviewUpdate extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "rvu_id")
    private Integer rvuId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rvu_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rvuDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rvu_rate")
    private short rvuRate;
    @Size(max = 45)
    @Column(name = "rvu_comment")
    private String rvuComment;
    @JoinColumn(name = "rvw_id", referencedColumnName = "rvw_id")
    @ManyToOne(optional = false)
    private Review review;

    public ReviewUpdate() {
    }

    public ReviewUpdate(Integer rvuId) {
        this.rvuId = rvuId;
    }

    public ReviewUpdate(Integer rvuId, Date rvuDate, short rvuRate) {
        this.rvuId = rvuId;
        this.rvuDate = rvuDate;
        this.rvuRate = rvuRate;
    }

    public Integer getRvuId() {
        return rvuId;
    }

    public void setRvuId(Integer rvuId) {
        this.rvuId = rvuId;
    }

    public Date getRvuDate() {
        return rvuDate;
    }

    public void setRvuDate(Date rvuDate) {
        this.rvuDate = rvuDate;
    }

    public short getRvuRate() {
        return rvuRate;
    }

    public void setRvuRate(short rvuRate) {
        this.rvuRate = rvuRate;
    }

    public String getRvuComment() {
        return rvuComment;
    }

    public void setRvuComment(String rvuComment) {
        this.rvuComment = rvuComment;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rvuId != null ? rvuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReviewUpdate)) {
            return false;
        }
        ReviewUpdate other = (ReviewUpdate) object;
        if ((this.rvuId == null && other.rvuId != null) || (this.rvuId != null && !this.rvuId.equals(other.rvuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bgsystems.ireview.model.entities.ReviewUpdate[ rvuId=" + rvuId + " ]";
    }
    
}
