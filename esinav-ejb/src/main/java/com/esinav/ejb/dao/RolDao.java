/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.dao;

import com.esinav.ejb.entity.Rol;

import javax.ejb.Stateless;

@Stateless
public class RolDao extends GenericDao<Rol> {

    public RolDao() {
        super(Rol.class);
    }
    
    
}
