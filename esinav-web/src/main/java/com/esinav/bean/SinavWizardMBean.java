package com.esinav.bean;

import com.esinav.controller.LoginController;
import com.esinav.ejb.entity.Kullanici;
import com.esinav.ejb.entity.Sinav;
import com.esinav.ejb.entity.Soru;
import com.esinav.ejb.ifacade.KullaniciFacadeLocal;
import com.esinav.ejb.ifacade.SinavFacadeLocal;
import org.primefaces.event.FlowEvent;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@ManagedBean
@ViewScoped
public class SinavWizardMBean implements Serializable {

    private Sinav sinav;
    private List<Soru> soruList;
    private List<Soru> sinavSorulari;
    private List<Kullanici> kullaniciList;
    private List<Kullanici> studentList;
    private boolean skip;
    private Soru selectedSoru;

    @EJB
    private SinavFacadeLocal sinavFacade;

    @EJB
    private KullaniciFacadeLocal kullaniciFacade;

    @ManagedProperty(value = "#{soruMBean}")
    private SoruMBean soruMBean;

    @Inject
    private LoginController loginController;



    @PostConstruct
    public void init() {
        sinav=new Sinav();
        soruList=new ArrayList<Soru>();
        sinavSorulari=new ArrayList<Soru>();
    }

    public Sinav getSinav() {
        return sinav;
    }

    public void setSinav(Sinav sinav) {
        this.sinav = sinav;
    }


    public List<Soru> getSoruList() {
        return soruList;
    }

    public void setSoruList(List<Soru> soruList) {
        this.soruList = soruList;
        sinavSorulari.addAll(soruList);

    }

    public List<Kullanici> getKullaniciList() {
        if (kullaniciList==null) kullaniciList=kullaniciFacade.findAllStudents();
        return kullaniciList;
    }

    public void setKullaniciList(List<Kullanici> kullaniciList) {
        this.kullaniciList = kullaniciList;
    }

    public List<Kullanici> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Kullanici> studentList) {
        this.studentList = studentList;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }

    public SoruMBean getSoruMBean() {
        return soruMBean;
    }

    public void setSoruMBean(SoruMBean soruMBean) {
        this.soruMBean = soruMBean;
    }


    public List<Soru> getSinavSorulari() {
        return sinavSorulari;
    }

    public void setSinavSorulari(List<Soru> sinavSorulari) {
        this.sinavSorulari = sinavSorulari;
    }

    public void save() {
        sinav.setKullanicilar(studentList);
        sinav.setSorular(sinavSorulari);
        sinav.setSinavSahibi(loginController.getKullanici());
        sinavFacade.save(sinav);
        giveSaveSuccesfullMessage();
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
    private void giveSaveSuccesfullMessage() {
        FacesContext context=FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Basarili", "Sinav Oluşturuldu"));
    }
}
