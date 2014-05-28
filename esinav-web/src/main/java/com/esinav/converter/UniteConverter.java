package com.esinav.converter;

import com.esinav.ejb.ifacade.UniteFacadeLocal;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class UniteConverter implements Converter {

    @EJB
    private UniteFacadeLocal uniteFacade;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
       return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return null;
    }
}
