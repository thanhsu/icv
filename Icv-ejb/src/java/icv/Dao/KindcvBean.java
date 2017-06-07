/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icv.Dao;

import icv.Entity.Kindcv;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author duyng
 */
@Stateless
@LocalBean
public class KindcvBean {

    @PersistenceContext(unitName = "Icv-ejbPU")
    private EntityManager em;

    

    public void persist(Object object) {
        em.persist(object);
    }
    
    public Kindcv retriveKindcvbyName(String name){
        Query query = em.createNamedQuery("Kindcv.findByName");
        query.setParameter("name", name);
        return (Kindcv) query.getSingleResult();
    }

   
    
}
