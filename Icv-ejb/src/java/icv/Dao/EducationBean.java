/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icv.Dao;

import icv.Entity.Education;
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
public class EducationBean {

    @PersistenceContext(unitName = "Icv-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    public List<Education> retriveAll(){
        return em.createNamedQuery("Education.findAll").getResultList();
    }
    
    public Education retriveEducationByTitleAndDetail(String title, String detail){
        try{
            Query  query= em.createNamedQuery("Education.findByTitileandDetail");
            query.setParameter("title", title);
            query.setParameter("detail", detail);
            return (Education)query.getSingleResult();
        }catch(Exception e){
            return null;
        }
    
    }
    public Education retriveById(String id){
        try{
            Query query = em.createNamedQuery("Education.findByIdEducation");
            query.setParameter("idEducation", Integer.valueOf(id));
            
            return (Education)query.getSingleResult();
        }
        catch(Exception e){
            return null;
        }
    }
    

   
}
