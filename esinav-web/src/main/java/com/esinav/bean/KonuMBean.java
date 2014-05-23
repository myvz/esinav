package com.esinav.bean;

import com.esinav.ejb.entity.Ders;
import com.esinav.ejb.entity.Unite;
import com.esinav.ejb.ifacade.DersFacadeLocal;
import com.esinav.ejb.ifacade.UniteFacadeLocal;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by myavuz on 13.05.2014.
 */
@ManagedBean
@RequestScoped
public class KonuMBean implements Serializable {

    private Unite unite;
    private Ders selectedDers;
    private List<Ders> dersList;

    @EJB
    private UniteFacadeLocal uniteFacade;
    @EJB
    private DersFacadeLocal dersFacade;

    @PostConstruct
    public void init () {
        unite=new Unite();
        if (dersList==null || dersList.size()==0)
            dersList=dersFacade.findAll();
    }

    public void save() {
        unite.getDers().getUniteler().add(unite);
        uniteFacade.save(unite);
        giveSaveSuccesfullMessage();
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

    public List<Ders> getDersList() {
        return dersList;
    }
    private void giveSaveSuccesfullMessage() {
        FacesContext context=FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Başarılı", "Kayıt Gerçekleşti"));
    }

    private void giveDuplicationMessage() {
        FacesContext context=FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Başarılı", "Kayıt Gerçekleşti"));

    }
}
