package com.esinav.bean;

import com.esinav.ejb.entity.Ders;
import com.esinav.ejb.ifacade.DersFacadeLocal;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by myavuz on 18.04.2014.
 */
@ManagedBean
@RequestScoped
public class DersMBean {

    private List<Ders> dersList;
    private Ders ders;
    private Boolean isIslemGuncelle=Boolean.FALSE;
    @EJB
    private DersFacadeLocal dersFacade;

    @PostConstruct
    public  void init() {
        ders=new Ders();
        dersList=dersFacade.findAll();
    }

    public void save() {
        if (validateDersAdi()) {
            dersFacade.save(ders);
            dersList.add(ders);
            giveSaveSuccesfullMessage();
        }
        else {
            giveDuplicationMessage();
        }


    }
    public void guncelle() {
        if (validateDersAdi()) {
            dersFacade.update(ders);
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

    public List<Ders> getDersList() {
        return dersList;
    }

    public Boolean getIsIslemGuncelle() {
        return isIslemGuncelle;
    }

    public void setIsIslemGuncelle(Boolean isIslemGuncelle) {
        this.isIslemGuncelle = isIslemGuncelle;
    }

    private void giveSaveSuccesfullMessage() {
        FacesContext context=FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Başarılı", "Kayıt Gerçekleşti"));
    }

    private void giveDuplicationMessage() {
        FacesContext context=FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Başarılı", "Kayıt Gerçekleşti"));

    }
    private Boolean validateDersAdi() {
        return !dersList.contains(ders);
    }


}
