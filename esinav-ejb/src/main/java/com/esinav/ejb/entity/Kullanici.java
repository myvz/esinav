package com.esinav.ejb.entity;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQuery(name="Kullanici.findKullaniciByUsername",query = "SELECT k FROM Kullanici k where k.username=:username")
public class Kullanici {
    
    public static final String FIND_BY_USERNAME="Kullanici.findKullaniciByUsername";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name="ADI")
    private String adi;
    @Column(name = "SOYADI")
    private String soyadi;
    @Column(name="PASSWORD")
    private String password;
   
    @JoinTable(name = "KULLANICI_ROL",joinColumns = {@JoinColumn(name = "KULLANICI_ID")},inverseJoinColumns = {@JoinColumn(name = "ROL_ID")})
    @ManyToMany
    private List<Rol> roller; //her kullanici 1 den fazla role sahiptir. 
    @JoinTable(name = "KULLANICI_SINAV",joinColumns = {@JoinColumn(name = "KULLANICI_ID")},inverseJoinColumns = {@JoinColumn(name = "SINAV_ID")})
    @ManyToMany
    private List<Sinav> sinavlar;
    
    @JoinColumn(name = "KULLANICI_ID")
    @OneToMany
    private List<CevapAnahtari> cevaplar;

    public Collection<CevapAnahtari> getCevaplar() {
        return cevaplar;
    }   

    public void setCevaplar(List<CevapAnahtari> cevaplar) {
        this.cevaplar = cevaplar;
    }

    public Collection<Sinav> getSinavlar() {
        return sinavlar;
    }

    public void setSinavlar(List<Sinav> sinavlar) {
        this.sinavlar = sinavlar;
    }
          

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public Collection<Rol> getRoller() {
        return roller;
    }

    public void setRoller(List<Rol> roller) {
        this.roller = roller;
    }
   
           
}
