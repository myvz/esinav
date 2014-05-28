package com.esinav.ejb.entity;
import java.util.Date;
import java.util.List;
import javax.persistence.*;


/**
 *
 * @author Leyla
 */
@Entity
public class Sinav {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "SINAV_ADI")       
    private String sinavAdi;
    
    @Column(name="SINAV_ZAMANI")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date sinavZamani;
    
    @Column(name="SINAV_SURESI")
    private Integer sinavSuresi;
    
    @Column(name="SINAV_ACIKLAMASI")
    private String sinavAciklamasi;
    
    @ManyToMany
    private List<Kullanici> kullanicilar;//Sinavi alacak kullanicilar
    
    @JoinColumn(name="SINAV_SAHIBI_ID")
    @ManyToOne
    private Kullanici sinavSahibi;
    
    @JoinTable(name = "SINAV_SORU",joinColumns ={@JoinColumn(name = "SINAV_ID")},inverseJoinColumns = {@JoinColumn(name = "SORU_ID")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Soru> sorular; 


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSinavAdi() {
        return sinavAdi;
    }

    public void setSinavAdi(String sinavAdi) {
        this.sinavAdi = sinavAdi;
    }

    public Date getSinavZamani() {
        return sinavZamani;
    }

    public void setSinavZamani(Date sinavZamani) {
        this.sinavZamani = sinavZamani;
    }

    public Integer getSinavSuresi() {
        return sinavSuresi;
    }

    public void setSinavSuresi(Integer sinavSuresi) {
        this.sinavSuresi = sinavSuresi;
    }

    public String getSinavAciklamasi() {
        return sinavAciklamasi;
    }

    public void setSinavAciklamasi(String sinavAciklamasi) {
        this.sinavAciklamasi = sinavAciklamasi;
    }

    public List<Kullanici> getKullanicilar() {
        return kullanicilar;
    }

    public void setKullanicilar(List<Kullanici> kullanicilar) {
        this.kullanicilar = kullanicilar;
    }

    public Kullanici getSinavSahibi() {
        return sinavSahibi;
    }

    public void setSinavSahibi(Kullanici sinavSahibi) {
        this.sinavSahibi = sinavSahibi;
    }

    public List<Soru> getSorular() {
        return sorular;
    }

    public void setSorular(List<Soru> sorular) {
        this.sorular = sorular;
    }


}
