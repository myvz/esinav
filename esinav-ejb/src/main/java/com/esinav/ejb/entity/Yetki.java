package com.esinav.ejb.entity;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leyla
 */
@Entity
public class Yetki {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "YETKI_ADI")
    private String yetkiAdi;
    @Column(name="YETKI_ACIKLAMA")
    private String yetkiAciklama;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYetkiAdi() {
        return yetkiAdi;
    }

    public void setYetkiAdi(String yetkiAdi) {
        this.yetkiAdi = yetkiAdi;
    }

    public String getYetkiAciklama() {
        return yetkiAciklama;
    }

    public void setYetkiAciklama(String yetkiAciklamasi) {
        this.yetkiAciklama = yetkiAciklamasi;
    }

}
