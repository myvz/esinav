/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esinav.ejb.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;


public abstract class GenericDao<T> {

    public static final String UNIT_NAME = "com.esinav.persistence";

    @PersistenceContext(unitName = UNIT_NAME)
    private EntityManager em;

    private Class<T> entitiyClass;

    public GenericDao(Class<T> entityClass) {
        this.entitiyClass = entityClass;

    }

    public void save(T entity) {
        System.out.println();
        em.persist(entity);
    }

    public void delete(T entity) {
        T entityTobeRemoved = em.merge(entity);
        em.remove(entityTobeRemoved);
    }

    public T update(T entity) {
        return em.merge(entity);
    }

    public T find(Long Id) {
        return em.find(entitiyClass, Id);
        

    }

    public List<T> listAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entitiyClass));
        return em.createQuery(cq).getResultList();
    }

    
    protected T findOneResult (String namedQuery,Map<String,Object> parameters) {
        T result=null;
        Query query=em.createNamedQuery(namedQuery);
        if (parameters!=null && !parameters.isEmpty()) {
           for (Entry<String, Object> entry : parameters.entrySet()) {
                    query.setParameter(entry.getKey(), entry.getValue());
            }
        }
        result=(T)query.getSingleResult();
        return result;
        
    }
   

}
