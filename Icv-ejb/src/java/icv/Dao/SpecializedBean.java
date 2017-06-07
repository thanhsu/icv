/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icv.Dao;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import icv.Entity.User;
import icv.Entity.Specialized;
import java.util.List;
import javax.persistence.Query;
/**
 *
 * @author duyng
 */
@Stateless
@LocalBean
public class SpecializedBean {

    @PersistenceContext(unitName = "Icv-ejbPU")
    private EntityManager em;

    

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<Specialized> retriveAllSpecialized(){
        try{
        return em.createNamedQuery("Specialized.findAll").getResultList();}
        catch(Exception e){
            return null;
        }
    }
    
    public Specialized getSpecializedById(Short id){
       try{
        Query query = em.createNamedQuery("Specialized.findByIdSpecialized");
        query.setParameter("idSpecialized", id);
        return (Specialized) query.getSingleResult();}
       catch(Exception e){
           return null;
       }
    }
    
    public boolean updateSpecialized(Specialized spec){
        em.merge(spec);
        return true;
    }
    
    public boolean persistNewSpecialized(Specialized spec){
        em.persist(spec);
        return true;
    }
    
    public Specialized getSpecializedByName(String name){
       try{
        Query query = em.createNamedQuery("Specialized.findByName");
        query.setParameter("name", name);
        return (Specialized) query.getSingleResult();}
       catch(Exception e){
           return null;
       }
    }


    
}
