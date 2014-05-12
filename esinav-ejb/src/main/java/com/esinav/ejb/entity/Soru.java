package com.esinav.ejb.entity;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * @author Leyla
 */

@Entity
public class Soru {
    
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY )
   private Long id;
   
   @Column(name = "SORU")
   private String soru;
   
   @JoinColumn(name = "UNITE_ID")
   @ManyToOne
   private Unite unite;//Her soru bir üniteye aittir
   
   @JoinTable(name="SORU_SECENEK",joinColumns={@JoinColumn(name = "SORU_ID")},inverseJoinColumns = {@JoinColumn(name = "SECENEK_ID")})
   @OneToMany(cascade = CascadeType.PERSIST)
   private List<Secenek> secenekler;//Her sorunun 1 veya daha fazla seceneği vardır
   
   @JoinColumn(name = "DOGRU_SECENEK_ID",insertable = true,updatable = true)
   @OneToOne(cascade = CascadeType.PERSIST)
   private Secenek dogruSecenek;// Her sorunun bir do ğru cevabı vardır 

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoru() {
        return soru;
    }

    public void setSoru(String Soru) {
        this.soru = Soru;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }

    public Collection<Secenek> getSecenekler() {
        return secenekler;
    }

    public void setSecenekler(List<Secenek> secenekler) {
        this.secenekler = secenekler;
    }

    public Secenek getDogruSecenek() {
        return dogruSecenek;
    }

    public void setDogruSecenek(Secenek dogruSecenek) {
        this.dogruSecenek = dogruSecenek;
    }


    
}
