/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.ifacade;

import com.esinav.ejb.entity.Ders;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author myavuz
 */
@Local
public interface DersFacadeLocal {
    
    
    public void save(Ders ders);
    public Ders update(Ders ders);
    public Ders find(Long entityID);
    public void delete(Ders ders);
    public List<Ders> findAll();
    public Ders findDersByName(String dersAdi) ;
    
}
