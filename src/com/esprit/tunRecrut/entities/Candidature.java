/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.tunRecrut.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Haithem
 */
@Entity
@Table(name = "candidature")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidature.findAll", query = "SELECT c FROM Candidature c"),
    @NamedQuery(name = "Candidature.findByAnnonceId", query = "SELECT c FROM Candidature c WHERE c.candidaturePK.annonceId = :annonceId"),
    @NamedQuery(name = "Candidature.findByUserId", query = "SELECT c FROM Candidature c WHERE c.candidaturePK.userId = :userId"),
    @NamedQuery(name = "Candidature.findByCv", query = "SELECT c FROM Candidature c WHERE c.cv = :cv"),
    @NamedQuery(name = "Candidature.findByMotivation", query = "SELECT c FROM Candidature c WHERE c.motivation = :motivation"),
    @NamedQuery(name = "Candidature.findByCreatedAt", query = "SELECT c FROM Candidature c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "Candidature.findByStatus", query = "SELECT c FROM Candidature c WHERE c.status = :status")})
public class Candidature implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CandidaturePK candidaturePK;
    @Column(name = "cv")
    private String cv;
    @Column(name = "motivation")
    private String motivation;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "annonce_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Annonce annonce;

    public Candidature() {
    }

    public Candidature(CandidaturePK candidaturePK) {
        this.candidaturePK = candidaturePK;
    }

    public Candidature(int annonceId, int userId) {
        this.candidaturePK = new CandidaturePK(annonceId, userId);
    }

    public CandidaturePK getCandidaturePK() {
        return candidaturePK;
    }

    public void setCandidaturePK(CandidaturePK candidaturePK) {
        this.candidaturePK = candidaturePK;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (candidaturePK != null ? candidaturePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidature)) {
            return false;
        }
        Candidature other = (Candidature) object;
        if ((this.candidaturePK == null && other.candidaturePK != null) || (this.candidaturePK != null && !this.candidaturePK.equals(other.candidaturePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.esprit.tunRecrut.entities.Candidature[ candidaturePK=" + candidaturePK + " ]";
    }
    
}
