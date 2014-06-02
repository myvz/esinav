/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.dao;

import com.esinav.ejb.entity.CevapAnahtari;
import com.esinav.ejb.entity.Kullanici;
import com.esinav.ejb.entity.Sinav;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CevapAnahtariDao extends GenericDao<CevapAnahtari>{

    public CevapAnahtariDao() {
        super(CevapAnahtari.class);
    }

    public List<CevapAnahtari> findAll(Sinav sinav) {
        Query query=em.createQuery("select ca from CevapAnahtari ca join fetch ca.kullanici where ca.sinav.id=?1");
        query.setParameter(1,sinav.getId());
        return query.getResultList();
    }
    
}
