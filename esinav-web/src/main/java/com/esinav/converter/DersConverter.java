package com.esinav.converter;

import com.esinav.ejb.entity.Ders;
import com.esinav.ejb.ifacade.DersFacadeLocal;
import com.esinav.ejb.ifacade.UniteFacadeLocal;
import com.esinav.services.CommonService;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.io.Serializable;

/**
 * Created by myavuz on 13.05.2014.
 */
@FacesConverter(forClass = Ders.class,value = "dersConverter")
@ManagedBean
public class DersConverter implements Converter,Serializable{

   @ManagedProperty(value = "#{commonService}")
   private CommonService commonService;



    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s.isEmpty()) return null;
        return commonService.getDers(Long.parseLong(s));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o==null) return null;
        return ((Ders)o).getId().toString();
    }

    public CommonService getCommonService() {
        return commonService;
    }

    public void setCommonService(CommonService commonService) {
        this.commonService = commonService;
    }
}
