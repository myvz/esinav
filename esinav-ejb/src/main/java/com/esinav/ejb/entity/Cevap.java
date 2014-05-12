package com.esinav.ejb.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cevap implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JoinColumn(name = "SORU_ID")
    @ManyToOne
    private Soru soru;
    
    @JoinColumn(name="SECENEK_ID")
    @ManyToOne
    private Secenek kullaniciCevabi;
    
    @JoinColumn(name="CEVAP_ANAHTARI_ID",insertable = false,updatable = false)
    @ManyToOne
    private CevapAnahtari cevapAnahtari;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    
    public Soru getSoru() {
        return soru;
    }

    public void setSoru(Soru soru) {
        this.soru = soru;
    }

    public Secenek getKullaniciCevabi() {
        return kullaniciCevabi;
    }

    public void setKullaniciCevabi(Secenek kullaniciCevabi) {
        this.kullaniciCevabi = kullaniciCevabi;
    }

}
