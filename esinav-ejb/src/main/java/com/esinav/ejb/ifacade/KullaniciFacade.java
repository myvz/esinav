/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.ifacade;

import com.esinav.ejb.dao.KullaniciDao;
import com.esinav.ejb.entity.Kullanici;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class KullaniciFacade implements KullaniciFacadeLocal {

    @EJB
    private KullaniciDao kullaniciDao;
    
    @Override
    public void save(Kullanici kullanici) {
       kullaniciDao.save(kullanici);
    }

    @Override
    public Kullanici update(Kullanici kullanici) {
       return kullaniciDao.update(kullanici);
    }

    @Override
    public Kullanici find(Long entityID) {
        return kullaniciDao.find(entityID);
    }

    @Override
    public void delete(Kullanici kullanici) {
        kullaniciDao.delete(kullanici);
    }

    @Override
    public List<Kullanici> findAll() {
        return kullaniciDao.listAll();
               
    }

    @Override
    public Kullanici findKullaniciByKullaniciAdi(String kullaniciAdi) {
        return kullaniciDao.findUserByKullaniciAdi(kullaniciAdi);
    }

    @Override
    public List<Kullanici> findAllStudents() {
        return kullaniciDao.findAllStudents();
    }


}
