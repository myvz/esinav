package com.esinav.bean;

import com.esinav.ejb.entity.Ders;
import com.esinav.ejb.ifacade.DersFacadeLocal;
import com.esinav.services.CommonService;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;


@ManagedBean
@RequestScoped
public class DersMBean implements Serializable{


    private Ders ders;
    private Boolean isIslemGuncelle=Boolean.FALSE;

    @ManagedProperty(value = "#{commonService}")
    private CommonService commonService;

    @PostConstruct
    public  void init() {
        ders=new Ders();

    }

    public void save() {
        if (validateDersAdi()) {
            commonService.addDers(ders);
            giveSaveSuccesfullMessage();
        }
        else {
            giveDuplicationMessage();
        }
        init();
    }
    public void guncelle() {
        if (validateDersAdi()) {
            commonService.updateDers(ders);
            giveSaveSuccesfullMessage();
        }
        else {
            giveDuplicationMessage();
        }
    }

    public Ders getDers() {
        return ders;
    }

    public void setDers(Ders ders) {
        this.ders = ders;
    }



    public Boolean getIsIslemGuncelle() {
        return isIslemGuncelle;
    }

    public void setIsIslemGuncelle(Boolean isIslemGuncelle) {
        this.isIslemGuncelle = isIslemGuncelle;
    }

    private void giveSaveSuccesfullMessage() {
        FacesContext context=FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Basarili", "Kayit Gerceklesti"));
    }

    private void giveDuplicationMessage() {
        FacesContext context=FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Basarisiz", "Eklenen ders zaten mevcut"));

    }
    private Boolean validateDersAdi() {
        return commonService.isDersNameAvailable(ders);
    }

    public CommonService getCommonService() {
        return commonService;
    }

    public void setCommonService(CommonService commonService) {
        this.commonService = commonService;
    }
}
