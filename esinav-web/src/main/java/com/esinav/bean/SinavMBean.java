package com.esinav.bean;

import com.esinav.controller.LoginController;
import com.esinav.ejb.entity.*;
import com.esinav.ejb.ifacade.CevapAnahtariFacadeLocal;
import com.esinav.ejb.ifacade.SinavFacadeLocal;
import org.primefaces.event.SelectEvent;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.*;


@ManagedBean
@ViewScoped
public class SinavMBean implements Serializable {


    private List<Sinav> sinavList;

    private Sinav selectedSinav;

    private Secenek selectedSecenek;

    private CevapAnahtari cevapAnahtari;

    private Map<Soru,Cevap> cevapMap;

    private boolean isTaken=false;

    @EJB
    private CevapAnahtariFacadeLocal cevapAnahtariFacade;

    @Inject
    private LoginController loginController;

    @EJB
    private SinavFacadeLocal sinavFacade;

    @PostConstruct
    public void init() {
        sinavList=sinavFacade.getKullaniciSinav(loginController.getKullanici());
        cevapAnahtari=new CevapAnahtari();
        cevapAnahtari.setKullanici(loginController.getKullanici());
        cevapMap=new HashMap<Soru,Cevap>();
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    public List<Sinav> getSinavList() {
        return sinavList;
    }

    public void setSinavList(List<Sinav> sinavList) {
        this.sinavList = sinavList;
    }

    public Sinav getSelectedSinav() {
        return selectedSinav;
    }

    public void setSelectedSinav(Sinav selectedSinav) {
        this.selectedSinav = selectedSinav;
        selectedSinav.getSorular();
        for(Soru soru :selectedSinav.getSorular()) {
            Collections.shuffle((List<?>) soru.getSecenekler());
        }
        Collections.shuffle(selectedSinav.getSorular());
    }

    public void onRowSelect(SelectEvent event) {
        Cevap cevap=new Cevap();
        cevap.setSoru(getSelectedSoru());
        cevap.setKullaniciCevabi(selectedSecenek);
        cevapMap.put(getSelectedSoru(),cevap);
    }

    public Secenek getSelectedSecenek() {
        return selectedSecenek;
    }

    public void setSelectedSecenek(Secenek selectedSecenek) {
        this.selectedSecenek = selectedSecenek;
    }

    public void save() {
        cevapAnahtari.setSinav(selectedSinav);
        cevapAnahtari.setCevaplar(new ArrayList<Cevap>(cevapMap.values()));
        cevapAnahtariFacade.save(cevapAnahtari);
        isTaken=true;
    }
    private Soru getSelectedSoru() {

        for (Soru soru:selectedSinav.getSorular()) {
            if (soru.getSecenekler().contains(selectedSecenek)) return soru;
        }
        return null;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean isTaken) {
        this.isTaken = isTaken;
    }

    public Integer getCevapCount() {
          return cevapAnahtari.getCevaplar().size();
    }

    public Integer getDogruSayisi() {
        Integer counter=0;
        for (Soru soru :selectedSinav.getSorular()) {
            if (cevapMap.get(soru).getKullaniciCevabi()==soru.getDogruSecenek()) {
               counter++;
            }
        }
        return counter;
    }
    public Integer getYanlisSayisi() {
        return getCevapCount()-getDogruSayisi();
    }
}
