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


@Entity
public class Rol {
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    @Column(name="ROL_ADI")
    private String rolAdi;
    @Column(name="ROL_ACIKLAMA")
    private String rolAciklama;
    
    @JoinTable(name = "ROL_YETKI",joinColumns = {@JoinColumn(name = "ROL_ID")},inverseJoinColumns = {@JoinColumn(name = "YETKI_ID")})
    @ManyToMany
    private List<Yetki> yetkiler;//Her bir rol 1 veya daha fazla yetkiye sahiptir

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolAdi() {
        return rolAdi;
    }

    public void setRolAdi(String rolAdi) {
        this.rolAdi = rolAdi;
    }

    public String getRolAciklama() {
        return rolAciklama;
    }

    public void setRolAciklama(String rolAciklama) {
        this.rolAciklama = rolAciklama;
    }

    public Collection<Yetki> getYetkiler() {
        return yetkiler;
    }

    public void setYetkiler(List<Yetki> yetkiler) {
        this.yetkiler = yetkiler;
    }
    
}
