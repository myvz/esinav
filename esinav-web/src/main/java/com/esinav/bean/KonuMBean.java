package com.esinav.bean;

import com.esinav.ejb.entity.Ders;
import com.esinav.ejb.entity.Unite;
import com.esinav.ejb.ifacade.UniteFacadeLocal;
import com.esinav.services.CommonService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;


@ManagedBean
@RequestScoped
public class KonuMBean implements Serializable {

    private Unite unite;
    private List<Unite> uniteList;
    private Ders selectedDers;
    @EJB
    private UniteFacadeLocal uniteFacade;

    @ManagedProperty(value = "#{commonService}")
    private CommonService commonService;

    @PostConstruct
    public void init () {
        unite=new Unite();
    }

    public void save() {
        uniteFacade.save(unite);
        giveSaveSuccesfullMessage();
        unite=new Unite();
    }

    public void update(Unite unite) {
        uniteFacade.update(unite);
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }

    public Ders getSelectedDers() {
        return selectedDers;
    }

    public void setSelectedDers(Ders selectedDers) {
        this.selectedDers = selectedDers;
    }

    private void giveSaveSuccesfullMessage() {
        FacesContext context=FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Basarili", "Kayit Gerceklesti"));
    }

    private void giveDuplicationMessage() {
        FacesContext context=FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Basarili", "Kayit Gerceklesti"));

    }

    public CommonService getCommonService() {
        return commonService;
    }

    public void setCommonService(CommonService commonService) {
        this.commonService = commonService;
    }

    public List<Unite> getUniteList() {
        selectedDers=commonService.getDersWithUnits(selectedDers);
        uniteList=selectedDers.getUniteler();
        return uniteList;
    }

    public void setUniteList(List<Unite> uniteList) {
        this.uniteList = uniteList;
    }
}
