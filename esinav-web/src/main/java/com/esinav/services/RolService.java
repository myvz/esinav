package com.esinav.services;

import com.esinav.ejb.entity.Kullanici;
import com.esinav.ejb.entity.Rol;
import com.esinav.ejb.ifacade.RolFacadeLocal;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;


@ManagedBean
@ApplicationScoped
public class RolService implements Serializable {

    @EJB
    private RolFacadeLocal rolFacade;

    private List<Rol> RolList;

    public Boolean isAdmin(Kullanici kullanici) {

        List<Rol> roller= (List<Rol>) kullanici.getRoller();
        for (Rol rol :roller) {
            if (rol.getRolAdi().equals("admin")) return true;
        }
        return false;
    }

    public Boolean isStudent(Kullanici kullanici) {


        List<Rol> roller= (List<Rol>) kullanici.getRoller();
        for (Rol rol :roller) {
            if (rol.getRolAdi().equals("student")) return true;
        }
        return false;
    }

    public Boolean isTeacher(Kullanici kullanici) {

        List<Rol> roller= (List<Rol>) kullanici.getRoller();
        for (Rol rol :roller) {
            if (rol.getRolAdi().equals("teacher")) return true;
        }
        return false;
    }
}
