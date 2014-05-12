
package com.esinav.ejb.ifacade;

import com.esinav.ejb.dao.YetkiDao;
import com.esinav.ejb.entity.Yetki;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class YetkiFacade implements YetkiFacadeLocal {

    @EJB
    private YetkiDao yetkiDao;
    
    
    @Override
    public void save(Yetki yetki) {
        yetkiDao.save(yetki);
    }

    @Override
    public void delete(Yetki yetki) {
        yetkiDao.delete(yetki);
    }

    @Override
    public Yetki update(Yetki yetki) {
        return yetkiDao.update(yetki);
    }

    @Override
    public Yetki find(Long entityID) {
        return yetkiDao.find(entityID);
    }

    @Override
    public List<Yetki> findAll() {
       return yetkiDao.listAll();
    }
}
