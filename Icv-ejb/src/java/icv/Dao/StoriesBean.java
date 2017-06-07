/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icv.Dao;

import icv.Entity.Stories;
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
public class StoriesBean {

    @PersistenceContext(unitName = "Icv-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<Stories> retriveallStories(){
        try{
            return em.createNamedQuery("Stories.findAll").getResultList();}
        catch(Exception e){
            return null;
        }
    }
    
    public Stories retriveByTitle(String title){
        try{
            Query query = em.createNamedQuery("Stories.findByTitle");
            query.setParameter("title", title);
            return (Stories)query.getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
    
    public void ChangeAccess(Short id){
        Stories st = this.retriveById(id);
        st.setAccess(!st.getAccess());
        em.merge(st);
        List<Stories> lst = em.createNamedQuery("Stories.findByTitle").setParameter("title", st.getTitle()).getResultList();
        if(lst.size() > 1)
            em.remove(lst.get(0));  
    }
            
    public Stories retriveById(Short id){
        try{
            Query query = em.createNamedQuery("Stories.findByIdStories");
            query.setParameter("idStories", id);
            return (Stories)query.getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
    public List<Stories> retriveAllAccess(){
        try{
            Query query = em.createNamedQuery("Stories.findByAccess");
            query.setParameter("access", Boolean.TRUE);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
    }
    
    public void persistnewStories(Stories stories){
        em.persist(stories);
    }
    
    public void updateStories(Stories stories){
        em.merge(stories);
    }
    
}
