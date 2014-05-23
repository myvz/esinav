/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.entity;

import org.hibernate.engine.FetchStrategy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author myavuz
 */
@Entity
@NamedQuery(name="Ders.findDersByName",query = "SELECT d FROM Ders d left join fetch d.uniteler where d.dersAdi=:dersadi")
public class Ders implements Serializable {
    private static final long serialVersionUID = 1L;
    public static String FIND_BY_NAME="Ders.findDersByName";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "DERS_ADI")
    private String dersAdi;
    
    @JoinColumn(name = "DERS_ID")
    @OneToMany
    private List<Unite> uniteler=new ArrayList<Unite>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDersAdi() {
        return dersAdi;
    }

    public void setDersAdi(String dersAdi) {
        this.dersAdi = dersAdi;
    }

    public List<Unite> getUniteler() {
        return uniteler;
    }

    public void setUniteler(List<Unite> uniteler) {
        this.uniteler = uniteler;
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
        if (object==null) {
            return false;
        }

        if (!(object instanceof Ders)) {
            return false;
        }
        Ders other = (Ders) object;
        if (this.getDersAdi().equals(other.getDersAdi())) {
            return true;
        }


        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return dersAdi;
    }
    
}
