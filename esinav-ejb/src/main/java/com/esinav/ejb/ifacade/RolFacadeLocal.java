/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.ifacade;

import com.esinav.ejb.entity.Rol;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author myavuz
 */
@Local
public interface RolFacadeLocal {
    public void save(Rol rol);
    public Rol update(Rol rol);
    public Rol find(Long EntityID);
    public void delete(Rol rol);
    public List<Rol> findAll();
    
}
