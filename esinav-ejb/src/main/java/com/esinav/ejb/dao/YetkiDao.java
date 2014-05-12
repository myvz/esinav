/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.dao;

import com.esinav.ejb.entity.Yetki;

import javax.ejb.Stateless;

@Stateless
public class YetkiDao extends GenericDao<Yetki> {

    public YetkiDao() {
        super(Yetki.class);
    }
    
}
