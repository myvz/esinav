/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.dao;

import com.esinav.ejb.entity.Ders;
import com.esinav.ejb.entity.Unite;
import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UniteDao extends GenericDao<Unite> {

    public UniteDao() {
        super(Unite.class);
    }

    public List<Unite> findByDersAndLevel(Ders ders) {
       Query query=em.createQuery("Select u from Unite u where u.ders.id=?1");
       query.setParameter(1,ders.getId());
       return query.getResultList();
    }
}
