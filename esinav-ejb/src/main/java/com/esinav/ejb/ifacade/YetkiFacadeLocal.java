/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.ifacade;

import com.esinav.ejb.entity.Yetki;
import java.util.List;
import javax.ejb.Local;


@Local
public interface YetkiFacadeLocal {
    public void save(Yetki yetki);
    public void delete(Yetki yetki);
    public Yetki update(Yetki yetki);
    public Yetki find(Long entityID);
    public List<Yetki> findAll();
    
}
