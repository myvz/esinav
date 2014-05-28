/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.ifacade;

import com.esinav.ejb.entity.CevapAnahtari;
import javax.ejb.Local;


@Local
public interface CevapAnahtariFacadeLocal {
    
    public void save(CevapAnahtari cevapAnahtari);
    public CevapAnahtari update(CevapAnahtari cevapAnahtari);
    public void delete(CevapAnahtari cevapAnahtari);
    public CevapAnahtari find(Long entityID);
    
    
}
