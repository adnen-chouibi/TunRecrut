/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.tunRecrut.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author app4mob
 */
@Entity
@Table(name = "annonce")
@NamedQueries({
    @NamedQuery(name = "Annonce.findAll", query = "SELECT a FROM Annonce a")})
public class Annonce implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "type")
    private Integer type;
    @Lob
    @Column(name = "Content")
    private String content;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "is_active")
    private Integer isActive;
    @JoinTable(name = "annonce_has_metier", joinColumns = {
        @JoinColumn(name = "annonce_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "metier_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Metier> metierCollection;
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Region regionId;
    @JoinColumn(name = "niveau_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Niveau niveauId;
    @JoinColumn(name = "type_emploi_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TypeEmploi typeEmploiId;
    @JoinColumn(name = "experience_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Experience experienceId;
    @JoinColumn(name = "contrat_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Contrat contratId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "annonce")
    private Collection<Candidature> candidatureCollection;

    public Annonce() {
    }

    public Annonce(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Collection<Metier> getMetierCollection() {
        return metierCollection;
    }

    public void setMetierCollection(Collection<Metier> metierCollection) {
        this.metierCollection = metierCollection;
    }

    public Region getRegionId() {
        return regionId;
    }

    public void setRegionId(Region regionId) {
        this.regionId = regionId;
    }

    public Niveau getNiveauId() {
        return niveauId;
    }

    public void setNiveauId(Niveau niveauId) {
        this.niveauId = niveauId;
    }

    public TypeEmploi getTypeEmploiId() {
        return typeEmploiId;
    }

    public void setTypeEmploiId(TypeEmploi typeEmploiId) {
        this.typeEmploiId = typeEmploiId;
    }

    public Experience getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(Experience experienceId) {
        this.experienceId = experienceId;
    }

    public Contrat getContratId() {
        return contratId;
    }

    public void setContratId(Contrat contratId) {
        this.contratId = contratId;
    }

    public Collection<Candidature> getCandidatureCollection() {
        return candidatureCollection;
    }

    public void setCandidatureCollection(Collection<Candidature> candidatureCollection) {
        this.candidatureCollection = candidatureCollection;
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
        if (!(object instanceof Annonce)) {
            return false;
        }
        Annonce other = (Annonce) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.esprit.tunRecrut.entities.Annonce[ id=" + id + " ]";
    }
    
}
