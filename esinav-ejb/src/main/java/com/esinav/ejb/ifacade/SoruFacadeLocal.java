/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.ifacade;

import com.esinav.ejb.entity.Soru;
import com.esinav.ejb.entity.Unite;

import java.util.List;
import javax.ejb.Local;


@Local
public interface SoruFacadeLocal {
    public void save(Soru soru);
    public void delete(Soru soru);
    public Soru find(Long entityID);
    public Soru update(Soru soru);
    public List<Soru> findAll();
    List<Soru> getSoruList(Unite unite);
}
