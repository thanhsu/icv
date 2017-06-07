/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icv.Dao;

import icv.Entity.Storeimage;
import java.util.List;
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
public class StoreImageBean {

    @PersistenceContext(unitName = "Icv-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public Storeimage retriveByIdUser(Short iduser){
       try{ Query query = em.createNamedQuery("Storeimage.findByIdUser");
        query.setParameter("IdUser", iduser);
        query.setMaxResults(1);
        return (Storeimage)query.getSingleResult();}
       catch(Exception e){
           return null;
       }
    }
    
    public Storeimage retriveByIdImage(Short idImage){
        try{
            Query query = em.createNamedQuery("Storeimage.findByIdImage");
            query.setParameter("idImage", idImage);
            return (Storeimage)query.getSingleResult();}
        catch(Exception e){
            return null;
        }
    }
    
    public Storeimage retriveByNote(String note){
        Query query = em.createNamedQuery("Storeimage.findByNote");
        query.setParameter("note", note);
        return (Storeimage)query.getSingleResult();
    }
    
    public List<Storeimage> retriveBytypeImage(Short type){
        Query query = em.createNamedQuery("Storeimage.findByTypeImage");
        query.setParameter("typeImage", type);
        return query.getResultList();
    }
    
    public void persistNewImage(Storeimage img){
        em.persist(img);
    }
    
    public void updateNewImage(Storeimage img){
        em.merge(img);
        
    }
    
}
