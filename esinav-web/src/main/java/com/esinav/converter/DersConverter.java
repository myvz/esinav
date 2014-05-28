package com.esinav.converter;

import com.esinav.ejb.entity.Ders;
import com.esinav.services.CommonService;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.io.Serializable;


@FacesConverter("dersConverter")
public class DersConverter implements Converter,Serializable{


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s.isEmpty()) return null;
        CommonService commonService=(CommonService)facesContext.getApplication().evaluateExpressionGet(facesContext,"#{commonService}",CommonService.class);
        return commonService.getDers(Long.parseLong(s));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o==null || o.toString().isEmpty()) return "";
        return ((Ders)o).getId().toString();
    }

}
