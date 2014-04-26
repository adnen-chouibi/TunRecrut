/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.tunRecrut.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author app4mob
 */
@Embeddable
public class CandidaturePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "annonce_id")
    private int annonceId;
    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;

    public CandidaturePK() {
    }

    public CandidaturePK(int annonceId, int userId) {
        this.annonceId = annonceId;
        this.userId = userId;
    }

    public int getAnnonceId() {
        return annonceId;
    }

    public void setAnnonceId(int annonceId) {
        this.annonceId = annonceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) annonceId;
        hash += (int) userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CandidaturePK)) {
            return false;
        }
        CandidaturePK other = (CandidaturePK) object;
        if (this.annonceId != other.annonceId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.esprit.tunRecrut.entities.CandidaturePK[ annonceId=" + annonceId + ", userId=" + userId + " ]";
    }
    
}
