/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.dao;

import com.esinav.ejb.entity.Soru;
import com.esinav.ejb.entity.Unite;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class SoruDao extends GenericDao<Soru>{

    public SoruDao() {
        super(Soru.class);
    }

    public List<Soru> getSoruList(Unite unite) {
        Query query=em.createQuery("Select s from Soru s where s.unite.id=?1");
        query.setParameter(1,unite.getId());
        return query.getResultList();
    }
}
