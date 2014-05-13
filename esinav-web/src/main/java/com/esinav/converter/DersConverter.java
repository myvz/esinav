package com.esinav.converter;

import com.esinav.ejb.entity.Ders;
import com.esinav.ejb.ifacade.DersFacadeLocal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
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

    @EJB
    private DersFacadeLocal dersFacade;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {

        if (s==null || s.length()==0) return null;
        return dersFacade.findDersByName(s);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return o.toString();
    }
}
