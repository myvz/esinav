/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.ifacade;

import com.esinav.ejb.dao.CevapAnahtariDao;
import com.esinav.ejb.entity.CevapAnahtari;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
public class CevapAnahtariFacade implements CevapAnahtariFacadeLocal {


    @EJB
    private CevapAnahtariDao cevapAnahtariDao;
    
    @Override
    public void save(CevapAnahtari cevapAnahtari) {
        cevapAnahtariDao.save(cevapAnahtari);
    }

    @Override
    public CevapAnahtari update(CevapAnahtari cevapAnahtari) {
        return cevapAnahtariDao.update(cevapAnahtari);
    }

    @Override
    public void delete(CevapAnahtari cevapAnahtari) {
        cevapAnahtariDao.delete(cevapAnahtari);
    }

    @Override
    public CevapAnahtari find(Long entityID) {
        return cevapAnahtariDao.find(entityID);
    }

    
}
