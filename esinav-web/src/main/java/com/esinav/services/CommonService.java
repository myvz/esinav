package com.esinav.services;

import com.esinav.ejb.entity.Ders;
import com.esinav.ejb.ifacade.DersFacadeLocal;
import com.esinav.ejb.ifacade.UniteFacadeLocal;


import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

/**
 * Created by myavuz on 23.05.2014.
 */
@ManagedBean(name = "commonService")
@ApplicationScoped
public class CommonService {

    @EJB
    private DersFacadeLocal dersFacade;
    @EJB
    private UniteFacadeLocal uniteFacade;

    private Boolean dirty=true;
    private List<Ders> dersList;

    public Ders getDers(Long id) {
        return  dersFacade.find(id);

    }
    public List<Ders> getDersList() {
        if (dirty) {
            dersList=dersFacade.findAll();
        }
        dirty=false;
        return dersList;
    }

    public Ders getDersWithUnits(Ders ders) {
        return dersFacade.findDersByName(ders.getDersAdi());
    }

    public void addDers(Ders ders) {
        dersFacade.save(ders);
        dirty=true;
    }

    public Ders updateDers(Ders ders) {
        dirty=true;
        return dersFacade.update(ders);
    }

    public Boolean isDersNameAvailable(Ders ders) {
        return !dersList.contains(ders);
    }
}
