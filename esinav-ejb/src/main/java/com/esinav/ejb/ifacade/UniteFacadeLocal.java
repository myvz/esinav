/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.ifacade;

import com.esinav.ejb.entity.Unite;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author myavuz
 */
@Local
public interface UniteFacadeLocal {
    public void save(Unite unite);
    public void delete(Unite unite);
    public Unite update(Unite unite);
    public Unite find(Long entityID);
    public List<Unite> findAll();
}
