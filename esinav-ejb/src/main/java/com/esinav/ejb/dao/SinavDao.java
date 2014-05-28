/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.dao;

import com.esinav.ejb.entity.Kullanici;
import com.esinav.ejb.entity.Sinav;
import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class SinavDao extends GenericDao<Sinav> {

    public SinavDao() {
        super(Sinav.class);
    }

    public List<Sinav> getKullaniciSinav(Kullanici kullanici) {
        Query query=em.createQuery("select s from Sinav s join s.kullanicilar k where k.id =?1");
        query.setParameter(1,kullanici.getId()) ;
        List<Sinav> sinavList=query.getResultList();
        return sinavList;
    }
    
}
