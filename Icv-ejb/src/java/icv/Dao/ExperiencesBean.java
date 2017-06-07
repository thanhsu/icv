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
import icv.Entity.Specialized;
import icv.Entity.User;
import icv.Entity.Experiences;
import java.util.List;
import javax.persistence.Query;
/**
 *
 * @author duyng
 */
@Stateless
@LocalBean
public class ExperiencesBean {

    @PersistenceContext(unitName = "Icv-ejbPU")
    private EntityManager em;

    
    
    public List<Experiences> retriveAllExperiencesbyIdUser(Short iduser){
        try{
        Query query = em.createNamedQuery("Experiences.findByIdUser");
        query.setParameter("idUser", iduser);
        return query.getResultList();}
        catch(Exception e){
            return null;
        }
    }
    
    public Experiences retriveExperiencesbyIdUserIdSpec(Short idUser, Short idSpec){
        try{
            Query query = em.createNamedQuery("Experiences.findByIdSpecializedIdUser");
            query.setParameter("idSpecialized", idSpec);
            query.setParameter("idUser", idUser);
            return (Experiences) query.getSingleResult();
        }catch(Exception e){
            return null;
        }
        
    }
    
    public boolean removeExperiences(Short idUser, Short idSpec){
        try{
            Experiences exper = this.retriveExperiencesbyIdUserIdSpec(idUser, idSpec);
            em.remove(exper);
            return true;}
        catch(Exception e){
            return false;
        }
    }
    public boolean updateExperiences(Experiences exper){
        em.merge(exper);
        return true;
    }
    
    
    public void insertNewExperiences(Short year, String description, User user, Specialized spec ){
        Experiences exper = new Experiences(user.getIdUser(), spec.getIdSpecialized());
       
        exper.setDescription(description);
        exper.setYear(year);
        exper.setUser(user);
        exper.setSpecialized(spec);
        
        em.persist(exper);
        
        user.getExperiencesCollection().add(exper);
        spec.getExperiencesCollection().add(exper);
    }

    public void persist(Object object) {
        em.persist(object);
    }

   
    
}
