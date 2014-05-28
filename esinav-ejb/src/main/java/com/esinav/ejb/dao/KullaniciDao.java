/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.dao;

import com.esinav.ejb.entity.Kullanici;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class KullaniciDao extends GenericDao<Kullanici> {

    public KullaniciDao() {
        super(Kullanici.class);
    }
    
    public Kullanici findUserByKullaniciAdi(String username) {
        Map<String,Object> parameters=new HashMap<>();
        parameters.put("username", username);
        return super.findOneResult(Kullanici.FIND_BY_USERNAME, parameters);
    }

    public List<Kullanici> findAllStudents() {
        Query query=em.createQuery("Select k from Kullanici k left join k.roller r where r.rolAdi=?1");
        query.setParameter(1,"student");
        return query.getResultList();
    }
}
