package com.esinav.bean;

import com.esinav.ejb.entity.Ders;
import com.esinav.ejb.entity.Secenek;
import com.esinav.ejb.entity.Soru;
import com.esinav.ejb.entity.Unite;
import com.esinav.ejb.ifacade.DersFacadeLocal;
import com.esinav.ejb.ifacade.SoruFacadeLocal;
import com.esinav.ejb.ifacade.UniteFacadeLocal;
import org.primefaces.event.FlowEvent;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by myavuz on 20.05.2014.
 */
@ManagedBean
@ViewScoped

public class SoruWizardMBean implements Serializable {

    private Unite unite;
    private Soru soru = new Soru();
    private Secenek secenek1 = new Secenek();
    private Secenek secenek2 = new Secenek();
    private Secenek secenek3 = new Secenek();
    private Secenek secenek4 = new Secenek();
    private Secenek dogruSecenek = new Secenek();

    private Ders ders;


    private List<Unite> uniteList;
    private List<Ders> dersList;

    @EJB
    private DersFacadeLocal dersFacede;

    @EJB
    private UniteFacadeLocal uniteFacade;

    @EJB
    private SoruFacadeLocal soruFacade;

    private boolean skip;

    @PostConstruct
    public void init() {
        dersList = getDersList();
    }


    public List<Ders> getDersList() {
        if (dersList != null) return dersList;
        dersList = dersFacede.findAll();
        return dersList;
    }

    public List<Unite> getUniteList() {

        uniteList = ders.getUniteler();
        return uniteList;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }


    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }


    public void save() {
        soru.setDogruSecenek(secenek1);
        List<Secenek> secenekList =new ArrayList<>();
        secenekList.add(secenek1);
        secenekList.add(secenek2);
        secenekList.add(secenek3);
        secenekList.add(secenek4);
        soru.setSecenekler(secenekList);
        soru.setDogruSecenek(secenek1);
        soru.setUnite(unite);
        soruFacade.save(soru);

    }

    public Soru getSoru() {
        return soru;
    }

    public void setSoru(Soru soru) {
        this.soru = soru;
    }

    public Ders getDers() {
        return ders;
    }

    public void setDers(Ders ders) {
        this.ders = ders;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }

    public Secenek getSecenek1() {
        return secenek1;
    }

    public void setSecenek1(Secenek secenek1) {
        this.secenek1 = secenek1;
    }

    public Secenek getSecenek2() {
        return secenek2;
    }

    public void setSecenek2(Secenek secenek2) {
        this.secenek2 = secenek2;
    }

    public Secenek getSecenek3() {
        return secenek3;
    }

    public void setSecenek3(Secenek secenek3) {
        this.secenek3 = secenek3;
    }

    public Secenek getSecenek4() {
        return secenek4;
    }

    public void setSecenek4(Secenek secenek4) {
        this.secenek4 = secenek4;
    }

    public Secenek getDogruSecenek() {
        return dogruSecenek;
    }

    public void setDogruSecenek(Secenek dogruSecenek) {
        this.dogruSecenek = dogruSecenek;
    }
}
