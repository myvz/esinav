package com.esinav.bean;

import com.esinav.ejb.entity.CevapAnahtari;
import com.esinav.ejb.entity.Kullanici;
import com.esinav.ejb.entity.Sinav;
import com.esinav.ejb.ifacade.CevapAnahtariFacadeLocal;
import com.esinav.ejb.ifacade.SinavFacadeLocal;
import org.primefaces.event.SelectEvent;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created by myavuz on 02.06.2014.
 */

@ManagedBean
@ViewScoped
public class SinavSorgulamaMBean implements Serializable{

    private List<Sinav> sahipSinavList;
    private List<CevapAnahtari>  cevapAnahtariList;

    private Sinav selectedSinav;


    @EJB
    private SinavFacadeLocal sinavFacadeLocal;

    @EJB
    private CevapAnahtariFacadeLocal cevapAnahtariFacade;


    @ManagedProperty(value = "#{loginController.kullanici}")
    private Kullanici kullanici;


    @PostConstruct
    public void init() {
        sahipSinavList=sinavFacadeLocal.getSinavSahipSinav(kullanici);
    }

    public List<Sinav> getSahipSinavList() {
        return sahipSinavList;
    }

    public void setSahipSinavList(List<Sinav> sahipSinav) {
        this.sahipSinavList = sahipSinav;
    }

    public List<CevapAnahtari> getCevapAnahtariList() {
        return cevapAnahtariList;
    }

    public void setCevapAnahtariList(List<CevapAnahtari> cevapAnahtariList) {
        this.cevapAnahtariList = cevapAnahtariList;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public Sinav getSelectedSinav() {
        return selectedSinav;
    }

    public void setSelectedSinav(Sinav selectedSinav) {
        this.selectedSinav = selectedSinav;
    }
    public void onRowSelect(SelectEvent event) {
        cevapAnahtariList=cevapAnahtariFacade.findAll(selectedSinav);
    }
}
