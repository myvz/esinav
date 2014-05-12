package com.esinav.ejb.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Leyla
 */
@Entity
public class Secenek implements Serializable{
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @Column(name = "SECENEK")
   private String secenek;
  

   public Long getId() {
        return id;
   }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSecenek(String secenek) {
        this.secenek = secenek;
    }


    public String getSecenek() {
        return secenek;
    }



    
    
}
