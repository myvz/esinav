/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.ifacade;

import com.esinav.ejb.dao.UniteDao;
import com.esinav.ejb.entity.Unite;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author myavuz
 */
@Stateless
public class UniteFacade implements UniteFacadeLocal {

    @EJB
    private UniteDao uniteDao;
    
    @Override
    public void save(Unite unite) {
        uniteDao.save(unite);
    }

    @Override
    public void delete(Unite unite) {
        uniteDao.delete(unite);
    }

    @Override
    public Unite update(Unite unite) {
        return uniteDao.update(unite);
    }

    @Override
    public Unite find(Long entityID) {
        return uniteDao.find(entityID);
    }

    @Override
    public List<Unite> findAll() {
       return uniteDao.listAll();
    }

}
