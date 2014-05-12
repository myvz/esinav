/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.dao;

import com.esinav.ejb.entity.Soru;
import javax.ejb.Stateless;

@Stateless
public class SoruDao extends GenericDao<Soru>{

    public SoruDao() {
        super(Soru.class);
    }

}
