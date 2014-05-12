/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.dao;

import com.esinav.ejb.entity.Kullanici;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

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
}
