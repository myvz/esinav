/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.ifacade;

import com.esinav.ejb.dao.SinavDao;
import com.esinav.ejb.entity.Sinav;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author myavuz
 */
@Stateless
public class SinavFacade implements SinavFacadeLocal {

    @EJB
    private SinavDao sinavDao;
    
    @Override
    public void save(Sinav sinav) {
        sinavDao.save(sinav);
    }

    @Override
    public void delete(Sinav sinav) {
        sinavDao.delete(sinav);
    }

    @Override
    public Sinav find(Long entityID) {
       return  sinavDao.find(entityID);
    }

    @Override
    public Sinav update(Sinav sinav) {
        return sinavDao.update(sinav);
    }

    @Override
    public List<Sinav> findAll() {
        return sinavDao.listAll();
    }

    
}
