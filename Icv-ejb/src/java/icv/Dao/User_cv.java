/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icv.Dao;

import icv.Entity.Cv;
import icv.Entity.Storecv;
import icv.Entity.User;
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
public class User_cv {

    @PersistenceContext(unitName = "Icv-ejbPU")
    private EntityManager em;

   
    public void persist(Object object) {
        em.persist(object);
    }
    
    public boolean insertCv(Cv cv){
        persist(cv);
        return true;
    }
    
    public Storecv retriveStoreCvbyIdUser(Short idUser){
        Query query = em.createNamedQuery("Storecv.findByIdUser");
        query.setParameter("idUser", idUser);
        
        return (Storecv)query.getSingleResult();
    }
    
    public boolean insertStoreCv(User user){
        Storecv storecv = new Storecv();
        storecv.setIdUser(user);
        
        em.persist(storecv);
        user.getStorecvCollection().add(storecv);
        
        return true;
                
    }


    
}
