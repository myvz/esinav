package com.esinav.bean;

import com.esinav.ejb.ifacade.DersFacadeLocal;
import com.esinav.ejb.ifacade.UniteFacade;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by myavuz on 20.05.2014.
 */
@Named
@ApplicationScoped
public class DersUniteService implements Serializable {

    @EJB
    private DersFacadeLocal dersFacade;
    @EJB
    private UniteFacade uniteFacade;




}
