/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.ifacade;

import com.esinav.ejb.dao.DersDao;
import com.esinav.ejb.entity.Ders;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author myavuz
 */
@Stateless
public class DersFacade implements DersFacadeLocal {

    @EJB
    private DersDao dersDao;
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(Ders ders) {
        dersDao.save(ders);
    }

    @Override
    public Ders update(Ders ders) {
        return dersDao.update(ders);
    }
    @Override
    public Ders find(Long entityID) {
       return dersDao.find(entityID);
    }

    @Override
    public void delete(Ders ders) {
        dersDao.delete(ders);
    }

    @Override
    public List<Ders> findAll() {
        return dersDao.listAll();
    }

    @Override
    public Ders findDersByName(String dersAdi) {
        return dersDao.findDersByName(dersAdi);
    }
}
