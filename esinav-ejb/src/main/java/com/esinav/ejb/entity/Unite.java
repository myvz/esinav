/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author myavuz
 */
@Entity
public class Unite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "UNITA_ADI")
    private String uniteAdi;
    
    @Column(name="SEVIYE")
    private Integer seviye;
    
    @JoinColumn(name="DERS_ID",insertable = false,updatable = false)
    @ManyToOne
    private Ders ders;    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniteAdi() {
        return uniteAdi;
    }

    public void setUniteAdi(String uniteAdi) {
        this.uniteAdi = uniteAdi;
    }

    public Integer getSeviye() {
        return seviye;
    }

    public void setSeviye(Integer seviye) {
        this.seviye = seviye;
    }

    public Ders getDers() {
        return ders;
    }

    public void setDers(Ders ders) {
        this.ders = ders;
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
        if (!(object instanceof Unite)) {
            return false;
        }
        Unite other = (Unite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.esinav.ejb.entity.Unite[ id=" + id + " ]";
    }
    
}
