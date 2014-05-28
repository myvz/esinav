package com.esinav.bean;

import com.esinav.ejb.entity.Ders;
import com.esinav.ejb.entity.Soru;
import com.esinav.ejb.entity.Unite;
import com.esinav.ejb.ifacade.SoruFacadeLocal;
import com.esinav.services.CommonService;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;


@ManagedBean
@ViewScoped
public class SoruMBean implements Serializable {

    @ManagedProperty(value = "#{commonService}")
    private CommonService commonService;

    @EJB
    private SoruFacadeLocal soruFacade;

    private List<Soru> soruList;

    private Ders ders;

    private Unite unite;

    public CommonService getCommonService() {
        return commonService;
    }

    public void setCommonService(CommonService commonService) {
        this.commonService = commonService;
    }

    public Ders getDers() {
        return ders;
    }

    public void setDers(Ders ders) {

        this.ders = commonService.getDersWithUnits(ders);
        soruList=null;
    }

    public List<Soru> getSoruList() {
        return soruList;
    }

    public void setSoruList(List<Soru> soruList) {
        this.soruList = soruList;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }

    public void onRowSelect(SelectEvent event) {
        soruList=soruFacade.getSoruList(unite);
    }
    public void sorgula() {
        soruList=soruFacade.getSoruList(unite);
    }
    public void onRowUnselect(UnselectEvent event) {

    }
}
