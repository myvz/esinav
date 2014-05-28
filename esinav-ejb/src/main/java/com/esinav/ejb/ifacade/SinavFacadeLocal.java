/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.ifacade;

import com.esinav.ejb.entity.Kullanici;
import com.esinav.ejb.entity.Sinav;
import java.util.List;
import javax.ejb.Local;


@Local
public interface SinavFacadeLocal {
    
    public void save(Sinav sinav);
    public void delete(Sinav sinav);
    public Sinav find(Long entityID);
    public Sinav update(Sinav sinav);
    public List<Sinav> findAll();
    public List<Sinav> getKullaniciSinav(Kullanici kullanici);

}
