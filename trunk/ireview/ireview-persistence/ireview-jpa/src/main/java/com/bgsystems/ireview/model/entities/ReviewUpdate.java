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
    @NamedQuery(name = "ReviewUpdate.findByReviewUpdateId", query = "SELECT r FROM ReviewUpdate r WHERE r.reviewUpdateId = :reviewUpdateId"),
    @NamedQuery(name = "ReviewUpdate.findByDate", query = "SELECT r FROM ReviewUpdate r WHERE r.date = :date"),
    @NamedQuery(name = "ReviewUpdate.findByRate", query = "SELECT r FROM ReviewUpdate r WHERE r.rate = :rate"),
    @NamedQuery(name = "ReviewUpdate.findByComment", query = "SELECT r FROM ReviewUpdate r WHERE r.comment = :comment")})
public class ReviewUpdate extends AbstractEntity implements EntityIdIdentifiable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "review_update_id")
    private Integer reviewUpdateId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rate")
    private short rate;
    @Size(max = 45)
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "review_id", referencedColumnName = "review_id")
    @ManyToOne(optional = false)
    private Review review;

    public ReviewUpdate() {
    }

    public ReviewUpdate(Integer reviewUpdateId) {
        this.reviewUpdateId = reviewUpdateId;
    }

    public ReviewUpdate(Integer reviewUpdateId, Date date, short rate) {
        this.reviewUpdateId = reviewUpdateId;
        this.date = date;
        this.rate = rate;
    }

    public Integer getReviewUpdateId() {
        return reviewUpdateId;
    }

    public void setReviewUpdateId(Integer reviewUpdateId) {
        this.reviewUpdateId = reviewUpdateId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public short getRate() {
        return rate;
    }

    public void setRate(short rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        hash += (reviewUpdateId != null ? reviewUpdateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReviewUpdate)) {
            return false;
        }
        ReviewUpdate other = (ReviewUpdate) object;
        if ((this.reviewUpdateId == null && other.reviewUpdateId != null) || (this.reviewUpdateId != null && !this.reviewUpdateId.equals(other.reviewUpdateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bgsystems.ireview.model.entities.ReviewUpdate[ reviewUpdateId=" + reviewUpdateId + " ]";
    }

    @Override
    public Long getId() {
        return this.getReviewUpdateId().longValue();
    }
    
}
