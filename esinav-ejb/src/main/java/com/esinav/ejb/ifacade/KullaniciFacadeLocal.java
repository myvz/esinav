/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.ifacade;

import com.esinav.ejb.entity.Kullanici;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author myavuz
 */
@Local
public interface KullaniciFacadeLocal {
    public void save(Kullanici kullanici);
    public Kullanici update(Kullanici kullanici);
    public Kullanici find(Long entityID);
    public void delete(Kullanici kullanici);
    public List<Kullanici> findAll();
    public Kullanici findKullaniciByKullaniciAdi(String kullaniciAdi);
}
