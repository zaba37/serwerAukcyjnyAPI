/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author zaba37
 */
@Entity
@Table(name = "BID")
@NamedQueries({
    @NamedQuery(name = "Bid.findAll", query = "SELECT b FROM Bid b"),
    @NamedQuery(name = "Bid.findById", query = "SELECT b FROM Bid b WHERE b.id = :id"),
    @NamedQuery(name = "Bid.findByBiddate", query = "SELECT b FROM Bid b WHERE b.biddate = :biddate"),
    @NamedQuery(name = "Bid.findByOffer", query = "SELECT b FROM Bid b WHERE b.offer = :offer")})
public class Bid implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "BIDDATE")
    @Temporal(TemporalType.DATE)
    private Date biddate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "OFFER")
    private Double offer;
    @JoinColumn(name = "ID_AUCTION", referencedColumnName = "ID")
    @ManyToOne
    private Auction idAuction;
    @JoinColumn(name = "ID_CUSTOMER", referencedColumnName = "ID")
    @ManyToOne
    private Customer idCustomer;

    public Bid() {
    }

    public Bid(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBiddate() {
        return biddate;
    }

    public void setBiddate(Date biddate) {
        this.biddate = biddate;
    }

    public Double getOffer() {
        return offer;
    }

    public void setOffer(Double offer) {
        this.offer = offer;
    }

    public Auction getIdAuction() {
        return idAuction;
    }

    public void setIdAuction(Auction idAuction) {
        this.idAuction = idAuction;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bid)) {
            return false;
        }
        Bid other = (Bid) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Bid[ id=" + id + " ]";
    }
    
}
