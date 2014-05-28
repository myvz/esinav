/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.ifacade;

import com.esinav.ejb.dao.SoruDao;
import com.esinav.ejb.entity.Soru;
import com.esinav.ejb.entity.Unite;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SoruFacade implements SoruFacadeLocal {

    @EJB
    private SoruDao soruDao;

    @Override
    public void save(Soru soru) {
        soruDao.save(soru);
    }

    @Override
    public void delete(Soru soru) {
        soruDao.delete(soru);
    }

    @Override
    public Soru find(Long entityID) {
        return soruDao.find(entityID);
    }

    @Override
    public Soru update(Soru soru) {
        return soruDao.update(soru);
    }

    @Override
    public List<Soru> findAll() {
        return soruDao.listAll();
    }

    @Override
    public List<Soru> getSoruList(Unite unite) {
        return soruDao.getSoruList(unite);
    }
}
