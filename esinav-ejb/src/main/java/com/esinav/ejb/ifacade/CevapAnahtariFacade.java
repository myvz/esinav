/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esinav.ejb.ifacade;

import com.esinav.ejb.dao.CevapAnahtariDao;
import com.esinav.ejb.entity.Cevap;
import com.esinav.ejb.entity.CevapAnahtari;
import com.esinav.ejb.entity.Kullanici;
import com.esinav.ejb.entity.Sinav;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;


@Stateless
public class CevapAnahtariFacade implements CevapAnahtariFacadeLocal {


    @EJB
    private CevapAnahtariDao cevapAnahtariDao;
    
    @Override
    public void save(CevapAnahtari cevapAnahtari) {

        Integer dogruSayisi=0;
        Integer yanlisSayisi=0;
        Integer cevapSayisi=0;

        for (Cevap cevap : cevapAnahtari.getCevaplar()) {
            if (cevap.getKullaniciCevabi()==cevap.getSoru().getDogruSecenek()) {
                dogruSayisi++;
            }
            else {
                yanlisSayisi++;
            }
        }
        cevapSayisi=cevapAnahtari.getCevaplar().size();
        cevapAnahtari.setCevapSayisi(cevapSayisi);
        cevapAnahtari.setDogruSayisi(dogruSayisi);
        cevapAnahtari.setYanlisSayisi(yanlisSayisi);

        cevapAnahtariDao.save(cevapAnahtari);


    }

    @Override
    public CevapAnahtari update(CevapAnahtari cevapAnahtari) {
        return cevapAnahtariDao.update(cevapAnahtari);
    }

    @Override
    public void delete(CevapAnahtari cevapAnahtari) {
        cevapAnahtariDao.delete(cevapAnahtari);
    }

    @Override
    public CevapAnahtari find(Long entityID) {
        return cevapAnahtariDao.find(entityID);
    }

    @Override
    public List<CevapAnahtari> findAll(Sinav sinav) {
        return cevapAnahtariDao.findAll(sinav);
    }


}
