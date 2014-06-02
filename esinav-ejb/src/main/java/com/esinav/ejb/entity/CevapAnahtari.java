package com.esinav.ejb.entity;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;

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

@Column(name="YANLIS_SAYISI")
private Integer yanlisSayisi;
@Column(name="CEVAP_SAYISI")
private Integer cevapSayisi;
@Column(name="DOGRU_SAYISI")
private Integer dogruSayisi;
  
/*  @JoinTable(name = "CEVAP_ANAHTARI_CEVAP",joinColumns = {@JoinColumn(name="CEVAP_ANAHTARI_ID")},
          inverseJoinColumns = {@JoinColumn(name = "CEVAP_ID")})*/
  @JoinColumn(name = "CEVAP_ANAHTARI_ID")
  @OneToMany(cascade = CascadeType.PERSIST)
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


    public Integer getYanlisSayisi() {
        return yanlisSayisi;
    }

    public void setYanlisSayisi(Integer yanlisSayisi) {
        this.yanlisSayisi = yanlisSayisi;
    }

    public Integer getCevapSayisi() {
        return cevapSayisi;
    }

    public void setCevapSayisi(Integer cevapSayisi) {
        this.cevapSayisi = cevapSayisi;
    }

    public Integer getDogruSayisi() {
        return dogruSayisi;
    }

    public void setDogruSayisi(Integer dogruSayisi) {
        this.dogruSayisi = dogruSayisi;
    }
}
