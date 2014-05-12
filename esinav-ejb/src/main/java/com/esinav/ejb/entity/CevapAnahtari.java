package com.esinav.ejb.entity;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table(name = "CEVAP_ANAHTARI")
public class CevapAnahtari implements Serializable{
  
  @Id
  @GeneratedValue(strategy =GenerationType.IDENTITY)
  private Long id;
  
/*  @JoinTable(name = "CEVAP_ANAHTARI_CEVAP",joinColumns = {@JoinColumn(name="CEVAP_ANAHTARI_ID")},
          inverseJoinColumns = {@JoinColumn(name = "CEVAP_ID")})*/
  @JoinColumn(name = "CEVAP_ANAHTARI_ID")
  @OneToMany
  private List<Cevap> cevaplar;
  
  @JoinColumn(name = "SINAV_ID")
  @ManyToOne
  private Sinav sinav;
  
  @JoinColumn(name = "KULLANICI_ID")
  @OneToOne
  private Kullanici kullanici;

  public Long getId() {
        return id;
  }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Cevap> getCevaplar() {
        return cevaplar;
    }

    public void setCevaplar(List<Cevap> cevaplar) {
        this.cevaplar = cevaplar;
    }

    public Sinav getSinav() {
        return sinav;
    }

    public void setSinav(Sinav sinav) {
        this.sinav = sinav;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

}
