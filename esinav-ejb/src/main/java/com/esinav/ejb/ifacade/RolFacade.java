/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.ifacade;

import com.esinav.ejb.dao.RolDao;
import com.esinav.ejb.entity.Rol;
import java.util.List;
import javax.ejb.Stateless;


@Stateless
public class RolFacade implements RolFacadeLocal {

    private RolDao rolDao;
    @Override
    public void save(Rol rol) {
        rolDao.save(rol);
    }

    @Override
    public Rol update(Rol rol) {
        return rolDao.update(rol);
    }

    @Override
    public Rol find(Long EntityID) {
        return rolDao.find(EntityID);
    }

    @Override
    public List<Rol> findAll() {
        return rolDao.listAll();
    }

    @Override
    public void delete(Rol rol) {
        rolDao.delete(rol);
    }


}
